/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp.tracciato;

import it.mds.sdk.flusso.osp.parser.regole.RecordDtoOsp;
import it.mds.sdk.flusso.osp.parser.regole.conf.ConfigurazioneFlussoOsp;
import it.mds.sdk.flusso.osp.tracciato.output.Dataroot;
import it.mds.sdk.libreriaregole.tracciato.TracciatoSplitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.net.URL;
import java.nio.file.Path;
import java.util.*;

@Slf4j
@Component("tracciatoSplitter")
public class TracciatoSplitterImpl implements TracciatoSplitter<RecordDtoOsp> {

    private static final String XML_FILENAME_TEMPLATE = "SDK_OSP_OSP_%s_%s.xml" ;
    @Override
    //TODO probabilmente va eliminato
    public List<Path> dividiTracciato(Path tracciato) {
        return Collections.emptyList();
    }

    @Override
    public List<Path> dividiTracciato(List<RecordDtoOsp> records, String idRun) {

        ConfigurazioneFlussoOsp conf = new ConfigurazioneFlussoOsp();
        String fileName = String.format(XML_FILENAME_TEMPLATE,records.get(0).getCampiInput().getPeriodoRiferimentoInput(), idRun);
        Path xml = Path.of(conf.getXmlOutput().getPercorso(),fileName);

        try {
            URL urlXsd = this.getClass().getClassLoader().getResource("OSP.xsd");
            log.debug("URL dell'XSD per la validazione idrun {} : {}", idRun, urlXsd);


            return List.of(xml);


        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            log.error("[{}].dividiTracciato  - records[{}]  - idRun[{}] -" + e.getMessage(),
                    this.getClass().getName(),
                    e
            );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossibile validare il csv in ingresso. message: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private Dataroot.REGIONE creaRegione(String codiceRegione) {
        Dataroot.REGIONE regioneEr = new Dataroot.REGIONE();
        regioneEr.setCodReg(codiceRegione);
        return regioneEr;
    }

    private Dataroot.REGIONE.PERIODO creaPeriodo(String anno, String mese) {
        Dataroot.REGIONE.PERIODO periodo = new Dataroot.REGIONE.PERIODO();
        periodo.setAnno(anno);
        periodo.setMese(mese);
        return periodo;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE creaOperazione(String operazione) {
        Dataroot.REGIONE.PERIODO.OPERAZIONE op = new Dataroot.REGIONE.PERIODO.OPERAZIONE();
        op.setTipoOp(operazione);
        return op;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE.AS creaAziendaSanitaria(String as) {
        Dataroot.REGIONE.PERIODO.OPERAZIONE.AS aziendaSanitaria = new Dataroot.REGIONE.PERIODO.OPERAZIONE.AS();
        aziendaSanitaria.setCodAs(as);
        return aziendaSanitaria;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA creaStruttura(String codStr, String tipo_str) {
        Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA struttura = new Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA();
        struttura.setCodStr(codStr);
        struttura.setTipoStr(tipo_str);
        return struttura;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP creaUnitaOperativa(String codUnitaOp) {
        Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP unitaOperativa = new Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP();
        unitaOperativa.setCodUnOp(codUnitaOp);
        return unitaOperativa;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE creaMedicinale(
            String codRegAtt, String tipMed, String codMed, String costoAcq, String qta, Integer fattConv
    ) {
        Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE medicinale = new Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE();
        medicinale.setCodRegAtt(codRegAtt);
        medicinale.setTipMed(tipMed);
        medicinale.setCodMed(codMed);
        medicinale.setCostoAcq(costoAcq);
        medicinale.setQta(qta);
        medicinale.setFattConv(fattConv);
        return medicinale;
    }

    private Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE creaTargature() {
        return new Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE();
    }


    public Dataroot creaDataroot(List<RecordDtoOsp> records, Dataroot dataRoot) {
        if (dataRoot == null) {
            dataRoot = new Dataroot();
            //imposto la regione che è unica per il file
            Dataroot.REGIONE regione = creaRegione(records.get(0).getCodiceRegione());
            //imposto il periodo che è unico per il file
            Dataroot.REGIONE.PERIODO periodo = creaPeriodo(records.get(0).getAnnoConsegna(), records.get(0).getMeseConsegna());
            regione.setPERIODO(periodo);
            dataRoot.setREGIONE(regione);
        }
        for (RecordDtoOsp r : records) {
            // Operazione
            Optional<Dataroot.REGIONE.PERIODO.OPERAZIONE> currentOperazione = dataRoot.getREGIONE().getPERIODO().getOPERAZIONE()
                    .stream()
                    .filter(op -> Objects.equals(r.getTipoOperazione(), op.getTipoOp()))
                    .findFirst();

            if (currentOperazione.isEmpty()) {
                currentOperazione = Optional.of(creaOperazione(r.getTipoOperazione()));
                dataRoot.getREGIONE().getPERIODO().getOPERAZIONE().add(currentOperazione.get());
            }
            // AS
            Optional<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS> currentAS = currentOperazione.get().getAS()
                    .stream()
                    .filter(as -> Objects.equals(r.getCodiceAziendaSanitaria(), as.getCodAs()))
                    .findFirst();

            if (currentAS.isEmpty()) {
                currentAS = Optional.of(creaAziendaSanitaria(r.getCodiceAziendaSanitaria()));
                currentOperazione.get().getAS().add(currentAS.get());
            }
            // Struttura
            Optional<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA> currentStruttura = currentAS.get().getSTRUTTURA()
                    .stream()
                    .filter(s -> (Objects.equals(r.getTipoStrutturaUtilizzatrice(), s.getTipoStr())
                            && Objects.equals(r.getCodiceStrutturaUtilizzatrice(), s.getCodStr())
                            )
                    ).findFirst();

            if (currentStruttura.isEmpty()) {
                currentStruttura = Optional.of(creaStruttura(r.getCodiceStrutturaUtilizzatrice(), r.getTipoStrutturaUtilizzatrice()));
                currentAS.get().getSTRUTTURA().add(currentStruttura.get());
            }
            // Unità Operativa
            Optional<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP> currentUnOp = currentStruttura.get().getUNITOP()
                    .stream()
                    .filter(s -> Objects.equals(r.getCodiceUnitaOperativaUtilizzatrice(), s.getCodUnOp())
                    ).findFirst();

            if (currentUnOp.isEmpty()) {
                currentUnOp = Optional.of(creaUnitaOperativa(r.getCodiceUnitaOperativaUtilizzatrice()));
                currentStruttura.get().getUNITOP().add(currentUnOp.get());
            }
            // Medicinale
            Optional<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE> currentMedicinale = currentUnOp.get().getMEDICINALE()
                    .stream()
                    .filter(s -> Objects.equals(r.getCodiceRegimeAttivita(), s.getCodRegAtt()) &&
                            Objects.equals(r.getTipoMedicinale(), s.getCodMed()) &&
                            Objects.equals(r.getCodiceMedicinale(), s.getCodMed()) &&
                            Objects.equals(r.getCostoAcquisto(), s.getCostoAcq()) &&
                            Objects.equals(r.getQuantita(), s.getQta()) &&
                            Objects.equals(r.getFattoreConversione(), s.getFattConv())
                    ).findFirst();

            if (currentMedicinale.isEmpty()) {
                currentMedicinale = Optional.of(
                        creaMedicinale(r.getCodiceRegimeAttivita(), r.getTipoMedicinale(), r.getCodiceMedicinale(),
                                r.getCostoAcquisto(), r.getQuantita(), r.getFattoreConversione()
                        )
                );
                currentUnOp.get().getMEDICINALE().add(currentMedicinale.get());


                Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE currentTargature = creaTargature();

                currentTargature.getCOD().add(r.getTargatura());
                currentMedicinale.get().setTARGATURE(currentTargature);
            }
        }
        return dataRoot;
    }
}
