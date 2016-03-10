//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.06 at 12:51:20 PM IST 
//


package org.agromart.container.api.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="basePrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bidPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sellByDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isSold" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="imgLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxExpectedPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="auctionStartDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="auctionEndDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {
    "itemId",
    "type",
    "name",
    "description",
    "units",
    "quantity",
    "basePrice",
    "bidPrice",
    "sellByDate",
    "isSold",
    "imgLink",
    "maxExpectedPrice",
    "auctionStartDateTime",
    "auctionEndDateTime",
    "createdDate",
    "modifiedDate"
})
public class ItemType {

    protected int itemId;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String units;
    protected int quantity;
    @XmlElement(required = true)
    protected String basePrice;
    @XmlElement(required = true)
    protected String bidPrice;
    @XmlElement(required = true)
    protected String sellByDate;
    protected boolean isSold;
    @XmlElement(required = true)
    protected String imgLink;
    @XmlElement(required = true)
    protected String maxExpectedPrice;
    @XmlElement(required = true)
    protected String auctionStartDateTime;
    @XmlElement(required = true)
    protected String auctionEndDateTime;
    @XmlElement(required = true)
    protected String createdDate;
    @XmlElement(required = true)
    protected String modifiedDate;

    public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
     * Gets the value of the itemId property.
     * 
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(int value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
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
     * Sets the value of the description property.
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
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the basePrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the value of the basePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasePrice(String value) {
        this.basePrice = value;
    }

    /**
     * Gets the value of the bidPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBidPrice() {
        return bidPrice;
    }

    /**
     * Sets the value of the bidPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBidPrice(String value) {
        this.bidPrice = value;
    }

    /**
     * Gets the value of the sellByDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellByDate() {
        return sellByDate;
    }

    /**
     * Sets the value of the sellByDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellByDate(String value) {
        this.sellByDate = value;
    }

    /**
     * Gets the value of the isSold property.
     * 
     */
    public boolean isIsSold() {
        return isSold;
    }

    /**
     * Sets the value of the isSold property.
     * 
     */
    public void setIsSold(boolean value) {
        this.isSold = value;
    }

    /**
     * Gets the value of the imgLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * Sets the value of the imgLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgLink(String value) {
        this.imgLink = value;
    }

    /**
     * Gets the value of the maxExpectedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxExpectedPrice() {
        return maxExpectedPrice;
    }

    /**
     * Sets the value of the maxExpectedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxExpectedPrice(String value) {
        this.maxExpectedPrice = value;
    }

    /**
     * Gets the value of the auctionStartDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionStartDateTime() {
        return auctionStartDateTime;
    }

    /**
     * Sets the value of the auctionStartDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionStartDateTime(String value) {
        this.auctionStartDateTime = value;
    }

    /**
     * Gets the value of the auctionEndDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionEndDateTime() {
        return auctionEndDateTime;
    }

    /**
     * Sets the value of the auctionEndDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionEndDateTime(String value) {
        this.auctionEndDateTime = value;
    }

}
