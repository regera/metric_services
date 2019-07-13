package com.tfaucheux.sample.model;
/**
*  \file      AudienceInsight.java
*  \brief     The model for a IMP_AUDIENCE_INSIGHTS_TMP
*  \details   IMP_AUDIENCE_INSIGHTS_TMP
*  \copyright Valassis, Inc. 2019
* 
*  \author    Todd Faucheux
*  \version   1.00
*  \date      30-MAY-2019
**/
 
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.persistence.*;
 
import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
 
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
 
import javax.xml.bind.annotation.XmlRootElement;
 
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@ref")
@Entity
@Table(name="IMP_AUDIENCE_INSIGHTS_TMP", schema="IMPOWER")
@XmlRootElement
public class AudienceInsight implements java.io.Serializable
{
   private static final long serialVersionUID = 4292358641L;
   public static final String primaryKeyIdentifier = "Id";
 
   // -----------------------------------------------------------------
   // Class Members ---------------------------------------------------
   // -----------------------------------------------------------------
   private Long                          id;
   private Long                          transactionId;
   private String                        key;
   private String                        value;
   // -----------------------------------------------------------------
   // Relationship Properties -----------------------------------------
   // -----------------------------------------------------------------
   // -----------------------------------------------------------------
   // CONSTRUCTORS
   // -----------------------------------------------------------------
 
   // Default Constructor
   public AudienceInsight() {
   }
 
   @Id
   @Column(name="ID", unique=true, nullable=false)
   public Long getId() {
     return this.id;
   }
   public void setId(Long id) {
     this.id = id;
   }

   @Column(name="TRANSACTION_ID", unique=false, nullable=false)
   public Long getTransactionId() {
     return this.transactionId;
   }
   public void setTransactionId(Long transactionId) {
     this.transactionId = transactionId;
   }

   @Column(name="KEY", unique=false, nullable=false)
   public String getKey() {
     return this.key;
   }
   public void setKey(String key) {
     this.key = key;
   }

   @Column(name="VALUE", unique=false, nullable=false)
   public String getValue() {
     return this.value;
   }
   public void setValue(String value) {
     this.value = value;
   }

   // -----------------------------------------------------------------
   // <------------< NON-ENTITY PROPERTY ACCESSOR METHODS >----------->
   // -----------------------------------------------------------------
   // -----------------------------------------------------------------
   // Relationship Accessor Methods -----------------------------------
   // -----------------------------------------------------------------
   // -----------------------------------------------------------------
 
   // TO_STRING methods
   public String toString(int indent)
   {
      String        padding  = (indent==0)?"":String.format("%"+indent+"s", "");
      StringBuilder result   = new StringBuilder();
      String        NEW_LINE = System.getProperty("line.separator");
 
      result.append(padding + this.getClass().getName() + " Object"        + NEW_LINE);
      result.append(padding + "{" + NEW_LINE);
   // -----------------------------------------------------------------
   // Object Properties
   // -----------------------------------------------------------------
      result.append(padding + " id                               : " + getId()             + NEW_LINE);
      result.append(padding + " transactionId                    : " + getTransactionId()  + NEW_LINE);
      result.append(padding + " key                              : " + getKey()            + NEW_LINE);
      result.append(padding + " value                            : " + getValue()          + NEW_LINE);
      result.append(padding + "}" + NEW_LINE);
 
      return result.toString();
   }
 
   @Override
   public String toString()
   {
       return toString(0);
   }
 
   @Override
   public int hashCode() {
     return new HashCodeBuilder()
         .append(getId())
         .toHashCode();
   }
 
   @Override
   public boolean equals(Object obj) {
     if (!(obj instanceof AudienceInsight)) return false;
      AudienceInsight other = (AudienceInsight) obj;
      return new EqualsBuilder()
          .append(getId(), other.getId())
          .append(getTransactionId(), other.getTransactionId())
          .append(getKey(), other.getKey())
          .append(getValue(), other.getValue())
          .isEquals();
   }
 
}
 
