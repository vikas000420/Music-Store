/**
 * Poitem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class Poitem  implements java.io.Serializable {
    private com.musicstore.ws.Cd cd;

    private com.musicstore.ws.PoitemPK id;

    private com.musicstore.ws.Po po;

    private int price;

    public Poitem() {
    }

    public Poitem(
           com.musicstore.ws.Cd cd,
           com.musicstore.ws.PoitemPK id,
           com.musicstore.ws.Po po,
           int price) {
           this.cd = cd;
           this.id = id;
           this.po = po;
           this.price = price;
    }


    /**
     * Gets the cd value for this Poitem.
     * 
     * @return cd
     */
    public com.musicstore.ws.Cd getCd() {
        return cd;
    }


    /**
     * Sets the cd value for this Poitem.
     * 
     * @param cd
     */
    public void setCd(com.musicstore.ws.Cd cd) {
        this.cd = cd;
    }


    /**
     * Gets the id value for this Poitem.
     * 
     * @return id
     */
    public com.musicstore.ws.PoitemPK getId() {
        return id;
    }


    /**
     * Sets the id value for this Poitem.
     * 
     * @param id
     */
    public void setId(com.musicstore.ws.PoitemPK id) {
        this.id = id;
    }


    /**
     * Gets the po value for this Poitem.
     * 
     * @return po
     */
    public com.musicstore.ws.Po getPo() {
        return po;
    }


    /**
     * Sets the po value for this Poitem.
     * 
     * @param po
     */
    public void setPo(com.musicstore.ws.Po po) {
        this.po = po;
    }


    /**
     * Gets the price value for this Poitem.
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Poitem.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Poitem)) return false;
        Poitem other = (Poitem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cd==null && other.getCd()==null) || 
             (this.cd!=null &&
              this.cd.equals(other.getCd()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.po==null && other.getPo()==null) || 
             (this.po!=null &&
              this.po.equals(other.getPo()))) &&
            this.price == other.getPrice();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCd() != null) {
            _hashCode += getCd().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getPo() != null) {
            _hashCode += getPo().hashCode();
        }
        _hashCode += getPrice();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Poitem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "poitem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "cd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "poitemPK"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("po");
        elemField.setXmlName(new javax.xml.namespace.QName("", "po"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
