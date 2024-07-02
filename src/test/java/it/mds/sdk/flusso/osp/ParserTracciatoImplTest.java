/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp;

import it.mds.sdk.flusso.osp.parser.regole.ParserTracciatoImpl;
import it.mds.sdk.flusso.osp.parser.regole.RecordDtoOsp;
import it.mds.sdk.flusso.osp.tracciato.TracciatoSplitterImpl;
import it.mds.sdk.flusso.osp.tracciato.output.Dataroot;
import it.mds.sdk.libreriaregole.dtos.CampiInputBean;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import it.mds.sdk.libreriaregole.parser.ParserTracciato;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ParserTracciatoImplTest {

    private static final String FILE_TRACCIATO_DIR = "tracciato-osp-test.csv";
    String pathFileCsv;
    String pathFileCsv1000;
    File fileCsv;
    File fileCsv1000;
    private int dimensioneBlocco = 300;

    @BeforeEach
    void init() {
        Properties prop = loadPropertiesFromFile("config-flusso-osp-test.properties");
        this.pathFileCsv = prop.getProperty("test.filecsv");
        this.pathFileCsv1000 = prop.getProperty("test.filecsv1000");

        ClassLoader classLoader = getClass().getClassLoader();
        fileCsv = new File(Objects.requireNonNull(classLoader.getResource(pathFileCsv)).getFile());
    //    fileCsv1000 = new File(Objects.requireNonNull(classLoader.getResource(pathFileCsv1000)).getFile());
        System.out.println("ciao");
    }

//    //@Test
//    void integ() throws InterruptedException {
//        ParserTracciatoImpl p = new ParserTracciatoImpl();
//        List<RecordDtoGenerico> list = p.parseTracciatoBlocco(fileCsv, 1, dimensioneBlocco);
//        RecordDtoOsp copy = (RecordDtoOsp) list.get(0);
//        for (int i = 0; i < 20000000; i++) {
//            list.add(copy.clone());
//        }
//        //System.out.println(r);
//    }

    @Test
    void integBLocco() {
        ParserTracciatoImpl p = new ParserTracciatoImpl();
        List<RecordDtoGenerico> list = p.parseTracciatoBlocco(fileCsv, 1, dimensioneBlocco);
        CampiInputBean c = new CampiInputBean("13", "2022", "120");

        for (RecordDtoGenerico r : list) {
            r.setCampiInput(c);
        }
        List<RecordDtoOsp> r2 = list.stream().map(k -> (RecordDtoOsp) k).collect(Collectors.toList());
        TracciatoSplitterImpl splitter = new TracciatoSplitterImpl();
        splitter.dividiTracciato(r2, "34");
        System.out.println(list.size());

    }

    @Test
    void scritturaNBlocchiSuXML() {
        //TODO voglio provare a marshallare un intero file XML con tutti i crismi
        ParserTracciatoImpl p = new ParserTracciatoImpl();

        //Prova blocchi
        List<RecordDtoGenerico> blocco = p.parseTracciatoBlocco(fileCsv, 1, dimensioneBlocco);
        List<RecordDtoOsp> bloccoConv = blocco.stream().map(k -> (RecordDtoOsp) k).collect(Collectors.toList());

        TracciatoSplitterImpl t = new TracciatoSplitterImpl();
        //Dataroot dataroot = t.creaIntestazioneDataroot(bloccoConv);
        Dataroot dataroot = t.creaDataroot(bloccoConv, null);
        blocco = null;
        bloccoConv = null;
        //System.gc();
        System.out.println("blocco 1");
        blocco = p.parseTracciatoBlocco(fileCsv, dimensioneBlocco + 1, dimensioneBlocco + 300);
        bloccoConv = blocco.stream().map(k -> (RecordDtoOsp) k).collect(Collectors.toList());
        dataroot = t.creaDataroot(bloccoConv, dataroot);
        blocco = null;
        bloccoConv = null;
        //System.gc();
        System.out.println("blocco 2");
        blocco = p.parseTracciatoBlocco(fileCsv, dimensioneBlocco + 301, dimensioneBlocco + 600);
        bloccoConv = blocco.stream().map(k -> (RecordDtoOsp) k).collect(Collectors.toList());
        dataroot = t.creaDataroot(bloccoConv, dataroot);
        blocco = null;
        bloccoConv = null;
        //System.gc();
        System.out.println("blocco 3");
        blocco = p.parseTracciatoBlocco(fileCsv, dimensioneBlocco + 601, 1000);
        bloccoConv = blocco.stream().map(k -> (RecordDtoOsp) k).collect(Collectors.toList());
        dataroot = t.creaDataroot(bloccoConv, dataroot);
        blocco = null;
        bloccoConv = null;
        //System.gc();
        System.out.println("blocco 4");
//        try {
//            System.out.println("inizio jaxb");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Dataroot.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
//            //jaxbMarshaller.marshal(dataroot, System.out);
//            jaxbMarshaller.marshal(dataroot, new File("prova.xml"));
//        } catch (Throwable e) {
//            throw new XSDNonSupportedException("XSD non validato ", e);
//        }
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

    @Test
    void validaTracciatoOK() {
        ParserTracciato parserTracciato = new ParserTracciatoImpl();
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        File tracciato = new File(absolutePath + FileSystems.getDefault().getSeparator() + FILE_TRACCIATO_DIR);

        List<RecordDtoGenerico> listaRecord = parserTracciato.parseTracciato(tracciato);
        listaRecord.forEach(System.out::println);
        assertTrue(ArrayUtils.isEmpty(listaRecord.toArray()));
    }

}