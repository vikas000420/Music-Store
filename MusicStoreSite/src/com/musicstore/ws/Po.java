/**
 * Po.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class Po  implements java.io.Serializable {
    private com.musicstore.ws.Address addressBean;

    private java.lang.String fname;

    private int id;

    private java.lang.String lname;

    private com.musicstore.ws.Poitem[] poitems;

    private java.lang.String status;

    public Po() {
    }

    public Po(
           com.musicstore.ws.Address addressBean,
           java.lang.String fname,
           int id,
           java.lang.String lname,
           com.musicstore.ws.Poitem[] poitems,
           java.lang.String status) {
           this.addressBean = addressBean;
           this.fname = fname;
           this.id = id;
           this.lname = lname;
           this.poitems = poitems;
           this.status = status;
    }


    /**
     * Gets the addressBean value for this Po.
     * 
     * @return addressBean
     */
    public com.musicstore.ws.Address getAddressBean() {
        return addressBean;
    }


    /**
     * Sets the addressBean value for this Po.
     * 
     * @param addressBean
     */
    public void setAddressBean(com.musicstore.ws.Address addressBean) {
        this.addressBean = addressBean;
    }


    /**
     * Gets the fname value for this Po.
     * 
     * @return fname
     */
    public java.lang.String getFname() {
        return fname;
    }


    /**
     * Sets the fname value for this Po.
     * 
     * @param fname
     */
    public void setFname(java.lang.String fname) {
        this.fname = fname;
    }


    /**
     * Gets the id value for this Po.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Po.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the lname value for this Po.
     * 
     * @return lname
     */
    public java.lang.String getLname() {
        return lname;
    }


    /**
     * Sets the lname value for this Po.
     * 
     * @param lname
     */
    public void setLname(java.lang.String lname) {
        this.lname = lname;
    }


    /**
     * Gets the poitems value for this Po.
     * 
     * @return poitems
     */
    public com.musicstore.ws.Poitem[] getPoitems() {
        return poitems;
    }


    /**
     * Sets the poitems value for this Po.
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
     * Gets the status value for this Po.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Po.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Po)) return false;
        Po other = (Po) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addressBean==null && other.getAddressBean()==null) || 
             (this.addressBean!=null &&
              this.addressBean.equals(other.getAddressBean()))) &&
            ((this.fname==null && other.getFname()==null) || 
             (this.fname!=null &&
              this.fname.equals(other.getFname()))) &&
            this.id == other.getId() &&
            ((this.lname==null && other.getLname()==null) || 
             (this.lname!=null &&
              this.lname.equals(other.getLname()))) &&
            ((this.poitems==null && other.getPoitems()==null) || 
             (this.poitems!=null &&
              java.util.Arrays.equals(this.poitems, other.getPoitems()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getAddressBean() != null) {
            _hashCode += getAddressBean().hashCode();
        }
        if (getFname() != null) {
            _hashCode += getFname().hashCode();
        }
        _hashCode += getId();
        if (getLname() != null) {
            _hashCode += getLname().hashCode();
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Po.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressBean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressBean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "address"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lname"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
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
