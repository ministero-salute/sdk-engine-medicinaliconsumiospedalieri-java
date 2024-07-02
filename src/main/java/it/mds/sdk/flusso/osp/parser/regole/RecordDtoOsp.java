/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp.parser.regole;

import com.opencsv.bean.CsvBindByPosition;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordDtoOsp extends RecordDtoGenerico {

    @CsvBindByPosition(position = 0)
    private String codiceRegione;

    @CsvBindByPosition(position = 1)
    private String codiceAziendaSanitaria;

    @CsvBindByPosition(position = 2)
    private String tipoStrutturaUtilizzatrice;

    @CsvBindByPosition(position = 3)
    private String codiceStrutturaUtilizzatrice;

    @CsvBindByPosition(position = 4)
    private String codiceRegimeAttivita;

    @CsvBindByPosition(position = 5)
    private String codiceUnitaOperativaUtilizzatrice;

    @CsvBindByPosition(position = 6)
    private String annoConsegna;

    @CsvBindByPosition(position = 7)
    private String meseConsegna;

    @CsvBindByPosition(position = 8)
    private String tipoMedicinale;

    @CsvBindByPosition(position = 9)
    private String codiceMedicinale;

    @CsvBindByPosition(position = 10)
    private String targatura;

    @CsvBindByPosition(position = 11)
    private String costoAcquisto;

    @CsvBindByPosition(position = 12)
    private String quantita;

    @CsvBindByPosition(position = 13)
    private Integer fattoreConversione;

    @CsvBindByPosition(position = 14)
    private String tipoOperazione;

}
