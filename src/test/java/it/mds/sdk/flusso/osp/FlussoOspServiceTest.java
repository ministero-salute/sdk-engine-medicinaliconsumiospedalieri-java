/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp;

import it.mds.sdk.connettoremds.ConnettoreMds;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ArrayOfUploadEsito;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseUploadFile;
import it.mds.sdk.flusso.osp.parser.regole.ParserTracciatoImpl;
import it.mds.sdk.flusso.osp.parser.regole.RecordDtoOsp;
import it.mds.sdk.flusso.osp.parser.regole.conf.ConfigurazioneFlussoOsp;
import it.mds.sdk.flusso.osp.service.FlussoOspService;
import it.mds.sdk.flusso.osp.tracciato.TracciatoSplitterImpl;
import it.mds.sdk.flusso.osp.tracciato.output.Dataroot;
import it.mds.sdk.gestoreesiti.GestoreRunLog;
import it.mds.sdk.gestoreesiti.modelli.Esito;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import it.mds.sdk.gestorefile.GestoreFile;
import it.mds.sdk.gestorefile.GestoreFileXMLImpl;
import it.mds.sdk.gestorefile.exception.XSDNonSupportedException;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import it.mds.sdk.libreriaregole.gestorevalidazione.BloccoValidazione;
import it.mds.sdk.libreriaregole.gestorevalidazione.GestoreValidazione;
import it.mds.sdk.libreriaregole.regole.beans.Campo;
import it.mds.sdk.libreriaregole.regole.beans.Parametri;
import it.mds.sdk.libreriaregole.regole.beans.RegolaGenerica;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import it.mds.sdk.libreriaregole.regole.catalogo.input.RegolaCheckCampiInput;
import it.mds.sdk.libreriaregole.validator.ValidationEngine;
import it.mds.sdk.rest.exception.ParseCSVException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.willDoNothing;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FlussoOspServiceTest {

    final String OSP_ACN_CSV = "";
    final String idClient = "";
    ;
    @Autowired
    ConfigurazioneFlussoOsp configurazioneFlussoOsp;
    ParserTracciatoImpl parser = Mockito.mock(ParserTracciatoImpl.class);
    GestoreFileXMLImpl gestoreFile = Mockito.mock(GestoreFileXMLImpl.class);

    private GestoreValidazione gestoreValidazione = Mockito.mock(GestoreValidazione.class);

    private ConnettoreMds connettoreMds = Mockito.mock(ConnettoreMds.class);

    int dimensioneBlocco = 0;
    BloccoValidazione bloccoValidazione;
    File file;
    Path pathInfoRunFile;
    ;
    RecordDtoOsp recordDtoOsp;
    Properties prop = loadPropertiesFromFile("config-flusso-osp-test.properties");
    InfoRun infoRun;
    @InjectMocks
    @Spy
    private FlussoOspService flussoOspService;
    @Mock
    private RegoleFlusso regoleFlusso;
    @Spy
    private ConfigurazioneFlussoOsp conf;
    private TracciatoSplitterImpl tracciatoSplitter = Mockito.mock(TracciatoSplitterImpl.class);
    private GestoreRunLog gestoreRunLog = Mockito.mock(GestoreRunLog.class);

    private GestoreFile gestoreFileInt2 = Mockito.mock(GestoreFile.class);
    private ValidationEngine validationEngine = Mockito.mock(ValidationEngine.class);
    private String idRun = "";
    private String periodoRiferimento = "";
    private String annoRiferimento = "";
    private String codiceRegione = "";

    MockedStatic<GestoreFileFactory> utilities;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);

        idRun = prop.getProperty("test.idrun");
        codiceRegione = prop.getProperty("test.codregione");
        periodoRiferimento = prop.getProperty("test.periodo");
        annoRiferimento = prop.getProperty("test.anno");
        dimensioneBlocco = Integer.parseInt(prop.getProperty("test.dimensioneblocco"));

        // Create Parametri
        Map<String, String> parametriMap = new HashMap<>();
        parametriMap.put("parametroInput", "codiceRegioneInput");
        Parametri parametri = new Parametri();
        parametri.setParametriMap(parametriMap);
        // Create RegolaGenerica
        RegolaGenerica regolaGenerica = new RegolaCheckCampiInput();
        regolaGenerica.setCodErrore("B01");
        regolaGenerica.setDesErrore("Non appartenenza al dominio di riferimento");
        regolaGenerica.setParametri(parametri);
        // Create Campo
        Campo campo = new Campo(List.of(regolaGenerica), "codiceRegione");
        // Creazione RegoleFlusso
        regoleFlusso = new RegoleFlusso(List.of(campo));
        //    gestoreRunLog = spy(new GestoreRunLog(new GestoreFileCSVImpl(), Progressivo.creaProgressivo(Progressivo.Fonte.FILE)));

        recordDtoOsp = new RecordDtoOsp();
        recordDtoOsp.setCodiceRegimeAttivita("1");
        recordDtoOsp.setCodiceUnitaOperativaUtilizzatrice("2101");
        recordDtoOsp.setAnnoConsegna("2022");
        recordDtoOsp.setMeseConsegna("01");
        recordDtoOsp.setTipoMedicinale("1");

        bloccoValidazione = new BloccoValidazione();
        bloccoValidazione.setNumeroRecord(2);
        bloccoValidazione.setScartati(1);

        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(Objects.requireNonNull(classLoader.getResource(prop.getProperty("test.filecsv"))).getFile());
        var el = Objects.requireNonNull(classLoader.getResource("928.json")).getPath();
        el = el.substring(1);
        pathInfoRunFile = Path.of(el);

        infoRun = new InfoRun(
                null, null, null, null, null,
                null, null, null, null, null, null,
                1, 1, 1, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_OK() throws IOException {
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlussoOsp.getFlusso());
        when(conf.getXmlOutput()).thenReturn(new ConfigurazioneFlussoOsp().getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);

        bloccoValidazione.setRecordList(Collections.emptyList());
        doReturn(pathInfoRunFile).when(gestoreFile).leggiFile(any());
        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        //given(gestoreFile.leggiFile(any())).willReturn(pathInfoRunFile);
        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        given(validationEngine.puliziaFileDataroot(any(), any(), any())).willReturn("mocked_filename");
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        this.flussoOspService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.T,
                periodoRiferimento,
                annoRiferimento,
                codiceRegione,
                gestoreRunLog
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_KOPulizia() throws IOException {
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlussoOsp.getFlusso());
        when(conf.getXmlOutput()).thenReturn(new ConfigurazioneFlussoOsp().getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);

        bloccoValidazione.setRecordList(Collections.emptyList());
        doReturn(pathInfoRunFile).when(gestoreFile).leggiFile(any());
        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        //given(gestoreFile.leggiFile(any())).willReturn(pathInfoRunFile);
        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        given(validationEngine.puliziaFileDataroot(any(), any(), any())).willThrow(XSDNonSupportedException.class);
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        this.flussoOspService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.T,
                periodoRiferimento,
                annoRiferimento,
                codiceRegione,
                gestoreRunLog
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_KOParserCsv() throws IOException {
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlussoOsp.getFlusso());
        when(conf.getXmlOutput()).thenReturn(new ConfigurazioneFlussoOsp().getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willThrow(ParseCSVException.class);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        this.flussoOspService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.T,
                periodoRiferimento,
                annoRiferimento,
                codiceRegione,
                gestoreRunLog
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_KO() {
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlussoOsp.getFlusso());
        when(conf.getXmlOutput()).thenReturn(new ConfigurazioneFlussoOsp().getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);
        Dataroot dataroot = new Dataroot();
        Dataroot.REGIONE regione = new Dataroot.REGIONE();
        regione.setCodReg(codiceRegione);
        dataroot.setREGIONE(regione);
        given(tracciatoSplitter.creaDataroot(any(), any())).willReturn(dataroot);

        //doThrow(new XSDNonSupportedException()).when(gestoreFile).scriviDtoFragment(eq(null), any(), any());
        willThrow(new XSDNonSupportedException()).willDoNothing().given(gestoreFile).scriviDtoFragment(any(), any(), any());
        //  given(gestoreFile.scriviDtoFragment(eq(null), any(), any()).

        bloccoValidazione.setRecordList(List.of(recordDtoOsp));

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        //  given(validationEngine.puliziaFile(any(), any(), any())).willReturn("mocked_filename");
        given(validationEngine.formatXmlOutput(any(), any(), any())).willReturn(false);
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        Assertions.assertThrows(
                Exception.class,
                () -> this.flussoOspService.validazioneBlocchi(
                        dimensioneBlocco,
                        OSP_ACN_CSV,
                        regoleFlusso,
                        idRun,
                        idClient,
                        ModalitaOperativa.T,
                        periodoRiferimento,
                        annoRiferimento,
                        codiceRegione,
                        gestoreRunLog
                )
        );
    }

    @Test
    void validazioneBlocchiTestModalitaT_KO_EsitiNotCleaned() {
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlussoOsp.getFlusso());
        when(conf.getXmlOutput()).thenReturn(new ConfigurazioneFlussoOsp().getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);
        Dataroot dataroot = new Dataroot();
        Dataroot.REGIONE regione = new Dataroot.REGIONE();
        regione.setCodReg(codiceRegione);
        dataroot.setREGIONE(regione);
        given(tracciatoSplitter.creaDataroot(any(), any())).willReturn(dataroot);

        //doThrow(new XSDNonSupportedException()).when(gestoreFile).scriviDtoFragment(eq(null), any(), any());
        willThrow(new XSDNonSupportedException()).willDoNothing().given(gestoreFile).scriviDtoFragment(any(), any(), any());
        //  given(gestoreFile.scriviDtoFragment(eq(null), any(), any()).

        bloccoValidazione.setRecordList(List.of(recordDtoOsp));

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(false);
        //  given(validationEngine.puliziaFile(any(), any(), any())).willReturn("mocked_filename");
        given(validationEngine.formatXmlOutput(any(), any(), any())).willReturn(false);
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        Assertions.assertThrows(
                RuntimeException.class,
                () -> this.flussoOspService.validazioneBlocchi(
                        dimensioneBlocco,
                        OSP_ACN_CSV,
                        regoleFlusso,
                        idRun,
                        idClient,
                        ModalitaOperativa.T,
                        periodoRiferimento,
                        annoRiferimento,
                        codiceRegione,
                        gestoreRunLog
                )
        );
    }

    @Test
    void validazioneBlocchiTestModalitaP_OK() {

        ConfigurazioneFlussoOsp configurazioneFlusso = new ConfigurazioneFlussoOsp();
        when(spy(conf.getFlusso())).thenReturn(configurazioneFlusso.getFlusso());
        when(conf.getXmlOutput()).thenReturn(configurazioneFlusso.getXmlOutput());
        List<RecordDtoGenerico> list = List.of(recordDtoOsp);
        given(parser.parseTracciatoBlocco(any(), anyInt(), anyInt())).willReturn(list);

        bloccoValidazione.setRecordList(List.of(recordDtoOsp));

        given(validationEngine.startValidaFlussoBlocco(anyList(), any(), anyString(), any(), anyInt())).willReturn(bloccoValidazione);
        given(validationEngine.formatJsonEsiti(any(), any())).willReturn(true);
        given(validationEngine.puliziaFileDataroot(any(), any(), any())).willReturn("mocked_filename");

        willDoNothing().given(flussoOspService).inviaTracciatoMds(any(), any(), any(), any(), any());

        Dataroot dataroot = new Dataroot();
        Dataroot.REGIONE regione = new Dataroot.REGIONE();
        regione.setCodReg(codiceRegione);
        dataroot.setREGIONE(regione);
        utilities = mockStatic(GestoreFileFactory.class);

        given(tracciatoSplitter.creaDataroot(any(), any())).willReturn(dataroot);
        utilities.when(()->GestoreFileFactory.getGestoreFile("XML")).thenReturn(gestoreFileInt2);

        willDoNothing().given(gestoreFileInt2).scriviDtoFragment(eq(dataroot), any(), any());

        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        given(gestoreRunLog.updateRun(any())).willReturn(infoRun);

        this.flussoOspService.validazioneBlocchi(
                dimensioneBlocco,
                OSP_ACN_CSV,
                regoleFlusso,
                idRun,
                idClient,
                ModalitaOperativa.P,
                periodoRiferimento,
                annoRiferimento,
                codiceRegione,
                gestoreRunLog
        );
    }
    @Test
    void inviaTracciatoMdsTest_ErrorCodeNull() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_OSP_OSP_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        responseUploadFile.setErrorCode(null);
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoOspService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                gestoreRunLog,
                periodoRiferimento,
                annoRiferimento
        );
    }

    @Test
    void inviaTracciatoMdsTest_ListaEsitiNotNull() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_OSP_OSP_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        ArrayOfUploadEsito arr = Mockito.mock(ArrayOfUploadEsito.class);

        responseUploadFile.setListaEsitiUpload(arr);
        responseUploadFile.setErrorCode(null);
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoOspService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                gestoreRunLog,
                periodoRiferimento,
                annoRiferimento
        );
    }

    @Test
    void inviaTracciatoMdsTest_KOMinistero() throws ConnettoreMdsException {
        String nomeFileXml = conf.getXmlOutput().getPercorso() + "SDK_OSP_OSP_" + periodoRiferimento + "_" + idRun +
                ".xml";
        given(gestoreRunLog.getRun(any())).willReturn(infoRun);
        ResponseUploadFile responseUploadFile = new ResponseUploadFile();
        responseUploadFile.setErrorCode("x");
        given(connettoreMds.invioTracciati(any(), any(), any(), any(), any())).willReturn(responseUploadFile);
        given(gestoreRunLog.cambiaStatoRun(any(), any())).willReturn(infoRun);
        flussoOspService.inviaTracciatoMds(
                idRun,
                nomeFileXml,
                gestoreRunLog,
                periodoRiferimento,
                annoRiferimento
        );
    }

    private Properties loadPropertiesFromFile(String fileName) {
        Properties prop = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(fileName);
            prop.load(stream);
            stream.close();
        } catch (Exception e) {
            String msg = String.format("Failed to load file '%s' - %s - %s", fileName, e.getClass().getName(),
                    e.getMessage());
            System.out.println(msg);
        }
        return prop;
    }
}
