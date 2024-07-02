//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.10.19 alle 09:46:11 AM CEST 
//


/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.flusso.osp.tracciato.output;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="REGIONE" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PERIODO"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="AS" maxOccurs="unbounded"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="TARGATURE"&gt;
 *                                                                                 &lt;complexType&gt;
 *                                                                                   &lt;complexContent&gt;
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                                       &lt;sequence&gt;
 *                                                                                         &lt;element name="COD" maxOccurs="unbounded"&gt;
 *                                                                                           &lt;simpleType&gt;
 *                                                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                               &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
 *                                                                                             &lt;/restriction&gt;
 *                                                                                           &lt;/simpleType&gt;
 *                                                                                         &lt;/element&gt;
 *                                                                                       &lt;/sequence&gt;
 *                                                                                     &lt;/restriction&gt;
 *                                                                                   &lt;/complexContent&gt;
 *                                                                                 &lt;/complexType&gt;
 *                                                                               &lt;/element&gt;
 *                                                                             &lt;/sequence&gt;
 *                                                                             &lt;attribute name="cod_reg_att" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;enumeration value="0"/&gt;
 *                                                                                   &lt;enumeration value="1"/&gt;
 *                                                                                   &lt;enumeration value="2"/&gt;
 *                                                                                   &lt;enumeration value="3"/&gt;
 *                                                                                   &lt;enumeration value="4"/&gt;
 *                                                                                   &lt;enumeration value="5"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="tip_med" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;enumeration value="1"/&gt;
 *                                                                                   &lt;enumeration value="2"/&gt;
 *                                                                                   &lt;enumeration value="3"/&gt;
 *                                                                                   &lt;enumeration value="4"/&gt;
 *                                                                                   &lt;enumeration value="5"/&gt;
 *                                                                                   &lt;enumeration value="6"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="cod_med"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="costo_acq" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="qta" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="fatt_conv" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                                                                   &lt;minInclusive value="1"/&gt;
 *                                                                                   &lt;maxInclusive value="999999"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                   &lt;attribute name="cod_un_op"&gt;
 *                                                                     &lt;simpleType&gt;
 *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                         &lt;pattern value="[0-9]{4}"/&gt;
 *                                                                       &lt;/restriction&gt;
 *                                                                     &lt;/simpleType&gt;
 *                                                                   &lt;/attribute&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                         &lt;attribute name="tipo_str" use="required"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;pattern value="[0-9]{2}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                         &lt;attribute name="cod_str" use="required"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                               &lt;attribute name="cod_as" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{6}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="tipo_op" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="I"/&gt;
 *                                           &lt;enumeration value="V"/&gt;
 *                                           &lt;enumeration value="C"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="mese" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="01"/&gt;
 *                                 &lt;enumeration value="02"/&gt;
 *                                 &lt;enumeration value="03"/&gt;
 *                                 &lt;enumeration value="04"/&gt;
 *                                 &lt;enumeration value="05"/&gt;
 *                                 &lt;enumeration value="06"/&gt;
 *                                 &lt;enumeration value="07"/&gt;
 *                                 &lt;enumeration value="08"/&gt;
 *                                 &lt;enumeration value="09"/&gt;
 *                                 &lt;enumeration value="10"/&gt;
 *                                 &lt;enumeration value="11"/&gt;
 *                                 &lt;enumeration value="12"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                           &lt;attribute name="anno" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="cod_reg" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;pattern value="[0-9]{3}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CANCELLAZIONE_MASSIVA_DATI"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="REGIONE"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PERIODO"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;attribute name="cod_as" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{6}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="mese" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="01"/&gt;
 *                                           &lt;enumeration value="02"/&gt;
 *                                           &lt;enumeration value="03"/&gt;
 *                                           &lt;enumeration value="04"/&gt;
 *                                           &lt;enumeration value="05"/&gt;
 *                                           &lt;enumeration value="06"/&gt;
 *                                           &lt;enumeration value="07"/&gt;
 *                                           &lt;enumeration value="08"/&gt;
 *                                           &lt;enumeration value="09"/&gt;
 *                                           &lt;enumeration value="10"/&gt;
 *                                           &lt;enumeration value="11"/&gt;
 *                                           &lt;enumeration value="12"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                     &lt;attribute name="anno" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="cod_reg" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="[0-9]{3}"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regione",
    "cancellazionemassivadati"
})
@XmlRootElement(name = "dataroot")
public class Dataroot {

    @XmlElement(name = "REGIONE")
    protected Dataroot.REGIONE regione;
    @XmlElement(name = "CANCELLAZIONE_MASSIVA_DATI")
    protected Dataroot.CANCELLAZIONEMASSIVADATI cancellazionemassivadati;

    /**
     * Recupera il valore della proprietà regione.
     * 
     * @return
     *     possible object is
     *     {@link Dataroot.REGIONE }
     *     
     */
    public Dataroot.REGIONE getREGIONE() {
        return regione;
    }

    /**
     * Imposta il valore della proprietà regione.
     * 
     * @param value
     *     allowed object is
     *     {@link Dataroot.REGIONE }
     *     
     */
    public void setREGIONE(Dataroot.REGIONE value) {
        this.regione = value;
    }

    /**
     * Recupera il valore della proprietà cancellazionemassivadati.
     * 
     * @return
     *     possible object is
     *     {@link Dataroot.CANCELLAZIONEMASSIVADATI }
     *     
     */
    public Dataroot.CANCELLAZIONEMASSIVADATI getCANCELLAZIONEMASSIVADATI() {
        return cancellazionemassivadati;
    }

    /**
     * Imposta il valore della proprietà cancellazionemassivadati.
     * 
     * @param value
     *     allowed object is
     *     {@link Dataroot.CANCELLAZIONEMASSIVADATI }
     *     
     */
    public void setCANCELLAZIONEMASSIVADATI(Dataroot.CANCELLAZIONEMASSIVADATI value) {
        this.cancellazionemassivadati = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="REGIONE"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PERIODO"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;attribute name="cod_as" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{6}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="mese" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="01"/&gt;
     *                                 &lt;enumeration value="02"/&gt;
     *                                 &lt;enumeration value="03"/&gt;
     *                                 &lt;enumeration value="04"/&gt;
     *                                 &lt;enumeration value="05"/&gt;
     *                                 &lt;enumeration value="06"/&gt;
     *                                 &lt;enumeration value="07"/&gt;
     *                                 &lt;enumeration value="08"/&gt;
     *                                 &lt;enumeration value="09"/&gt;
     *                                 &lt;enumeration value="10"/&gt;
     *                                 &lt;enumeration value="11"/&gt;
     *                                 &lt;enumeration value="12"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                           &lt;attribute name="anno" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="cod_reg" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="[0-9]{3}"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regione"
    })
    public static class CANCELLAZIONEMASSIVADATI {

        @XmlElement(name = "REGIONE", required = true)
        protected Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE regione;

        /**
         * Recupera il valore della proprietà regione.
         * 
         * @return
         *     possible object is
         *     {@link Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE }
         *     
         */
        public Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE getREGIONE() {
            return regione;
        }

        /**
         * Imposta il valore della proprietà regione.
         * 
         * @param value
         *     allowed object is
         *     {@link Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE }
         *     
         */
        public void setREGIONE(Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE value) {
            this.regione = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PERIODO"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;attribute name="cod_as" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{6}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="mese" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="01"/&gt;
         *                       &lt;enumeration value="02"/&gt;
         *                       &lt;enumeration value="03"/&gt;
         *                       &lt;enumeration value="04"/&gt;
         *                       &lt;enumeration value="05"/&gt;
         *                       &lt;enumeration value="06"/&gt;
         *                       &lt;enumeration value="07"/&gt;
         *                       &lt;enumeration value="08"/&gt;
         *                       &lt;enumeration value="09"/&gt;
         *                       &lt;enumeration value="10"/&gt;
         *                       &lt;enumeration value="11"/&gt;
         *                       &lt;enumeration value="12"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *                 &lt;attribute name="anno" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="cod_reg" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="[0-9]{3}"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "periodo"
        })
        public static class REGIONE {

            @XmlElement(name = "PERIODO", required = true)
            protected Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO periodo;
            @XmlAttribute(name = "cod_reg", required = true)
            protected String codReg;

            /**
             * Recupera il valore della proprietà periodo.
             * 
             * @return
             *     possible object is
             *     {@link Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO }
             *     
             */
            public Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO getPERIODO() {
                return periodo;
            }

            /**
             * Imposta il valore della proprietà periodo.
             * 
             * @param value
             *     allowed object is
             *     {@link Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO }
             *     
             */
            public void setPERIODO(Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO value) {
                this.periodo = value;
            }

            /**
             * Recupera il valore della proprietà codReg.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodReg() {
                return codReg;
            }

            /**
             * Imposta il valore della proprietà codReg.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodReg(String value) {
                this.codReg = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;attribute name="cod_as" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{6}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="mese" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="01"/&gt;
             *             &lt;enumeration value="02"/&gt;
             *             &lt;enumeration value="03"/&gt;
             *             &lt;enumeration value="04"/&gt;
             *             &lt;enumeration value="05"/&gt;
             *             &lt;enumeration value="06"/&gt;
             *             &lt;enumeration value="07"/&gt;
             *             &lt;enumeration value="08"/&gt;
             *             &lt;enumeration value="09"/&gt;
             *             &lt;enumeration value="10"/&gt;
             *             &lt;enumeration value="11"/&gt;
             *             &lt;enumeration value="12"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *       &lt;attribute name="anno" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "as"
            })
            public static class PERIODO {

                @XmlElement(name = "AS")
                protected List<Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO.AS> as;
                @XmlAttribute(name = "mese", required = true)
                protected String mese;
                @XmlAttribute(name = "anno", required = true)
                protected String anno;

                /**
                 * Gets the value of the as property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the as property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAS().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO.AS }
                 * 
                 * 
                 */
                public List<Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO.AS> getAS() {
                    if (as == null) {
                        as = new ArrayList<Dataroot.CANCELLAZIONEMASSIVADATI.REGIONE.PERIODO.AS>();
                    }
                    return this.as;
                }

                /**
                 * Recupera il valore della proprietà mese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMese() {
                    return mese;
                }

                /**
                 * Imposta il valore della proprietà mese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMese(String value) {
                    this.mese = value;
                }

                /**
                 * Recupera il valore della proprietà anno.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAnno() {
                    return anno;
                }

                /**
                 * Imposta il valore della proprietà anno.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAnno(String value) {
                    this.anno = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;attribute name="cod_as" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{6}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class AS {

                    @XmlAttribute(name = "cod_as", required = true)
                    protected String codAs;

                    /**
                     * Recupera il valore della proprietà codAs.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodAs() {
                        return codAs;
                    }

                    /**
                     * Imposta il valore della proprietà codAs.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodAs(String value) {
                        this.codAs = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PERIODO"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="AS" maxOccurs="unbounded"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="TARGATURE"&gt;
     *                                                                       &lt;complexType&gt;
     *                                                                         &lt;complexContent&gt;
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                             &lt;sequence&gt;
     *                                                                               &lt;element name="COD" maxOccurs="unbounded"&gt;
     *                                                                                 &lt;simpleType&gt;
     *                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                                     &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
     *                                                                                   &lt;/restriction&gt;
     *                                                                                 &lt;/simpleType&gt;
     *                                                                               &lt;/element&gt;
     *                                                                             &lt;/sequence&gt;
     *                                                                           &lt;/restriction&gt;
     *                                                                         &lt;/complexContent&gt;
     *                                                                       &lt;/complexType&gt;
     *                                                                     &lt;/element&gt;
     *                                                                   &lt;/sequence&gt;
     *                                                                   &lt;attribute name="cod_reg_att" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;enumeration value="0"/&gt;
     *                                                                         &lt;enumeration value="1"/&gt;
     *                                                                         &lt;enumeration value="2"/&gt;
     *                                                                         &lt;enumeration value="3"/&gt;
     *                                                                         &lt;enumeration value="4"/&gt;
     *                                                                         &lt;enumeration value="5"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="tip_med" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;enumeration value="1"/&gt;
     *                                                                         &lt;enumeration value="2"/&gt;
     *                                                                         &lt;enumeration value="3"/&gt;
     *                                                                         &lt;enumeration value="4"/&gt;
     *                                                                         &lt;enumeration value="5"/&gt;
     *                                                                         &lt;enumeration value="6"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="cod_med"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="costo_acq" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="qta" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="fatt_conv" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                                                         &lt;minInclusive value="1"/&gt;
     *                                                                         &lt;maxInclusive value="999999"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                         &lt;/sequence&gt;
     *                                                         &lt;attribute name="cod_un_op"&gt;
     *                                                           &lt;simpleType&gt;
     *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                               &lt;pattern value="[0-9]{4}"/&gt;
     *                                                             &lt;/restriction&gt;
     *                                                           &lt;/simpleType&gt;
     *                                                         &lt;/attribute&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                               &lt;attribute name="tipo_str" use="required"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;pattern value="[0-9]{2}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                               &lt;attribute name="cod_str" use="required"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                     &lt;attribute name="cod_as" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{6}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="tipo_op" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="I"/&gt;
     *                                 &lt;enumeration value="V"/&gt;
     *                                 &lt;enumeration value="C"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="mese" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;enumeration value="01"/&gt;
     *                       &lt;enumeration value="02"/&gt;
     *                       &lt;enumeration value="03"/&gt;
     *                       &lt;enumeration value="04"/&gt;
     *                       &lt;enumeration value="05"/&gt;
     *                       &lt;enumeration value="06"/&gt;
     *                       &lt;enumeration value="07"/&gt;
     *                       &lt;enumeration value="08"/&gt;
     *                       &lt;enumeration value="09"/&gt;
     *                       &lt;enumeration value="10"/&gt;
     *                       &lt;enumeration value="11"/&gt;
     *                       &lt;enumeration value="12"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *                 &lt;attribute name="anno" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="cod_reg" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;pattern value="[0-9]{3}"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "periodo"
    })
    public static class REGIONE {

        @XmlElement(name = "PERIODO", required = true)
        protected Dataroot.REGIONE.PERIODO periodo;
        @XmlAttribute(name = "cod_reg", required = true)
        protected String codReg;

        /**
         * Recupera il valore della proprietà periodo.
         * 
         * @return
         *     possible object is
         *     {@link Dataroot.REGIONE.PERIODO }
         *     
         */
        public Dataroot.REGIONE.PERIODO getPERIODO() {
            return periodo;
        }

        /**
         * Imposta il valore della proprietà periodo.
         * 
         * @param value
         *     allowed object is
         *     {@link Dataroot.REGIONE.PERIODO }
         *     
         */
        public void setPERIODO(Dataroot.REGIONE.PERIODO value) {
            this.periodo = value;
        }

        /**
         * Recupera il valore della proprietà codReg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodReg() {
            return codReg;
        }

        /**
         * Imposta il valore della proprietà codReg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodReg(String value) {
            this.codReg = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="AS" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="TARGATURE"&gt;
         *                                                             &lt;complexType&gt;
         *                                                               &lt;complexContent&gt;
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                                   &lt;sequence&gt;
         *                                                                     &lt;element name="COD" maxOccurs="unbounded"&gt;
         *                                                                       &lt;simpleType&gt;
         *                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                                           &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
         *                                                                         &lt;/restriction&gt;
         *                                                                       &lt;/simpleType&gt;
         *                                                                     &lt;/element&gt;
         *                                                                   &lt;/sequence&gt;
         *                                                                 &lt;/restriction&gt;
         *                                                               &lt;/complexContent&gt;
         *                                                             &lt;/complexType&gt;
         *                                                           &lt;/element&gt;
         *                                                         &lt;/sequence&gt;
         *                                                         &lt;attribute name="cod_reg_att" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;enumeration value="0"/&gt;
         *                                                               &lt;enumeration value="1"/&gt;
         *                                                               &lt;enumeration value="2"/&gt;
         *                                                               &lt;enumeration value="3"/&gt;
         *                                                               &lt;enumeration value="4"/&gt;
         *                                                               &lt;enumeration value="5"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="tip_med" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;enumeration value="1"/&gt;
         *                                                               &lt;enumeration value="2"/&gt;
         *                                                               &lt;enumeration value="3"/&gt;
         *                                                               &lt;enumeration value="4"/&gt;
         *                                                               &lt;enumeration value="5"/&gt;
         *                                                               &lt;enumeration value="6"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="cod_med"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="costo_acq" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="qta" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="fatt_conv" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                                                               &lt;minInclusive value="1"/&gt;
         *                                                               &lt;maxInclusive value="999999"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                               &lt;/sequence&gt;
         *                                               &lt;attribute name="cod_un_op"&gt;
         *                                                 &lt;simpleType&gt;
         *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                     &lt;pattern value="[0-9]{4}"/&gt;
         *                                                   &lt;/restriction&gt;
         *                                                 &lt;/simpleType&gt;
         *                                               &lt;/attribute&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/sequence&gt;
         *                                     &lt;attribute name="tipo_str" use="required"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;pattern value="[0-9]{2}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                     &lt;attribute name="cod_str" use="required"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                           &lt;attribute name="cod_as" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{6}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="tipo_op" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="I"/&gt;
         *                       &lt;enumeration value="V"/&gt;
         *                       &lt;enumeration value="C"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="mese" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="01"/&gt;
         *             &lt;enumeration value="02"/&gt;
         *             &lt;enumeration value="03"/&gt;
         *             &lt;enumeration value="04"/&gt;
         *             &lt;enumeration value="05"/&gt;
         *             &lt;enumeration value="06"/&gt;
         *             &lt;enumeration value="07"/&gt;
         *             &lt;enumeration value="08"/&gt;
         *             &lt;enumeration value="09"/&gt;
         *             &lt;enumeration value="10"/&gt;
         *             &lt;enumeration value="11"/&gt;
         *             &lt;enumeration value="12"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *       &lt;attribute name="anno" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "operazione"
        })
        public static class PERIODO {

            @XmlElement(name = "OPERAZIONE", required = true)
            protected List<Dataroot.REGIONE.PERIODO.OPERAZIONE> operazione;
            @XmlAttribute(name = "mese", required = true)
            protected String mese;
            @XmlAttribute(name = "anno", required = true)
            protected String anno;

            /**
             * Gets the value of the operazione property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the operazione property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOPERAZIONE().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Dataroot.REGIONE.PERIODO.OPERAZIONE }
             * 
             * 
             */
            public List<Dataroot.REGIONE.PERIODO.OPERAZIONE> getOPERAZIONE() {
                if (operazione == null) {
                    operazione = new ArrayList<Dataroot.REGIONE.PERIODO.OPERAZIONE>();
                }
                return this.operazione;
            }

            /**
             * Recupera il valore della proprietà mese.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMese() {
                return mese;
            }

            /**
             * Imposta il valore della proprietà mese.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMese(String value) {
                this.mese = value;
            }

            /**
             * Recupera il valore della proprietà anno.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAnno() {
                return anno;
            }

            /**
             * Imposta il valore della proprietà anno.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAnno(String value) {
                this.anno = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="AS" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="TARGATURE"&gt;
             *                                                   &lt;complexType&gt;
             *                                                     &lt;complexContent&gt;
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                                         &lt;sequence&gt;
             *                                                           &lt;element name="COD" maxOccurs="unbounded"&gt;
             *                                                             &lt;simpleType&gt;
             *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                                 &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
             *                                                               &lt;/restriction&gt;
             *                                                             &lt;/simpleType&gt;
             *                                                           &lt;/element&gt;
             *                                                         &lt;/sequence&gt;
             *                                                       &lt;/restriction&gt;
             *                                                     &lt;/complexContent&gt;
             *                                                   &lt;/complexType&gt;
             *                                                 &lt;/element&gt;
             *                                               &lt;/sequence&gt;
             *                                               &lt;attribute name="cod_reg_att" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;enumeration value="0"/&gt;
             *                                                     &lt;enumeration value="1"/&gt;
             *                                                     &lt;enumeration value="2"/&gt;
             *                                                     &lt;enumeration value="3"/&gt;
             *                                                     &lt;enumeration value="4"/&gt;
             *                                                     &lt;enumeration value="5"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="tip_med" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;enumeration value="1"/&gt;
             *                                                     &lt;enumeration value="2"/&gt;
             *                                                     &lt;enumeration value="3"/&gt;
             *                                                     &lt;enumeration value="4"/&gt;
             *                                                     &lt;enumeration value="5"/&gt;
             *                                                     &lt;enumeration value="6"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="cod_med"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="costo_acq" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="qta" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="fatt_conv" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *                                                     &lt;minInclusive value="1"/&gt;
             *                                                     &lt;maxInclusive value="999999"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                     &lt;/sequence&gt;
             *                                     &lt;attribute name="cod_un_op"&gt;
             *                                       &lt;simpleType&gt;
             *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                           &lt;pattern value="[0-9]{4}"/&gt;
             *                                         &lt;/restriction&gt;
             *                                       &lt;/simpleType&gt;
             *                                     &lt;/attribute&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                           &lt;/sequence&gt;
             *                           &lt;attribute name="tipo_str" use="required"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;pattern value="[0-9]{2}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                           &lt;attribute name="cod_str" use="required"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *                 &lt;attribute name="cod_as" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{6}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="tipo_op" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="I"/&gt;
             *             &lt;enumeration value="V"/&gt;
             *             &lt;enumeration value="C"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "as"
            })
            public static class OPERAZIONE {

                @XmlElement(name = "AS", required = true)
                protected List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS> as;
                @XmlAttribute(name = "tipo_op", required = true)
                protected String tipoOp;

                /**
                 * Gets the value of the as property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the as property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAS().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS }
                 * 
                 * 
                 */
                public List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS> getAS() {
                    if (as == null) {
                        as = new ArrayList<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS>();
                    }
                    return this.as;
                }

                /**
                 * Recupera il valore della proprietà tipoOp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTipoOp() {
                    return tipoOp;
                }

                /**
                 * Imposta il valore della proprietà tipoOp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTipoOp(String value) {
                    this.tipoOp = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="TARGATURE"&gt;
                 *                                         &lt;complexType&gt;
                 *                                           &lt;complexContent&gt;
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                               &lt;sequence&gt;
                 *                                                 &lt;element name="COD" maxOccurs="unbounded"&gt;
                 *                                                   &lt;simpleType&gt;
                 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                                       &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                 *                                                     &lt;/restriction&gt;
                 *                                                   &lt;/simpleType&gt;
                 *                                                 &lt;/element&gt;
                 *                                               &lt;/sequence&gt;
                 *                                             &lt;/restriction&gt;
                 *                                           &lt;/complexContent&gt;
                 *                                         &lt;/complexType&gt;
                 *                                       &lt;/element&gt;
                 *                                     &lt;/sequence&gt;
                 *                                     &lt;attribute name="cod_reg_att" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;enumeration value="0"/&gt;
                 *                                           &lt;enumeration value="1"/&gt;
                 *                                           &lt;enumeration value="2"/&gt;
                 *                                           &lt;enumeration value="3"/&gt;
                 *                                           &lt;enumeration value="4"/&gt;
                 *                                           &lt;enumeration value="5"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="tip_med" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;enumeration value="1"/&gt;
                 *                                           &lt;enumeration value="2"/&gt;
                 *                                           &lt;enumeration value="3"/&gt;
                 *                                           &lt;enumeration value="4"/&gt;
                 *                                           &lt;enumeration value="5"/&gt;
                 *                                           &lt;enumeration value="6"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="cod_med"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="costo_acq" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="qta" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="fatt_conv" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                 *                                           &lt;minInclusive value="1"/&gt;
                 *                                           &lt;maxInclusive value="999999"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                           &lt;/sequence&gt;
                 *                           &lt;attribute name="cod_un_op"&gt;
                 *                             &lt;simpleType&gt;
                 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                 &lt;pattern value="[0-9]{4}"/&gt;
                 *                               &lt;/restriction&gt;
                 *                             &lt;/simpleType&gt;
                 *                           &lt;/attribute&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                 &lt;/sequence&gt;
                 *                 &lt;attribute name="tipo_str" use="required"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;pattern value="[0-9]{2}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *                 &lt;attribute name="cod_str" use="required"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *       &lt;attribute name="cod_as" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{6}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "struttura"
                })
                public static class AS {

                    @XmlElement(name = "STRUTTURA", required = true)
                    protected List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA> struttura;
                    @XmlAttribute(name = "cod_as", required = true)
                    protected String codAs;

                    /**
                     * Gets the value of the struttura property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the Jakarta XML Binding object.
                     * This is why there is not a <CODE>set</CODE> method for the struttura property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getSTRUTTURA().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA }
                     * 
                     * 
                     */
                    public List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA> getSTRUTTURA() {
                        if (struttura == null) {
                            struttura = new ArrayList<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA>();
                        }
                        return this.struttura;
                    }

                    /**
                     * Recupera il valore della proprietà codAs.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodAs() {
                        return codAs;
                    }

                    /**
                     * Imposta il valore della proprietà codAs.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodAs(String value) {
                        this.codAs = value;
                    }


                    /**
                     * <p>Classe Java per anonymous complex type.
                     * 
                     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="TARGATURE"&gt;
                     *                               &lt;complexType&gt;
                     *                                 &lt;complexContent&gt;
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                                     &lt;sequence&gt;
                     *                                       &lt;element name="COD" maxOccurs="unbounded"&gt;
                     *                                         &lt;simpleType&gt;
                     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                             &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                     *                                           &lt;/restriction&gt;
                     *                                         &lt;/simpleType&gt;
                     *                                       &lt;/element&gt;
                     *                                     &lt;/sequence&gt;
                     *                                   &lt;/restriction&gt;
                     *                                 &lt;/complexContent&gt;
                     *                               &lt;/complexType&gt;
                     *                             &lt;/element&gt;
                     *                           &lt;/sequence&gt;
                     *                           &lt;attribute name="cod_reg_att" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;enumeration value="0"/&gt;
                     *                                 &lt;enumeration value="1"/&gt;
                     *                                 &lt;enumeration value="2"/&gt;
                     *                                 &lt;enumeration value="3"/&gt;
                     *                                 &lt;enumeration value="4"/&gt;
                     *                                 &lt;enumeration value="5"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="tip_med" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;enumeration value="1"/&gt;
                     *                                 &lt;enumeration value="2"/&gt;
                     *                                 &lt;enumeration value="3"/&gt;
                     *                                 &lt;enumeration value="4"/&gt;
                     *                                 &lt;enumeration value="5"/&gt;
                     *                                 &lt;enumeration value="6"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="cod_med"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="costo_acq" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="qta" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="fatt_conv" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                     *                                 &lt;minInclusive value="1"/&gt;
                     *                                 &lt;maxInclusive value="999999"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                 &lt;/sequence&gt;
                     *                 &lt;attribute name="cod_un_op"&gt;
                     *                   &lt;simpleType&gt;
                     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                       &lt;pattern value="[0-9]{4}"/&gt;
                     *                     &lt;/restriction&gt;
                     *                   &lt;/simpleType&gt;
                     *                 &lt;/attribute&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *       &lt;/sequence&gt;
                     *       &lt;attribute name="tipo_str" use="required"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;pattern value="[0-9]{2}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *       &lt;attribute name="cod_str" use="required"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;pattern value="[0-9a-zA-Z\-]{1,8}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "unitop"
                    })
                    public static class STRUTTURA {

                        @XmlElement(name = "UNIT_OP", required = true)
                        protected List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP> unitop;
                        @XmlAttribute(name = "tipo_str", required = true)
                        protected String tipoStr;
                        @XmlAttribute(name = "cod_str", required = true)
                        protected String codStr;

                        /**
                         * Gets the value of the unitop property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the Jakarta XML Binding object.
                         * This is why there is not a <CODE>set</CODE> method for the unitop property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getUNITOP().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP }
                         * 
                         * 
                         */
                        public List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP> getUNITOP() {
                            if (unitop == null) {
                                unitop = new ArrayList<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP>();
                            }
                            return this.unitop;
                        }

                        /**
                         * Recupera il valore della proprietà tipoStr.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getTipoStr() {
                            return tipoStr;
                        }

                        /**
                         * Imposta il valore della proprietà tipoStr.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setTipoStr(String value) {
                            this.tipoStr = value;
                        }

                        /**
                         * Recupera il valore della proprietà codStr.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCodStr() {
                            return codStr;
                        }

                        /**
                         * Imposta il valore della proprietà codStr.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCodStr(String value) {
                            this.codStr = value;
                        }


                        /**
                         * <p>Classe Java per anonymous complex type.
                         * 
                         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                         * 
                         * <pre>
                         * &lt;complexType&gt;
                         *   &lt;complexContent&gt;
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *       &lt;sequence&gt;
                         *         &lt;element name="MEDICINALE" maxOccurs="unbounded"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="TARGATURE"&gt;
                         *                     &lt;complexType&gt;
                         *                       &lt;complexContent&gt;
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                           &lt;sequence&gt;
                         *                             &lt;element name="COD" maxOccurs="unbounded"&gt;
                         *                               &lt;simpleType&gt;
                         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                                   &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                         *                                 &lt;/restriction&gt;
                         *                               &lt;/simpleType&gt;
                         *                             &lt;/element&gt;
                         *                           &lt;/sequence&gt;
                         *                         &lt;/restriction&gt;
                         *                       &lt;/complexContent&gt;
                         *                     &lt;/complexType&gt;
                         *                   &lt;/element&gt;
                         *                 &lt;/sequence&gt;
                         *                 &lt;attribute name="cod_reg_att" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;enumeration value="0"/&gt;
                         *                       &lt;enumeration value="1"/&gt;
                         *                       &lt;enumeration value="2"/&gt;
                         *                       &lt;enumeration value="3"/&gt;
                         *                       &lt;enumeration value="4"/&gt;
                         *                       &lt;enumeration value="5"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="tip_med" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;enumeration value="1"/&gt;
                         *                       &lt;enumeration value="2"/&gt;
                         *                       &lt;enumeration value="3"/&gt;
                         *                       &lt;enumeration value="4"/&gt;
                         *                       &lt;enumeration value="5"/&gt;
                         *                       &lt;enumeration value="6"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="cod_med"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="costo_acq" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="qta" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="fatt_conv" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                         *                       &lt;minInclusive value="1"/&gt;
                         *                       &lt;maxInclusive value="999999"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *       &lt;/sequence&gt;
                         *       &lt;attribute name="cod_un_op"&gt;
                         *         &lt;simpleType&gt;
                         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *             &lt;pattern value="[0-9]{4}"/&gt;
                         *           &lt;/restriction&gt;
                         *         &lt;/simpleType&gt;
                         *       &lt;/attribute&gt;
                         *     &lt;/restriction&gt;
                         *   &lt;/complexContent&gt;
                         * &lt;/complexType&gt;
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "medicinale"
                        })
                        public static class UNITOP {

                            @XmlElement(name = "MEDICINALE", required = true)
                            protected List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE> medicinale;
                            @XmlAttribute(name = "cod_un_op")
                            protected String codUnOp;

                            /**
                             * Gets the value of the medicinale property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the Jakarta XML Binding object.
                             * This is why there is not a <CODE>set</CODE> method for the medicinale property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getMEDICINALE().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE }
                             * 
                             * 
                             */
                            public List<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE> getMEDICINALE() {
                                if (medicinale == null) {
                                    medicinale = new ArrayList<Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE>();
                                }
                                return this.medicinale;
                            }

                            /**
                             * Recupera il valore della proprietà codUnOp.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getCodUnOp() {
                                return codUnOp;
                            }

                            /**
                             * Imposta il valore della proprietà codUnOp.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setCodUnOp(String value) {
                                this.codUnOp = value;
                            }


                            /**
                             * <p>Classe Java per anonymous complex type.
                             * 
                             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;sequence&gt;
                             *         &lt;element name="TARGATURE"&gt;
                             *           &lt;complexType&gt;
                             *             &lt;complexContent&gt;
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *                 &lt;sequence&gt;
                             *                   &lt;element name="COD" maxOccurs="unbounded"&gt;
                             *                     &lt;simpleType&gt;
                             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *                         &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                             *                       &lt;/restriction&gt;
                             *                     &lt;/simpleType&gt;
                             *                   &lt;/element&gt;
                             *                 &lt;/sequence&gt;
                             *               &lt;/restriction&gt;
                             *             &lt;/complexContent&gt;
                             *           &lt;/complexType&gt;
                             *         &lt;/element&gt;
                             *       &lt;/sequence&gt;
                             *       &lt;attribute name="cod_reg_att" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;enumeration value="0"/&gt;
                             *             &lt;enumeration value="1"/&gt;
                             *             &lt;enumeration value="2"/&gt;
                             *             &lt;enumeration value="3"/&gt;
                             *             &lt;enumeration value="4"/&gt;
                             *             &lt;enumeration value="5"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="tip_med" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;enumeration value="1"/&gt;
                             *             &lt;enumeration value="2"/&gt;
                             *             &lt;enumeration value="3"/&gt;
                             *             &lt;enumeration value="4"/&gt;
                             *             &lt;enumeration value="5"/&gt;
                             *             &lt;enumeration value="6"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="cod_med"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="[0-9a-zA-Z]{1,9}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="costo_acq" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="-{0,1}[0-9]{1,8}\.{1}[0-9]{2,5}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="qta" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;pattern value="-{0,1}[0-9]{1,12}\.{0,1}[0-9]{0,2}"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="fatt_conv" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                             *             &lt;minInclusive value="1"/&gt;
                             *             &lt;maxInclusive value="999999"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "targature"
                            })
                            public static class MEDICINALE {

                                @XmlElement(name = "TARGATURE", required = true)
                                protected Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE targature;
                                @XmlAttribute(name = "cod_reg_att", required = true)
                                protected String codRegAtt;
                                @XmlAttribute(name = "tip_med", required = true)
                                protected String tipMed;
                                @XmlAttribute(name = "cod_med")
                                protected String codMed;
                                @XmlAttribute(name = "costo_acq", required = true)
                                protected String costoAcq;
                                @XmlAttribute(name = "qta", required = true)
                                protected String qta;
                                @XmlAttribute(name = "fatt_conv", required = true)
                                protected int fattConv;

                                /**
                                 * Recupera il valore della proprietà targature.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE }
                                 *     
                                 */
                                public Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE getTARGATURE() {
                                    return targature;
                                }

                                /**
                                 * Imposta il valore della proprietà targature.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE }
                                 *     
                                 */
                                public void setTARGATURE(Dataroot.REGIONE.PERIODO.OPERAZIONE.AS.STRUTTURA.UNITOP.MEDICINALE.TARGATURE value) {
                                    this.targature = value;
                                }

                                /**
                                 * Recupera il valore della proprietà codRegAtt.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCodRegAtt() {
                                    return codRegAtt;
                                }

                                /**
                                 * Imposta il valore della proprietà codRegAtt.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCodRegAtt(String value) {
                                    this.codRegAtt = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipMed.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipMed() {
                                    return tipMed;
                                }

                                /**
                                 * Imposta il valore della proprietà tipMed.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipMed(String value) {
                                    this.tipMed = value;
                                }

                                /**
                                 * Recupera il valore della proprietà codMed.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCodMed() {
                                    return codMed;
                                }

                                /**
                                 * Imposta il valore della proprietà codMed.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCodMed(String value) {
                                    this.codMed = value;
                                }

                                /**
                                 * Recupera il valore della proprietà costoAcq.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCostoAcq() {
                                    return costoAcq;
                                }

                                /**
                                 * Imposta il valore della proprietà costoAcq.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCostoAcq(String value) {
                                    this.costoAcq = value;
                                }

                                /**
                                 * Recupera il valore della proprietà qta.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getQta() {
                                    return qta;
                                }

                                /**
                                 * Imposta il valore della proprietà qta.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setQta(String value) {
                                    this.qta = value;
                                }

                                /**
                                 * Recupera il valore della proprietà fattConv.
                                 * 
                                 */
                                public int getFattConv() {
                                    return fattConv;
                                }

                                /**
                                 * Imposta il valore della proprietà fattConv.
                                 * 
                                 */
                                public void setFattConv(int value) {
                                    this.fattConv = value;
                                }


                                /**
                                 * <p>Classe Java per anonymous complex type.
                                 * 
                                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                                 * 
                                 * <pre>
                                 * &lt;complexType&gt;
                                 *   &lt;complexContent&gt;
                                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                                 *       &lt;sequence&gt;
                                 *         &lt;element name="COD" maxOccurs="unbounded"&gt;
                                 *           &lt;simpleType&gt;
                                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                                 *               &lt;pattern value="[0]{1}|[0-9]{9}[0-9AX]{0,1}"/&gt;
                                 *             &lt;/restriction&gt;
                                 *           &lt;/simpleType&gt;
                                 *         &lt;/element&gt;
                                 *       &lt;/sequence&gt;
                                 *     &lt;/restriction&gt;
                                 *   &lt;/complexContent&gt;
                                 * &lt;/complexType&gt;
                                 * </pre>
                                 * 
                                 * 
                                 */
                                @XmlAccessorType(XmlAccessType.FIELD)
                                @XmlType(name = "", propOrder = {
                                    "cod"
                                })
                                public static class TARGATURE {

                                    @XmlElement(name = "COD", required = true)
                                    protected List<String> cod;

                                    /**
                                     * Gets the value of the cod property.
                                     * 
                                     * <p>
                                     * This accessor method returns a reference to the live list,
                                     * not a snapshot. Therefore any modification you make to the
                                     * returned list will be present inside the Jakarta XML Binding object.
                                     * This is why there is not a <CODE>set</CODE> method for the cod property.
                                     * 
                                     * <p>
                                     * For example, to add a new item, do as follows:
                                     * <pre>
                                     *    getCOD().add(newItem);
                                     * </pre>
                                     * 
                                     * 
                                     * <p>
                                     * Objects of the following type(s) are allowed in the list
                                     * {@link String }
                                     * 
                                     * 
                                     */
                                    public List<String> getCOD() {
                                        if (cod == null) {
                                            cod = new ArrayList<String>();
                                        }
                                        return this.cod;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }

}
