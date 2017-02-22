/**
 * CreditCardDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class CreditCardDetails  implements java.io.Serializable {
    private java.lang.String ccNumber;

    private java.lang.String ccvCode;

    private java.lang.String expMonth;

    private java.lang.String expYear;

    private java.lang.String nameOnCC;

    public CreditCardDetails() {
    }

    public CreditCardDetails(
           java.lang.String ccNumber,
           java.lang.String ccvCode,
           java.lang.String expMonth,
           java.lang.String expYear,
           java.lang.String nameOnCC) {
           this.ccNumber = ccNumber;
           this.ccvCode = ccvCode;
           this.expMonth = expMonth;
           this.expYear = expYear;
           this.nameOnCC = nameOnCC;
    }


    /**
     * Gets the ccNumber value for this CreditCardDetails.
     * 
     * @return ccNumber
     */
    public java.lang.String getCcNumber() {
        return ccNumber;
    }


    /**
     * Sets the ccNumber value for this CreditCardDetails.
     * 
     * @param ccNumber
     */
    public void setCcNumber(java.lang.String ccNumber) {
        this.ccNumber = ccNumber;
    }


    /**
     * Gets the ccvCode value for this CreditCardDetails.
     * 
     * @return ccvCode
     */
    public java.lang.String getCcvCode() {
        return ccvCode;
    }


    /**
     * Sets the ccvCode value for this CreditCardDetails.
     * 
     * @param ccvCode
     */
    public void setCcvCode(java.lang.String ccvCode) {
        this.ccvCode = ccvCode;
    }


    /**
     * Gets the expMonth value for this CreditCardDetails.
     * 
     * @return expMonth
     */
    public java.lang.String getExpMonth() {
        return expMonth;
    }


    /**
     * Sets the expMonth value for this CreditCardDetails.
     * 
     * @param expMonth
     */
    public void setExpMonth(java.lang.String expMonth) {
        this.expMonth = expMonth;
    }


    /**
     * Gets the expYear value for this CreditCardDetails.
     * 
     * @return expYear
     */
    public java.lang.String getExpYear() {
        return expYear;
    }


    /**
     * Sets the expYear value for this CreditCardDetails.
     * 
     * @param expYear
     */
    public void setExpYear(java.lang.String expYear) {
        this.expYear = expYear;
    }


    /**
     * Gets the nameOnCC value for this CreditCardDetails.
     * 
     * @return nameOnCC
     */
    public java.lang.String getNameOnCC() {
        return nameOnCC;
    }


    /**
     * Sets the nameOnCC value for this CreditCardDetails.
     * 
     * @param nameOnCC
     */
    public void setNameOnCC(java.lang.String nameOnCC) {
        this.nameOnCC = nameOnCC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreditCardDetails)) return false;
        CreditCardDetails other = (CreditCardDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ccNumber==null && other.getCcNumber()==null) || 
             (this.ccNumber!=null &&
              this.ccNumber.equals(other.getCcNumber()))) &&
            ((this.ccvCode==null && other.getCcvCode()==null) || 
             (this.ccvCode!=null &&
              this.ccvCode.equals(other.getCcvCode()))) &&
            ((this.expMonth==null && other.getExpMonth()==null) || 
             (this.expMonth!=null &&
              this.expMonth.equals(other.getExpMonth()))) &&
            ((this.expYear==null && other.getExpYear()==null) || 
             (this.expYear!=null &&
              this.expYear.equals(other.getExpYear()))) &&
            ((this.nameOnCC==null && other.getNameOnCC()==null) || 
             (this.nameOnCC!=null &&
              this.nameOnCC.equals(other.getNameOnCC())));
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
        if (getCcNumber() != null) {
            _hashCode += getCcNumber().hashCode();
        }
        if (getCcvCode() != null) {
            _hashCode += getCcvCode().hashCode();
        }
        if (getExpMonth() != null) {
            _hashCode += getExpMonth().hashCode();
        }
        if (getExpYear() != null) {
            _hashCode += getExpYear().hashCode();
        }
        if (getNameOnCC() != null) {
            _hashCode += getNameOnCC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditCardDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "creditCardDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ccNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccvCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ccvCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expYear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expYear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameOnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nameOnCC"));
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
