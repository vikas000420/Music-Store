/**
 * Cd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class Cd  implements java.io.Serializable {
    private int availability;

    private java.lang.String category;

    private java.lang.String cdid;

    private com.musicstore.ws.Poitem[] poitems;

    private int price;

    private java.lang.String title;

    private com.musicstore.ws.Visitevent[] visitevents;

    public Cd() {
    }

    public Cd(
           int availability,
           java.lang.String category,
           java.lang.String cdid,
           com.musicstore.ws.Poitem[] poitems,
           int price,
           java.lang.String title,
           com.musicstore.ws.Visitevent[] visitevents) {
           this.availability = availability;
           this.category = category;
           this.cdid = cdid;
           this.poitems = poitems;
           this.price = price;
           this.title = title;
           this.visitevents = visitevents;
    }


    /**
     * Gets the availability value for this Cd.
     * 
     * @return availability
     */
    public int getAvailability() {
        return availability;
    }


    /**
     * Sets the availability value for this Cd.
     * 
     * @param availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }


    /**
     * Gets the category value for this Cd.
     * 
     * @return category
     */
    public java.lang.String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this Cd.
     * 
     * @param category
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
    }


    /**
     * Gets the cdid value for this Cd.
     * 
     * @return cdid
     */
    public java.lang.String getCdid() {
        return cdid;
    }


    /**
     * Sets the cdid value for this Cd.
     * 
     * @param cdid
     */
    public void setCdid(java.lang.String cdid) {
        this.cdid = cdid;
    }


    /**
     * Gets the poitems value for this Cd.
     * 
     * @return poitems
     */
    public com.musicstore.ws.Poitem[] getPoitems() {
        return poitems;
    }


    /**
     * Sets the poitems value for this Cd.
     * 
     * @param poitems
     */
    public void setPoitems(com.musicstore.ws.Poitem[] poitems) {
        this.poitems = poitems;
    }

    public com.musicstore.ws.Poitem getPoitems(int i) {
        return this.poitems[i];
    }

    public void setPoitems(int i, com.musicstore.ws.Poitem _value) {
        this.poitems[i] = _value;
    }


    /**
     * Gets the price value for this Cd.
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Cd.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }


    /**
     * Gets the title value for this Cd.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Cd.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the visitevents value for this Cd.
     * 
     * @return visitevents
     */
    public com.musicstore.ws.Visitevent[] getVisitevents() {
        return visitevents;
    }


    /**
     * Sets the visitevents value for this Cd.
     * 
     * @param visitevents
     */
    public void setVisitevents(com.musicstore.ws.Visitevent[] visitevents) {
        this.visitevents = visitevents;
    }

    public com.musicstore.ws.Visitevent getVisitevents(int i) {
        return this.visitevents[i];
    }

    public void setVisitevents(int i, com.musicstore.ws.Visitevent _value) {
        this.visitevents[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cd)) return false;
        Cd other = (Cd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.availability == other.getAvailability() &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.cdid==null && other.getCdid()==null) || 
             (this.cdid!=null &&
              this.cdid.equals(other.getCdid()))) &&
            ((this.poitems==null && other.getPoitems()==null) || 
             (this.poitems!=null &&
              java.util.Arrays.equals(this.poitems, other.getPoitems()))) &&
            this.price == other.getPrice() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.visitevents==null && other.getVisitevents()==null) || 
             (this.visitevents!=null &&
              java.util.Arrays.equals(this.visitevents, other.getVisitevents())));
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
        _hashCode += getAvailability();
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getCdid() != null) {
            _hashCode += getCdid().hashCode();
        }
        if (getPoitems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPoitems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPoitems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getPrice();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getVisitevents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVisitevents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVisitevents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "cd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availability");
        elemField.setXmlName(new javax.xml.namespace.QName("", "availability"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("poitems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "poitems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "poitem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visitevents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visitevents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "visitevent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
