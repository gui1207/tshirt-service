
package com.acme.tshirt_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de InventoryItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="InventoryItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="size" type="{http://acme.com/tshirt-service}Size"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryItem", propOrder = {
    "productCode",
    "size",
    "description",
    "count"
})
public class InventoryItem {

    protected int productCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Size size;
    @XmlElement(required = true)
    protected String description;
    protected int count;

    /**
     * Obtém o valor da propriedade productCode.
     * 
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Define o valor da propriedade productCode.
     * 
     */
    public void setProductCode(int value) {
        this.productCode = value;
    }

    /**
     * Obtém o valor da propriedade size.
     * 
     * @return
     *     possible object is
     *     {@link Size }
     *     
     */
    public Size getSize() {
        return size;
    }

    /**
     * Define o valor da propriedade size.
     * 
     * @param value
     *     allowed object is
     *     {@link Size }
     *     
     */
    public void setSize(Size value) {
        this.size = value;
    }

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade count.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Define o valor da propriedade count.
     * 
     */
    public void setCount(int value) {
        this.count = value;
    }

}
