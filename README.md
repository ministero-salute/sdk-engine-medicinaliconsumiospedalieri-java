# **1 Introduzione**

## ***1.1 Obiettivi del documento***

Il Ministero della Salute (MdS) metterà a disposizione degli Enti, da cui riceve dati, applicazioni SDK specifiche per flusso logico e tecnologie applicative (Java, PHP e C#) per verifica preventiva (in casa Ente) della qualità del dato prodotto.

![](img/Aspose.Words.f54e9308-1f66-4337-9bb6-75e632097cc3.002.png)

Nel presente documento sono fornite la struttura e la sintassi dei tracciati previsti dalla soluzione SDK per avviare il proprio processo elaborativo e i controlli di merito sulla qualità, completezza e coerenza dei dati.

Gli obiettivi del documento sono:

- fornire una descrizione funzionale chiara e consistente dei tracciati di input a SDK;
- fornire le regole funzionali per la verifica di qualità, completezza e coerenza dei dati;

In generale, la soluzione SDK è costituita da 2 diversi moduli applicativi (Access Layer e Validation Engine) per abilitare:

- l’interoperabilità con il contesto tecnologico dell’Ente in cui la soluzione sarà installata;
- la validazione del dato ed il suo successivo invio verso il MdS.

La figura che segue descrive la soluzione funzionale ed i relativi benefici attesi.

![](img/Aspose.Words.f54e9308-1f66-4337-9bb6-75e632097cc3.003.png)

## ***1.2 Acronimi***

Nella tabella riportata di seguito sono elencati tutti gli acronimi e le definizioni adottate nel presente documento.


|**#**|**Acronimo / Riferimento**|**Definizione**|
| - | - | - |
|1|NSIS|Nuovo Sistema Informativo Sanitario|
|2|SDK|Software Development Kit|
|3|SSN|Sistema Sanitario Nazionale|
|4|AIC|Autorizzazione Immissione in Commercio|
|5|AO|Azienda ospedaliera|
|6|AOU|Azienda Ospedaliera Universitaria|
|7|ATC|Classificazione Anatomica, Terapeutica, Clinica|
|8|IRCCS|Istituto di ricovero e cura a carattere scientifico|
|9|XML|eXtensible Markup Language|
|10|XSD|XML Schema Definition|


# **2 Architettura SDK**

## ***2.1 Architettura funzionale***

Di seguito una rappresentazione architetturale del processo di gestione e trasferimento dei flussi dall’ente verso l’area MdS attraverso l’utilizzo dell’applicativo SDK, e il corrispondente diagramma di sequenza.

![DiagramDescription automatically generated](img/Aspose.Words.f54e9308-1f66-4337-9bb6-75e632097cc3.004.jpeg)

![A picture containing graphical user interfaceDescription automatically generated](img/Aspose.Words.f54e9308-1f66-4337-9bb6-75e632097cc3.005.png)

1. L’utente dell’ente caricherà in una apposita directory (es. /sdk/input/) il flusso sorgente.  L’utente avvierà l’SDK passando in input una serie di parametri descritti in dettaglio al paragrafo 3.1
1. La componente Access Layer estrae dalla chiamata dell’ente i parametri utilizzati per lanciare l’SDK,  genera un identificativo ID\_RUN, e un file chiamato “{ID\_RUN}.json” in cui memorizza le informazioni dell’esecuzione.
1. I record del flusso verranno sottoposti alle logiche di validazione e controllo definite nel Validation Engine. Nel processare il dato, il Validation Engine acquisirà da MdS eventuali anagrafiche di validazione del dato stesso.
1. Generazione del file degli scarti contenente tutti i record in scarto con evidenza degli errori riscontrati. I file di scarto saranno memorizzati in cartelle ad hoc (es. /sdk/esiti).
1. Tutti i record che passeranno i controlli verranno inseriti in un file xml copiato in apposita cartella (es /sdk/xml\_output), il quale verrà eventualmente trasferito a MdS utilizzando la procedura “invioFlussi” esposta da GAF WS (tramite PDI). A fronte di un’acquisizione, il MdS fornirà a SDK un identificativo (ID\_UPLOAD) che sarà usato da SDK sia per fini di logging che di recupero del File Unico degli Scarti.
1. A conclusione del processo di verifica dei flussi, il Validation Engine eseguirà le seguenti azioni:

 a. Aggiornamento file contentente il riepilogo dell’esito dell’elaborazione del Validation Engine e del ritorno dell’esito da parte di MdS. I file contenente l’esito dell’elaborazione saranno memorizzati in cartelle ad hoc (es. /sdk/run).

 b. Consolidamento del file di log applicativo dell’elaborazione dell’SDK in cui sono disponibili una serie di informazioni tecniche (Es. StackTrace di eventuali errori).

 c. Copia del file generato al punto 5, se correttamente inviato al MdS, in apposita cartella (es. /sdk/sent).

Ad ogni step del precedente elenco e a partire dal punto 2, l’SDK aggiornerà di volta in volta il file contenente l’esito dell’elaborazione.

**Nota: l’SDK elaborerà un solo file di input per esecuzione.**

In generale, le classi di controllo previste su Validation Engine sono:

- Controlli FORMALI (es. correttezza dei formati e struttura record)
- Controlli SINTATTICI (es. check correttezza del Codice Fiscale)
- Controlli di OBBLIGATORIETÀ DEL DATO (es. Codice Prestazione su flusso…)
- Controlli STRUTTURE FILE (es. header/footer ove applicabile)
- Controlli di COERENZA CROSS RECORD
- Controlli di corrispondenza dei dati trasmessi con le anagrafiche di riferimento;
- Controlli di esistenza di chiavi duplicate nel file trasmesso rispetto alle chiavi logiche individuate per ogni tracciato.

Si sottolinea che la soluzione SDK non implementa controlli che prevedono la congruità del dato input con la base date storica (es. non viene verificato se per un nuovo inserimento (Tipo = I) la chiave del record non sia già presente sulla struttura dati MdS).

## ***2.2 Architettura di integrazione***

La figura sottostante mostra l’architettura di integrazione della soluzione SDK con il MdS. Si evidenzia in particolare che:

- Tutti i dati scambiati fra SDK e MdS saranno veicolati tramite Porta di Interoperabilità (PDI);
- Il MdS esporrà servizi (API) per il download di dati anagrafici;
- SDK provvederà ad inviare vs MdS l’output (record validati) delle proprie elaborazioni. A fronte di tale invio, il MdS provvederà a generare un identificativo di avvenuta acquisizione del dato (ID\_UPLOAD) che SDK memorizzerà a fini di logging.


![](img/Aspose.Words.f54e9308-1f66-4337-9bb6-75e632097cc3.006.png)


# **3 Funzionamento della soluzione SDK**

In questa sezione sono descritte le specifiche di funzionamento del flusso informativo per il monitoraggio dei consumi di medicinali in ambito ospedaliero (ad eccezione dei farmaci dispensati in distribuzione diretta).

I flussi informativi raccolgono le informazioni relative al singolo evento distributivo effettuato per consentire diverse e articolate forme di aggregazione e di analisi dei dati.



## ***3.1 Input SDK***

In fase di caricamento del file verrano impostati i seguenti parametri che andranno in input al SDK in fase di processamento del file:

|**NOME PARAMETRO**|**DESCRIZIONE**|**LUNGHEZZA**|**DOMINIO VALORI**|
| :- | :- | :- | :- |
|ID CLIENT|Identificativo univoco della transazione che fa richiesta all'SDK|100|Non definito|
|NOME FILE INPUT|Nome del file per il quale si richiede il processamento lato SDK|256|Non definito|
|ANNO RIFERIMENTO|Stringa numerica rappresentante l’anno di riferimento per cui si intende inviare la fornitura|4|Anno (Es. 2022)|
|PERIODO RIFERIMENTO|Stringa alfanumerica rappresentante il periodo per il quale si intende inviare la fornitura; |3|**13** (rappresenta un alias per il quale MDS usa come data di competenza l’anno e il mese di riferimento del record piuttosto che il parametro periodo di riferimento passato in input alla procedura InvioFlussi)|
|TIPO TRASMISSIONE |Indica se la trassmissione dei dati verso MDS avverrà il modalità full (F) o record per record (R). Per questo flusso la valorizzazione del parametro sarà impostata di default a F|1|F/R|
|FINALITA’ ELABORAZIONE|Indica se i flussi in output prodotti dal SDK verranno inviati verso MDS (Produzione) oppure se rimarranno all’interno del SDK e il processamento vale solo come test del flusso (Test)|1|Produzione/Test|
|CODICE REGIONE|<p>Individua la Regione a cui afferisce la struttura. Il codice da utilizzare è quello a tre caratteri definito con DM 17 settembre 1986, pubblicato nella Gazzetta Ufficiale n.240 del 15 ottobre 1986, e successive modifiche, utilizzato anche nei modelli per le rilevazioni delle attività gestionali ed economiche delle Aziende unità sanitarie locali.</p><p></p>|3|Es. 010|

## ***3.2 Tracciato input a SDK***

Il flusso di input avrà formato **csv** posizionale e una naming convention libera a discrezione dell’utente che carica il flusso senza alcun vincolo di nomenclatura specifica (es nome\_file.csv). Il separatore per il file csv sarà la combinazione di caratteri tra doppi apici: “~“

All’interno delle specifiche dei tracciati riportati nei paragrafi successivi sono indicati i dettagli dei campi di business del tracciato di input atteso da SDK. All’interno di tale file è presente la colonna **Posizione nel file** la quale rappresenta l’ordinamento delle colonne del tracciato di input da caricare all’SDK.

La specifica del tracciato di input per il flusso è la seguente:

| | | | | | | | | |
|-|-|-|-|-|-|-|-|-|
|**Nome campo**|**Posizione nel File**|**Key**|**Descrizione**|**Tipo** |**Obbligatorietà**|**Informazioni di Dominio**|**Lunghezza campo**|**XPATH Tracciato Output**|
|Codice Regione|1|KEY|Codice della Regione territorialmente competente.|AN|OBB|Valori di riferimento riportati nell’Allegato A - Regione |3|/dataroot/REGIONE/@cod_reg|
|Codice Azienda Sanitaria|2|KEY|Codice che identifica l’azienda sanitaria utilizzatrice (Azienda sanitaria locale o equiparata, Azienda Ospedaliera, Istituto di Ricovero e Cura a Carattere scientifico pubblico anche se trasformato in fondazione, Azienda Ospedaliera Universitaria integrata con il SSN).|AN|OBB|Per AO, IRCCS e AOU indicare il codice del modello HSP11, per le altre indicare il codice del modello FLS.11 (ASL, ESTAV)|6|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/@cod_as|
|Tipo Struttura Utilizzatrice|3|KEY|Codice tipologia di struttura utilizzatrice (struttura di ricovero, altra struttura sanitaria, istituto o centro di riabilitazione, ASL).|AN|OBB|Valori di riferimento riportati nell’Allegato B - Tipo Struttura Utilizzatrice|2|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/@tipo_str|
|Codice struttura utilizzatrice|4|KEY|Codice identificativo della struttura utilizzatrice.|AN|OBB|Valori di riferimento: -codici modelli HSP11, HSP11bis per tipo struttura utilizzatrice 01 -Struttura di ricovero (per gli istituti non organizzati in più strutture, sono ammessi sia i codici di 6 caratteri che i codici di 8 caratteri, con gli ultimi due caratteri pari a “00”); -codici modelli STS11, per tipo struttura utilizzatrice 02 (Altra struttura sanitaria); –codici modelli RIA11, per tipo struttura utilizzatrice 03 (Istituto o centro di riabilitazione) - codici modelli FLS11, per tipo struttura utilizzatrice 06 (ASL)|8|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/@cod_str|
|Codice regime di attività|5|KEY|Codice che indica il regime di attività cui è destinato il medicinale oggetto di movimentazione: degenza ordinaria, day hospital, misto (quando non è possibile distinguere a priori il regime di attività in cui il medicinale è utilizzato all’interno di un reparto), specialistica ambulatoriale, altro.|N|OBB|Valori di riferimento riportati nell’Allegato C - Codice Regime Attività (numero da 0 a 5)|1|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@cod_reg_att|
|Codice unità operativa utilizzatrice|6|KEY|Codice identificativo del reparto utilizzatore, nel solo caso di strutture di ricovero.|AN|NBB|Codici modelli HSP12 o “0000” se l’unità operativa utilizzatrice non è codificata. Campo obbligatorio se tipo struttura utilizzatrice = 01 - strutture di ricovero|4|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/@cod_un_op|
|Anno di Consegna|7|KEY|Indica l’anno in cui è avvenuta la consegna del medicinale.|N|OBB|Anno di consegna nel formato AAAA|4|/dataroot/REGIONE/PERIODO/@anno|
|Mese di Consegna|8|KEY|Indica il mese in cui è avvenuta la consegna del medicinale .|AN|OBB|Mese di consegna nel formato MM (da 01 per gennaio a 12 per dicembre)|2|/dataroot/REGIONE/PERIODO/@mese|
|Tipo medicinale|9|KEY|Codice che indica la tipologia di medicinale: medicinale autorizzato all’immissione in commercio, formula magistrale e officinale, farmaco estero non autorizzato in Italia, ossigeno o gas medicinale.|N|OBB|Valori di riferimento riportati nell’Allegato D - Tipo Medicinale (numero da 1 a 6)|1|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@tip_med|
|Codice medicinale|10|KEY|Codice che identifica il medicinale: • codice di autorizzazione all’immissione in commercio, per i medicinali dotati di AIC; • codice ATC di massimo dettaglio disponibile, per gli altri medicinali non dotati di AIC: o Gas medicinali puri e miscele di gas medicinali senza AIC: V03AN o Ossigeno: V03AN01 o Carbone diossido : V03AN02 o Helio : V03AN03 o Azoto : V03AN04 o Protossido di Azoto: N01AX13 o Zolfo Esafloruro: V08DA05 o Farmaci produttori di anidride carbonica: A06AX02 o Aria medicale: V03AN05 o Ossido nitrico: R07AX01|AN|OBB|Valori Ammessi:  Per tipo medicinale “1” indicare codice AIC (obbligatorio).  Per tipo medicinale “2”o ”3” indicare il codice ATC, codice Farmaco Estero,codice Farmaco Galenico di massimo dettaglio disponibile (obbligatorio).  Per tipo medicinale “4” o “5” indicare codice ATC dell’ossigeno “V03AN01”(obbligatorio) Per tipo medicinale “6” : indicare uno dei codici ATC relativi ad altri Gas medicinali “V03AN”, “V03AN02”, “V03AN03”, “V03AN04” , "V03AN05", “N01AX13”, ”V08DA05”, "A06AX02","R07AX01" (obbligatorio).|9|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@cod_med|
|Targatura|11|KEY|Numerazione progressiva del bollino della singola confezione inclusiva del codice di controllo (check digit). Tale numerazione può essere riportata per i medicinali dotati di bollino, ad eccezione di consegne ad unità operativa di unità posologiche inferiori al contenuto di una singola confezione.|AN|OBB|Codice Numerico (D.M. 2 agosto 2001 “Numerazione progressiva dei bollini apposti sulle confezioni dei medicinali erogabili dal Servizio sanitario nazionale”) Nel caso in cui il dato non sia disponibile inserire il valore “0”. Va indicato anche il codice di controllo (check digit). Il codice di controllo può essere impostato ad “A” se la lettura automatica non è andata a buon fine oppure ad “X” se non è ancora stata prevista la gestione dello stesso.|10|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/TARGATURE/COD|
|Costo di acquisto|12| |Indica il costo sostenuto per l’acquisto dei medicinali, comprensivo di IVA. Per costo di acquisto si intende, quindi, il costo complessivo sostenuto per acquistare le quantità indicate nel relativo campo.|N|OBB|Valore numerico compreso tra “0.00” e “99999999.99999”. Sono ammessi valori negativi utilizzando il segno “-“ prima del valore nel caso in cui, nel periodo di riferimento, i resi siano superiori alle consegne del medicinale.|14|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@costo_acq|
|Quantità|13| |Numero di pezzi (confezioni/altre unità equiparate indicate nell’Autorizzazione all’immissione in commercio/ unità posologiche) con riferimento al medicinale. OPPURE Numero di litri per l’ossigeno e gli altri gas medicinali non dotati di AIC.   NB: La quantità indicata deve essere al netto dei resi.|N|OBB|Valori ammessi: un valore numerico compreso tra 1 e 999999999999.99. Sono ammessi valori negativi utilizzando il segno “-“ prima del valore nel caso in cui, nel periodo di riferimento, i resi siano superiori alle consegne del medicinale.|15|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@qta|
|Fattore di conversione|14| |Se la quantità è espressa in unità posologiche, il fattore di conversione indica il numero di unità posologiche della confezione. Se la quantità è espressa in confezioni/altre unità equiparate indicate nell’Autorizzazione all’immissione in commercio o in litri va indicato il valore “1”.|N|OBB|Valori ammessi: valore numerico compreso tra 1 e 999999.|6|/dataroot/REGIONE/PERIODO/OPERAZIONE/AS/STRUTTURA/UNIT_OP/MEDICINALE/@fatt_conv|
|Tipo operazione|15| |Campo tecnico utilizzato per distinguere la trasmissione di informazioni nuove, modificate o eventualmente annullate. Va utilizzato il codice “I” per la trasmissione di informazioni nuove o per la ritrasmissione di informazioni precedentemente scartate dal sistema di acquisizione.. Va utilizzato il codice “V” per la trasmissione di informazioni per le quali si intende fare effettuare una soprascrittura dal sistema di acquisizione. Va utilizzato il codice “C” per la trasmissione di informazioni per le quali si intende fare effettuare una cancellazione dal sistema di acquisizione.|A|OBB|Valori ammessi: - I: Inserimento - V: Variazione - C:Cancellazione|1|/dataroot/REGIONE/PERIODO/OPERAZIONE/@tipo_op|


## ***3.3 Controlli di validazione del dato (business rules)***

All’interno dei file Excel riportati nei paragrafi successivi sono presenti i controlli da configurare sulla componente di Validation Engine e rispettivi error code associati riscontrabili sui dati di input. Gli errori sono solo di tipo scarti (mancato invio del record).

Al verificarsi anche di un solo errore di scarto, tra quelli descritti, il record oggetto di controllo sarà inserito tra i record scartati.

Business Rule non implementabili lato SDK:



- Storiche (Business Rule che effettuano controlli su dati già acquisiti/consolidati che non facciano parte del dato anagrafico)
- Transazionali (Business Rule che effettuano controlli su record, i quali rappresentano transazioni, su cui andrebbe garantito l’ACID (Atomicità-Consistenza-Isolamento-Durabilità))
- Controllo d’integrità (cross flusso) (Business Rule che effettuano controlli sui record utilizzando informazioni estratte da record di altri flussi)



Di seguito le BR per il flusso in oggetto:

| | | | | | | | | | |
|-|-|-|-|-|-|-|-|-|-|
|**CAMPO**|**CODICE ERRORE**|**DESCRIZIONE ERRORE**|**DESCRIZIONE MDS**|**DESCRIZIONE ALGORITMO**|**TABELLA ANAGRAFICA**|**CAMPI DI COERENZA**|**SCARTI/ANOMALIE**|**TIPOLOGIA BR**|**TIPOLOGIA CONTROLLO BR**|
|cod_reg|XSD_1|Coerenza dominio valori|Espressione regolare: [0-9]{3}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|cod_as|XSD_2|Coerenza dominio valori|Espressione regolare: [0-9]{6}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_str|XSD_3|Coerenza dominio valori|Espressione regolare: [0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|cod_str|XSD_4|Coerenza dominio valori|Espressione regolare: [0-9a-zA-Z\-]{1,8}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|cod_un_op|XSD_5|Coerenza dominio valori|Espressione regolare: [0-9]{4}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|anno|XSD_6|Coerenza dominio valori|Espressione regolare: [2][0][0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|mese|XSD_7|Coerenza dominio valori|Valori ammessi:  01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tip_med|XSD_8|Coerenza dominio valori|Valori ammessi:  1,2,3,4,5,6|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|cod_med|XSD_9|Coerenza dominio valori|Può essere vuoto, oppure rispettare la seguente espressione regolare: [0-9a-zA-Z]{1,9}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|costo_acq|XSD_11|Coerenza dominio valori|Espressione regolare: -{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|qta|XSD_12|Coerenza dominio valori|Espressione regolare: -{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|fatt_conv|XSD_13|Coerenza dominio valori|Valori ammessi: da 1 a 999999|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_op|XSD_14|Coerenza dominio valori|Valori ammessi: I,V,C|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Codice Regione|B01|Non appartenenza al dominio di riferimento|Il parametro Codice Regione passato in input all'SDK non coincide con il campo del tracciato e/o non è presente nel dominio|Il parametro Codice Regione passato in input all'SDK deve coincidere con il campo cod_reg del tracciato di input. Inoltre il valore del campo cod_reg del tracciato di input deve essere presente all'interno della query Anagrafica Regioni.   Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query.  |Regioni|Non Definito|Scarti|Anagrafica|SINTATTICI|
|Anno di Consegna; Mese di Consegna|B03|Errore periodo di riferimento|La data di invio del file deve essere successiva al periodo di riferimento. Questo errore viene restituito quando il periodo a cui si riferiscono i dati all’interno del file è successivo alla data di invio del file.|Record valido se la data di esecuzione dell'SDK è maggiore rispetto all'ultimo giorno del periodo (anno-mese) di riferimento nel tracciato di input |Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Codice Medicinale|B11|Errore codice medicinale|Il codice medicinale e' obbligatorio per il tipo medicinale indicato. Questo errore viene restituito quando , valorizzando come tipo farmaco 1, per il record indicato, si omette il codice farmaco.|Il campo cod_med del tracciato di input è obbligatorio (presente e diverso da blanks) .|Non Definito|Tipo Medicinale|Scarti|Basic|OBBLIGATORIETA'  DEL DATO|
|Quantità|B13|Errore Quantità|In caso valorizzazione della Targatura, il rapporto tra la quantità trasmessa e il fattore di conversione deve essere unitario. Questo errore si verifica in caso di valorizzazione del campo targatura, quando si valorizza una quantita’ diversa dal fattore di conversione.|se il valore del campo targatura del tracciato di input NON è valorizzato con solo 0 (0, 00, 000, ….) oppure NON è NULL allora il rapporto tra i campi qta e fatt_conv del tracciato di input deve essere 1|Non Definito|Targatura; Fattore di Conversione|Scarti|Basic|SINTATTICI|
|Fattore Conversione|B31|Errore fattore di conversione|In base all'indicazione del tipo medicinale e della targatura, il fattore di conversione deve essere pari a 1. Questo errore viene restituito quando, valorizzando come tipo farmaco 4,5 o 6 e come targatura 0, il fattore di conversione viene trasmesso con un valore diverso da 1.|Se il campo tip_med del tracciato di input  è in (4,5,6) e il campo targatura è 0, allora il campo fatt_conv del tracciato di input non può assumere valori diversi da 1|Non Definito|Targatura; Tipo Farmaco|Scarti|Basic|SINTATTICI|
|targatura (campo COD)|B100|Coerenza dominio valori|Espressione regolare del dominio amesso per il campo; Regex[0]{1}"|[0-9]{9}[0-9AX]{0,1}  Ovvero, i valori ammessi sono: a) 0 oppure 000000000 b) nnnnnnnnnA c) nnnnnnnnnX d) nnnnnnnnnn dove n=numero intero da 0 a 9|Non Definito|Non Definito|Non Definito|Scarti|0|Basic|
|Targatura|B101|Errore check-digit della targatura|Se targatura è composto da dieci caratteri numerici (e quindi non ricade negli altri casi definiti nella regola D100), allora: a) sia t i primi nove caratteri (numerici) del valore del campo targatura a partire da sinistra; b) iniziando dall'ultima cifra signicativa di t (quindi da destra), assegnare a ciascuna cifra, procedendo verso sinistra, alternativamente i valori 3,1,3,1,...; c) sia s la somma dei prodotti tra ciascuna cifra ed il valore rispettivamente assegnato; d) il check-digit è uguale a (10 - (s mod 10)) mod 10 e) il record è valido se il campo targatura ha come numero più a destra (quindi il decimo carattere) il valore del check-digit calcolato al punto precedente.  Esempio: supponiamo per semplificare che la targatura sia composta da 6 cifre e non da 10, ovvero "473651" a) t="47365"; b) valori: "31313": c) s = (3 x 5) + (1 x 6) + (3 x 3) + (1 x 7) + (3 x 4) = 49 d) check-digit = 10 - (49 mod 10) = 10 - 9 = 1 e) in questo caso, il valore targatura è corretto dato che la cifra più a destra è 1, che è il valore del check-digit calcolato al punto precedente. NB: nell'esempio consideriamo solo per semplificare che la targatura sia a 6 cifre. In realtà, è a 10 cifre.|Non Definito|Non Definito|Non Definito|Scarti|0|Basic|
|Codice Azienda Sanitaria|D01|Errore di dominio codice ASL|Il codice azienda non esiste per la regione inviata. Questo errore viene restituito quando, il codice ASL inviato non è presente in anagrafica.|la coppia  (cod_reg, cod_asl) del tracciato di input deve essere presente all'interno dell'anagrafica ASL.  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |ASL|Non Definito|Scarti|Anagrafica|SINTATTICI|
|Codice Medicinale|D03|Errore di dominio codice medicinale|Il codice AIC inviato non esiste. Questo errore viene restituito quando, il codice AIC inviato non esiste in anagrafica.|Se il campo tip_med del tracciato di input è uguale a 1, allora il campo cod_med deve essere presente all'interno dell'anagrafica AIFA (medicinali).  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query.   |AIFA (medicinali)|Tipo Medicinale|Scarti|Anagrafica|SINTATTICI|
|Codice Struttura Utilizzatrice|D20|Errore struttura erogante|Il codice della struttura erogante non e' presente in anagrafica per la tipologia inviata. Questo errore viene restituito quando, il codice della struttura erogante non è presente nell’anagrafica per la tipologia inviata. Potrebbe essere errata la tipologia struttura valorizzata o il codice stesso della struttura.|Se tipo_str = 02 allora tipo_str # cod_as # cod_str  deve esistere in anagrafica; se tipo_str = 01, 03, 06 allora tipo_str # cod_str  deve esistere in anagrafica;  NB: nel caso di tipo_str="01", se cod_str termina con "00" e ha in totale 8 caratteri, allora bisogna eliminare i due caratteri finali, dunque confrontare il dato dell'anagrafica con i primi sei caratteri di cod_str.  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |Elenco strutture eroganti|Tipo Struttura Utilizzatrice, Codice Azienda Sanitaria|Scarti|Anagrafica|SINTATTICI|
|Tipo Struttura Utilizzatrice|D21|Errore tipo erogatore|Il codice tipo erogatore non e' presente in anagrafica. Questo errore viene restituito quando, il codice tipo erogatore non è presente in anagrafica.|Il valore del campo tipo_str deve essere diverso da NULL presente in anagrafica Tipo Struttura.  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |Tipo Struttura| |Scarti|Basic|SINTATTICI|
|Codice Medicinale|D33|Errore di dominio codice medicinale|Il codice ATC inviato non esiste. Questo errore viene restituito quando, valorizzando come tipo farmaco 2 o 3, il codice ATC inviato non è presente in anagrafica.|Se il campo tip_med del tracciato di input è uguale a 2 or 3 allora il campo cod_med del tracciato in input (se diverso da null, altrimenti nessun controllo) deve essere presente all'interno della query anagrafica ATC Farmaci filtrata sulla condizione:  -il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD della query.   Se il campo tip_med del tracciato di input è uguale a 4 or 5 allora il campo cod_med del tracciato in input deve essere uguale a "V03AN01".  Se il campo tip_med del tracciato di input è uguale a 6 allora il campo cod_med deve essere presente nella query anagrafica COD ATC 06.   Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |COD ATC 06; ATC Farmaci|Tipo Medicinale|Scarti|Anagrafica|SINTATTICI|
|Tipo Struttura Utilizzatrice|D40|Errore Tipo Erogatore|Il codice della struttura erogante non e' verificabile a causa dell'errore sul tipo erogatore. Questo errore viene restituito quando, Il codice della Struttura Erogante non è verificabile a causa della valorizzazione errata del campo Tipo Erogatore, per il quale non è stato trovato un valore ammesso.|tipo_str NON deve essere diverso da "01", "02", "03", "06"|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Targatura|D41|Errore Targatura|Il Codice Targatura del tipo medicinale 2, 3, 4, 5, 6 può essere solo pari a '0' o a '000000000'. Questo errore viene restituito quando  per il tipo medicinale 2, 3, 4, 5, 6 Si valorizza un codice targatura  diverso da '0' o a '000000000'|se il valore del campo tipo_med è uguale a 2,3,4,5 or 6 del tracciato di input allora il campo targatura del tracciato di input può contenere solo 0.|Non Definito|Tipo Medicinale|Scarti|Basic|SINTATTICI|
|Codice Regime Attività|D50|Errore Codice Regime Attività|Il codice regime di attività non e' presente in anagrafica.|Il campo cod_reg_att deve essere diverso da NULL e presente in anagrafica Codici Regime Attività.  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |Codici Regime Attività;|Non Definito|Scarti|Anagrafica|SINTATTICI|
|Codice Unità Operativa Utilizzatrice|D51|Errore Codice Unita Operativa|Il codice unità operativa non e' presente in anagrafica|Se tipo_str = 01 (strutture di ricovero), allora il campo cod_un_op (se valorizzato) può essere uguale "0000" OR [i primi due caratteri di cod_un_op devono essere presenti in anagrafica Codici Unità Operative AND gli ultimi due caratteri di cod_un_op trasformati in intero devono valere tra 0 e 99].  Se tipo_str diverso da 01 non bisogna effettuare controlli, nemmeno di campo non vuoto  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |Codici Unità Operative|Tipo Struttura Utilizzatrice|Scarti|Anagrafica|SINTATTICI|
|Codice Unità Operativa Utilizzatrice|D52|Errore Codice Unita Operativa|Il codice unità operativa e' obbligatorio per il tipo medicinale indicato. Questo errore viene restituito quando, il codice unità operativa, per quella struttura non è presente in anagrafica|Se tipo_str="01" allora cod_un_op deve essere diverso da NULL|Non Definito|Non Definito|Scarti|Basic|OBBLIGATORIETA'  DEL DATO|



## ***3.4 Accesso alle anagrafiche***

I controlli applicativi saranno implementati a partire dall’acquisizione dei seguenti dati anagrafici disponibili in ambito MdS e recuperati con servizi ad hoc (Service Layer mediante PDI):

- Regioni
- ASL: modelli HSP11 e FLS11
- AIFA (medicinali)
- Elenco completo delle strutture: modelli HSP11, HSP11bis, STS11, RIA11, FLS11
- COD ATC 06
- ATC Farmaci
- Elenco completo dei codici di regime attività
- Elenco completo dei codici unità operative

All’interno del file **censimento\_anagrafiche** sono presenti per ogni anagrafica il dettaglio implementativo (Query SQL) e la tabella fisica da cui alimentare l’anagrafica.

Il dato anagrafico sarà presente sottoforma di tabella composta da tre colonne:

- Valore (in cui è riportato il dato, nel caso di più valori, sarà usato il carattere # come separatore).

- Data inizio validità (rappresenta la data di inizio validità del campo Valore)
 - Formato: AAAA-MM-DD
 - Notazione inizio validità permanente: **1900-01-01**


- Data Fine Validità (rappresenta la data di fine validità del campo Valore)

  - Formato: AAAA-MM-DD
  - Notazione fine validità permanente: **9999-12-31**

Affinchè le Business Rule che usano il dato anagrafico per effettuare controlli siano correttamente funzionanti occorre controllare che la data di competenza del record su cui si effettua il controllo (la quale varia in base alla componente) sia compresa tra le data di validità (ove presenti).

Di seguito viene mostrato un caso limite di anagrafica in cui sono presenti delle sovrapposizioni temporali e contraddizioni di validità permanente/specifico range.


|ID|VALUE|VALID\_FROM|VALID\_TO|
| - | - | - | - |
|1|VALORE 1|1900-01-01|9999-12-31|
|2|VALORE 1|2015-01-01|2015-12-31|
|3|VALORE 1|2018-01-01|2023-12-31|
|4|VALORE 1|2022-01-01|2024-12-31|


Diremo che :  il dato presente sul tracciato di input è valido se e solo se:

∃ VALUE\_R = VALUE\_A “tale che” VALID\_FROM<= **DATA\_COMPETENZA** <= VALID\_TO

(Esiste almeno un valore compreso tra le date di validità)

Dove:

- ` `VALUE\_R rappresenta i campi del tracciato di input coinvolti nei controlli della specifica BR

- VALUE\_A rappresenta i campi dell’anagrafica coinvolti nei controlli della specifica BR

- VALID\_FROM/VALID\_TO rappresentano le colonne dell’anagrafica

- DATA\_COMPETENZA rappresenta un campo sul tracciato di input con cui controllare il data anagrafico (ottenuto a partire da Anno e Mese di Consegna)


## ***3.5 Alimentazione MdS***

### **3.5.1 Invio Flussi**

A valle delle verifiche effettuate dal Validation Engine, qualora il caricamento sia stato effettuato con il parametro Tipo Elaborazione impostato a P, verranno inviati verso MdS tutti i record corretti secondo le regole di validazione impostate.

Verrà richiamata la procedura invioFlussi di GAF WS (tramite PDI) alla quale verranno passati in input i parametri così come riportati di seguito.


|**NOME PARAMETRO**|**VALORIZZAZIONE**|
| :- | :- |
|ANNO RIFERIMENTO|Parametro ANNO RIFERIMENTO in input a SDK|
|PERIODO RIFERIMENTO|Parametro PERIODO RIFERIMENTO in input a SDK |
|CATEGORIA FLUSSI|OSP|
|NOME FLUSSO|OSP|
|NOME FILE|Parametro popolato dall’SDK in fase di invio flusso con il nome file generato dal Validation Engine in fase di produzione file.|




### **3.5.2 Flussi di Output per alimentazione MdS**

Il flussi generati dall’SDK saranno presenti sotto la cartella /sdk/xml\_output e dovranno essere salvati e inviati verso MdS rispettando la nomenclatura presente nei paragrafi successivi.

SDK\_OSP\_OSP\_13\_{ID\_RUN}.xml

Dove :

- ID\_RUN rappresenta l’identificativo univoco

### **3.5.3 Gestione Risposta Mds**

A valle della presa in carico del dato da parte di MdS, SDK riceverà una response contenente le seguenti informazioni:

1. **codiceFornitura**: stringa numerica indicante l’identificativo univoco della fornitura inviata al GAF
1. **errorCode**: stringa alfanumerica di 256 caratteri rappresentante il codice identificativo dell’errore eventualmente riscontrato
1. **errorText**: stringa alfanumerica di 256 caratteri rappresentante il descrittivo dell’errore eventualmente riscontrato
1. Insieme delle seguenti triple, una per ogni file inviato:
1. **idUpload**: stringa numerica indicante l’identificativo univoco del singolo file ricevuto ed accettato dal MdS, e corrispondente al file inviato con la denominazione riportata nell’elemento “nomeFile” che segue
1. **esito**: stringa alfanumerica di 4 caratteri rappresentante l’esito dell’operazione (Vedi tabella sotto)
1. **nomeFile**: stringa alfanumerica di 256 caratteri rappresentante il nome dei file inviati.

Di seguito la tabella di riepilogo dei codici degli esiti possibili dell’invio del file


|**ESITO**|**DESCRIZIONE**|
| :- | :- |
|AE00|Errore di autenticazione al servizio|
|IF00|Operazione completata con successo|
|IF01|Incongruenza tra CF utente firmatario e cf utente inviante|
|IF02|Firma digitale non valida|
|IF03|Firma digitale scaduta|
|IF04|Estensione non ammessa|
|IF05|Utente non abilitato all’invio per la Categoria Flusso indicata|
|IF06|Utente non abilitato all’invio per il Flusso indicata|
|IF07|Periodo non congurente con la Categoria Flusso indicata|
|IF08|Il file inviato è vuoto|
|IF09|Errore interno al servizio nella ricezione del file|
|IF10|Il numero di allegati segnalati nel body non corrisponde al numero di allegati riscontrati nella request|
|IF11|Il nome dell’allegato riportato nel body non è presente tra gli allegati della request (content-id)|
|IF12|Presenza di nomi file duplicati|
|IF13|Errore interno al servizio nella ricezione del file|
|IF14|Errore interno al servizio nella ricezione del file|
|IF15|Errore interno al servizio nella ricezione del file|
|IF99|Errore generico dell’operation|

Copia dei file inviati verso MdS il cui esito è positivo (ovvero risposta della procedura Invio Flussi con IF00) saranno trasferiti e memorizzati in una cartella ad hoc di SDK (es. /sdk/sent) rispettando la naming riportata di seguito.

SDK\_OSP\_OSP\_13\_{ID\_RUN}.xml

Dove :

- ID\_RUN rappresenta l’identificativo univoco

## ***3.6 Scarti di processamento***

In una cartella dedicata (es. /sdk/esiti) verrà creato un file json contenente il dettaglio degli scarti riscontrati ad ogni esecuzione del processo SDK.

Il naming del file sarà:  ESITO\_{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.


|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|NUMERO RECORD|Numero del record del flusso input|
|RECORD PROCESSATO|Campi esterni rispetto al tracciato, che sono necessari per la validazione dello stesso.|
||Record su cui si è verificato uno scarto, riportato in maniera strutturata (nome\_campo-valore).|
|LISTA ESITI|<p>Lista di oggetti contenente l’esito di validazione per ciascun campo:</p><p>- Campo: nome campo su cui si è verificato uno scarto</p><p>- Valore Scarto: valore del campo su cui si è verificato uno scarto</p><p>- Valore Esito: esito di validazione del particolare campo</p><p>- Errori Validazione: contiene i campi Codice (della Business Rule) e Descrizione (della Business Rule)</p>|

## ***3.7 Informazioni dell’esecuzione***

In una cartella dedicata (es. /sdk/run) verrà creato un file contenente il dettaglio degli esiti riscontrati ad ogni esecuzione del processo SDK. Verrà prodotto un file di log per ogni giorno di elaborazione.

Il naming del file sarà:  

{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.


|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|ID RUN (chiave)|Identificativo univoco di ogni esecuzione del SDK|
|ID\_CLIENT|Identificativo Univoco della trasazione sorgente che richiede processamento lato SDK|
|ID UPLOAD (chiave)|Identificativo di caricamento fornito da MdS|
|TIPO ELABORAZIONE|F (full)/R (per singolo record) - Impostato di default a F|
|MODALITA’ OPERATIVA|P (=produzione) /T (=test)|
|DATA INIZIO ESECUZIONE|Timestamp dell’ inizio del processamento|
|DATA FINE ESECUZIONE|Timestamp di completamento del processamento|
|STATO ESECUZIONE |<p>Esito dell’esecuzione dell’ SDK. </p><p>Possibili valori: </p><p>- IN ELABORAZIONE: Sdk in esecuzione;</p><p>- ELABORATA: Esecuzione completata con successo;</p><p>- KO: Esecuzione fallita: </p><p>- KO SPECIFICO: Esecuzione fallita per una fase/componente più rilevante della soluzione (es. ko\_gestione\_file, ko\_gestione\_validazione, ko\_invio\_ministero, etc.); </p><p>- KO GENERICO: un errore generico non controllato.</p>|
|FILE ASSOCIATI RUN|Nome del file di input elaborato dall’SDK|
|NOME FLUSSO|Valore fisso che identifica lo specifico SDK in termini di categoria e nome flusso|
|NUMERO RECORD |Numero di record del flusso input|
|NUMERO RECORD ACCETTATI|Numero validi|
|NUMERO RECORD SCARTATI|Numero scarti|
|VERSION|Versione del SDK (Access Layer e Validation Engine)|
|TIMESTAMP CREAZIONE|Timestamp creazione della info run|
|API (\*DPM)|Rappresenta L’API utilizzata per il flusso DPM (non valorizzata per gli altri flussi)|
|IDENTIFICATIVO SOGGETTO ALIMENTANTE (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|NUMERO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ESITO MDS (\*DPM)|Esito della response dell’API 2 (non valorizzata per gli altri flussi) |
|DATA RICEVUTA MDS (\*DPM)|Data della response dell’API 3 (non valorizzata per gli altri flussi)|
|CODICE REGIONE|Codice Regione del Mittente|
|ANNO RIFERIMENTO|Anno cui si riferiscono i dati del flusso|
|PERIODO DI RIFERIMENTO|Rappresenta il periodo di riferimento passato in input all’SDK|
|DESCRIZIONE STATO ESECUZIONE |Specifica il messaggio breve dell’errore, maggiori informazioni saranno presenti all’interno del log applicativo|
|NOME FILE OUTPUT MDS|Nome dei file di output inviati verso MdS|
|ESITO ACQUISIZIONE FLUSSO|Codice dell’esito del processo di acquisizione del flusso su MdS. Tale campo riflette la proprietà invioFlussiReturn/listaEsitiUpload/item/esito della response della procedura **invioFlussi**. (Es IF00)|
|CODICE ERRORE INVIO FLUSSI|Codice d’errore della procedura di invio. Tale campo riflette la proprietà InvioFlussiReturn/errorCode della response della procedura **invioFlussi**|
|TESTO ERRORE INVIO FLUSSI|Descrizione codice d’errore della procedura.Tale campo riflette la proprietà InvioFlussiReturn/ errorText della response della procedura **invioFlussi**|

Inoltre, a supporto dell’entità che rappresenta lo stato dell’esecuzione, sotto la cartella /sdk/log, saranno presenti anche i file di log applicativi (aggregati giornalmente) non strutturati, nei quali saranno presenti informazioni aggiuntive, ad esempio lo StackTrace (in caso di errori).

Il naming del file, se non modificata la politica di rolling (impostazioni) è indicata di seguito:


SDK \_OSP-OSP.log

## mantainer:
 Accenture SpA until January 2026