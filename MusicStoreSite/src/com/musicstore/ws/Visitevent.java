/**
 * Visitevent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class Visitevent  implements java.io.Serializable {
    private com.musicstore.ws.Cd cd;

    private java.lang.String day;

    private java.lang.String eventtype;

    public Visitevent() {
    }

    public Visitevent(
           com.musicstore.ws.Cd cd,
           java.lang.String day,
           java.lang.String eventtype) {
           this.cd = cd;
           this.day = day;
           this.eventtype = eventtype;
    }


    /**
     * Gets the cd value for this Visitevent.
     * 
     * @return cd
     */
    public com.musicstore.ws.Cd getCd() {
        return cd;
    }


    /**
     * Sets the cd value for this Visitevent.
     * 
     * @param cd
     */
    public void setCd(com.musicstore.ws.Cd cd) {
        this.cd = cd;
    }


    /**
     * Gets the day value for this Visitevent.
     * 
     * @return day
     */
    public java.lang.String getDay() {
        return day;
    }


    /**
     * Sets the day value for this Visitevent.
     * 
     * @param day
     */
    public void setDay(java.lang.String day) {
        this.day = day;
    }


    /**
     * Gets the eventtype value for this Visitevent.
     * 
     * @return eventtype
     */
    public java.lang.String getEventtype() {
        return eventtype;
    }


    /**
     * Sets the eventtype value for this Visitevent.
     * 
     * @param eventtype
     */
    public void setEventtype(java.lang.String eventtype) {
        this.eventtype = eventtype;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Visitevent)) return false;
        Visitevent other = (Visitevent) obj;
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
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.eventtype==null && other.getEventtype()==null) || 
             (this.eventtype!=null &&
              this.eventtype.equals(other.getEventtype())));
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
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getEventtype() != null) {
            _hashCode += getEventtype().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Visitevent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "visitevent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "cd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
