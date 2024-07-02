/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp;

import it.mds.sdk.flusso.osp.controller.FlussoOspControllerRest;
import it.mds.sdk.flusso.osp.parser.regole.RecordDtoOsp;
import it.mds.sdk.flusso.osp.parser.regole.conf.ConfigurazioneFlussoOsp;
import it.mds.sdk.flusso.osp.service.FlussoOspService;
import it.mds.sdk.gestoreesiti.GestoreRunLog;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import it.mds.sdk.libreriaregole.parser.ParserRegole;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RecordRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class FlussoOspControllerRestTest {


    @InjectMocks
    @Spy
    private FlussoOspControllerRest controller;
    @Mock
    File file;
    @Mock
    File file2;

    FlussoRequest flussoRequest;
    @Spy
    private ParserRegole parserRegole;
    @Spy
    private ConfigurazioneFlussoOsp conf;
    @Mock
    private RegoleFlusso regoleFlusso;
    @Mock
    private GestoreRunLog gestoreRunLog;
    @Mock
    private FlussoOspService service;
    @Mock
    private InfoRun infoRun;
    @Mock
    RecordRequest<RecordDtoOsp> recordRequest;
    private final ConfigurazioneFlussoOsp.NomeFlusso nomeFlusso = mock(ConfigurazioneFlussoOsp.NomeFlusso.class);
    private final ConfigurazioneFlussoOsp.Rules rules = mock(ConfigurazioneFlussoOsp.Rules.class);
    private final ConfigurazioneFlussoOsp.Flusso flusso = mock(ConfigurazioneFlussoOsp.Flusso.class);

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        initFlussoRequest();
    }

    @Test
    void validaTracciatoTest(){
        doReturn(file).when(controller).getFileFromPath(any());
        doReturn(true).when(file).exists();
//        doReturn("anno").when(flussoRequest).getAnnoRiferimento();
//        doReturn("mese").when(flussoRequest).getPeriodoRiferimento();
        doReturn(regoleFlusso).when(parserRegole).parseRegole(any());
        doReturn(gestoreRunLog).when(controller).createGestoreRunLog(any(), any());
        doReturn(nomeFlusso).when(conf).getNomeFLusso();
        doReturn("nomeflusso").when(nomeFlusso).getNomeFlusso();
        doReturn(infoRun).when(gestoreRunLog).creaRunLog(any(), any(), anyInt(), any());
        doReturn(infoRun).when(gestoreRunLog).updateRun(any());
        doReturn(infoRun).when(gestoreRunLog).cambiaStatoRun(any(), any());
        doNothing().when(service)
                .validazioneBlocchi(
                        anyInt(),
                        anyString(),
                        any(),
                        anyString(),
                        anyString(),
                        any(),
                        anyString(),
                        anyString(),
                        anyString(),
                        any()
                );
        controller.validaTracciato(flussoRequest, "nomeFlusso");
    }

    @Test
    void validaTracciatoTestKO1(){
        flussoRequest.setPeriodoRiferimento(null);
        doReturn(file).when(controller).getFileFromPath(any());
        doReturn(true).when(file).exists();

        controller.validaTracciato(flussoRequest, "nomeFlusso");
    }

    @Test
    void validaTracciatoTestKO2(){
        doReturn(file).when(controller).getFileFromPath(any());
        doReturn(false).when(file).exists();
        Assertions.assertThrows(
                ResponseStatusException.class,
                ()-> controller.validaTracciato(flussoRequest, "nomeFlusso")
        );
    }

    @Test
    void validaTracciatoTestKO3(){
        doReturn(flusso).when(conf).getFlusso();
        doReturn("file1").when(flusso).getPercorso();
        doReturn(rules).when(conf).getRules();
        doReturn("file2").when(rules).getPercorso();

        doReturn(file).when(controller).getFileFromPath("file1" + flussoRequest.getNomeFile());
        doReturn(true).when(file).exists();

        doReturn(file2).when(controller).getFileFromPath("file2");
        doReturn(false).when(file2).exists();

        Assertions.assertThrows(
                ResponseStatusException.class,
                ()-> controller.validaTracciato(flussoRequest, "nomeFlusso")
        );
    }

    @Test
    void informazioniRunOk1(){
        doReturn(gestoreRunLog).when(controller).createGestoreRunLog(any(), any());
        doReturn(infoRun).when(gestoreRunLog).getRun(any());
        controller.informazioniRun(
                "1",
                "1"
        );
    }
    @Test
    void informazioniRunOk2(){
        doReturn(gestoreRunLog).when(controller).createGestoreRunLog(any(), any());
        doReturn(null).when(gestoreRunLog).getRun(any());
        Assertions.assertThrows(
                ResponseStatusException.class,
                ()->controller.informazioniRun(
                        "1",
                        "1"
                )
        );
    }
    @Test
    void informazioniRunOk3(){
        doReturn(gestoreRunLog).when(controller).createGestoreRunLog(any(), any());
        doReturn(infoRun).when(gestoreRunLog).getRunFromClient(any());
        controller.informazioniRun(
                null,
                "1"
        );
    }

    @Test
    void informazioniRunOk4(){
        doReturn(gestoreRunLog).when(controller).createGestoreRunLog(any(), any());
        Assertions.assertThrows(
                ResponseStatusException.class,
                ()->controller.informazioniRun(
                        null,
                        null
                )
        );
    }

    @Test
    void validaRecordTest(){
        Assertions.assertNull(controller.validaRecord(recordRequest, "nome"));
    }
    private void initFlussoRequest() {
        flussoRequest = new FlussoRequest();
        flussoRequest.setNomeFile("nomeFile.txt");
        flussoRequest.setModalitaOperativa(ModalitaOperativa.T);
        flussoRequest.setIdClient("1");
        flussoRequest.setAnnoRiferimento("2022");
        flussoRequest.setPeriodoRiferimento("S2");
        flussoRequest.setCodiceRegione("080");
    }
}
