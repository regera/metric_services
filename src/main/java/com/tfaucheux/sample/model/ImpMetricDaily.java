package com.tfaucheux.sample.model;
/**
*  \file      ImpMetricDaily.java
*  \brief     The model for a IMP_METRIC_DAILY_V
*  \details   IMP_METRIC_DAILY_V
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
@Table(name="IMP_METRIC_DAILY_V", schema="IMPOWER")
@XmlRootElement
public class ImpMetricDaily implements java.io.Serializable
{
   private static final long serialVersionUID = 4292358641L;
   public static final String primaryKeyIdentifier = "Id";
 
   // -----------------------------------------------------------------
   // Class Members ---------------------------------------------------
   // -----------------------------------------------------------------
   private Long                          id;
   private String                        namespace;
   private String                        section;
   private String                        target;
   private String                        action;
   private BigDecimal                    metricId;
   private String                        metricType;
   private String                        loginName;
   // date fields
   private Date                          createDate;
   private BigDecimal                    createYear;
   private BigDecimal                    createQtr;
   private BigDecimal                    createMonth;
   private BigDecimal                    createWeek;
   private BigDecimal                    createDoy;
   private BigDecimal                    createDow;
   //
   private BigDecimal                    origSystemRefId;
   private String                        origSystemRefCd;
   private BigDecimal                    fkProjectTrackerId;
   private String                        metricValue;
   private String                        metricText;
   private String                        text0;
   private String                        text1;
   private String                        text2;
   private String                        text3;
   private String                        text4;
   private String                        text5;
   private String                        text6;
   private String                        text7;
   private String                        text8;
   private String                        text9;
   private String                        text10;
   private Long                          projectId;
   private String                        projectType;
   private String                        fkClientSourceCd;
   private String                        fkProductTypeCd;
   private String                        fkIndustryCategoryCd;
   private String                        accountNumber;
   private String                        clientName;
   private String                        projectStatus;
   private String                        industryCd;
   private String                        industryCode;
   private String                        industryCategoryDescr;
   private String                        targetingTier;
   private String                        targetingCenter;
   private String                        targetingTeam;
   private String                        regionDivision;
   private String                        salesPerson;
   private String                        requestor;
   private String                        targetor;
   private String                        totalMediaBudget;
   private String                        numSitesMarkets;
   private Date                          fromPromotionalDate;
   private Date                          toPromotionalDate;
   private Date                          preferredIhDate;
   private String                        preferredIhQtr;
   private String                        preferredIhMon;
   private String                        preferredIhDay;
   private Date                          targetingDueDate;
   private Date                          clientDueDate;
   private Date                          assignmentDueDate;
   private Double                        annualRevenuePotential;

   // Default Constructor
   public ImpMetricDaily() {
   }
 
   @Id
   @Column(name="Id", unique=true, nullable=false)
   public Long getId() {
     return this.id;
   }
   public void setId(Long id) {
     this.id = id;
   }
   @Column(name="Namespace", unique=false, nullable=false)
   public String getNamespace() {
     return this.namespace;
   }
   public void setNamespace(String namespace) {
     this.namespace = namespace;
   }
   @Column(name="Section", unique=false, nullable=false)
   public String getSection() {
     return this.section;
   }
   public void setSection(String section) {
     this.section = section;
   }
   @Column(name="Target", unique=false, nullable=false)
   public String getTarget() {
     return this.target;
   }
   public void setTarget(String target) {
     this.target = target;
   }
   @Column(name="Action", unique=false, nullable=false)
   public String getAction() {
     return this.action;
   }
   public void setAction(String action) {
     this.action = action;
   }
   @Column(name="Metric_Id", unique=false, nullable=false)
   public BigDecimal getMetricId() {
     return this.metricId;
   }
   public void setMetricId(BigDecimal id) {
     this.metricId = metricId;
   }
   @Column(name="Metric_Type", unique=false, nullable=false)
   public String getMetricType() {
     return this.metricType;
   }
   public void setMetricType(String metricType) {
     this.metricType = metricType;
   }
   @Column(name="Login_Name", unique=false, nullable=false)
   public String getLoginName() {
     return this.loginName;
   }
   public void setLoginName(String loginName) {
     this.loginName = loginName;
   }
   @Column(name="Create_Date", unique=false, nullable=false)
   public Date getCreateDate() {
     return this.createDate;
   }
   public void setCreateDate(Date createDate) {
     this.createDate = createDate;
   }
   @Column(name="Create_Year", unique=false, nullable=false)
   public BigDecimal getCreateYear() {
     return this.createYear;
   }
   public void setCreateYear(BigDecimal createYear) {
     this.createYear = createYear;
   }
   @Column(name="Create_Qtr", unique=false, nullable=false)
   public BigDecimal getCreateQtr() {
     return this.createQtr;
   }
   public void setCreateQtr(BigDecimal createQtr) {
     this.createQtr = createQtr;
   }
   @Column(name="Create_Month", unique=false, nullable=false)
   public BigDecimal getCreateMonth() {
     return this.createMonth;
   }
   public void setCreateMonth(BigDecimal createMonth) {
     this.createMonth = createMonth;
   }
   @Column(name="Create_Week", unique=false, nullable=false)
   public BigDecimal getCreateWeek() {
     return this.createWeek;
   }
   public void setCreateWeek(BigDecimal createWeek) {
     this.createWeek = createWeek;
   }
   @Column(name="Create_Doy", unique=false, nullable=false)
   public BigDecimal getCreateDoy() {
     return this.createDoy;
   }
   public void setCreateDoy(BigDecimal createDoy) {
     this.createDoy = createDoy;
   }
   @Column(name="Create_Dow", unique=false, nullable=false)
   public BigDecimal getCreateDow() {
     return this.createDow;
   }
   public void setCreateDow(BigDecimal createDow) {
     this.createDow = createDow;
   }
   @Column(name="Orig_System_Ref_Id", unique=false, nullable=true)
   public BigDecimal getOrigSystemRefId() {
     return this.origSystemRefId;
   }
   public void setOrigSystemRefId(BigDecimal origSystemRefId) {
     this.origSystemRefId = origSystemRefId;
   }
   @Column(name="Orig_System_Ref_Cd", unique=false, nullable=true)
   public String getOrigSystemRefCd() {
     return this.origSystemRefCd;
   }
   public void setOrigSystemRefCd(String origSystemRefCd) {
     this.origSystemRefCd = origSystemRefCd;
   }
   @Column(name="Fk_Project_Tracker_Id", unique=false, nullable=true)
   public BigDecimal getFkProjectTrackerId() {
     return this.fkProjectTrackerId;
   }
   public void setFkProjectTrackerId(BigDecimal fkProjectTrackerId) {
     this.fkProjectTrackerId = fkProjectTrackerId;
   }
   @Column(name="Metric_Value", unique=false, nullable=true)
   public String getMetricValue() {
     return this.metricValue;
   }
   public void setMetricValue(String metricValue) {
     this.metricValue = metricValue;
   }
   @Column(name="Metric_Text", unique=false, nullable=true)
   public String getMetricText() {
     return this.metricText;
   }
   public void setMetricText(String metricText) {
     this.metricText = metricText;
   }
   @Column(name="Text_0", unique=false, nullable=true)
   public String getText0() {
     return this.text0;
   }
   public void setText0(String text0) {
     this.text0 = text0;
   }
   @Column(name="Text_1", unique=false, nullable=true)
   public String getText1() {
     return this.text1;
   }
   public void setText1(String text1) {
     this.text1 = text1;
   }
   @Column(name="Text_2", unique=false, nullable=true)
   public String getText2() {
     return this.text2;
   }
   public void setText2(String text2) {
     this.text2 = text2;
   }
   @Column(name="Text_3", unique=false, nullable=true)
   public String getText3() {
     return this.text3;
   }
   public void setText3(String text3) {
     this.text3 = text3;
   }
   @Column(name="Text_4", unique=false, nullable=true)
   public String getText4() {
     return this.text4;
   }
   public void setText4(String text4) {
     this.text4 = text4;
   }
   @Column(name="Text_5", unique=false, nullable=true)
   public String getText5() {
     return this.text5;
   }
   public void setText5(String text5) {
     this.text5 = text5;
   }
   @Column(name="Text_6", unique=false, nullable=true)
   public String getText6() {
     return this.text6;
   }
   public void setText6(String text6) {
     this.text6 = text6;
   }
   @Column(name="Text_7", unique=false, nullable=true)
   public String getText7() {
     return this.text7;
   }
   public void setText7(String text7) {
     this.text7 = text7;
   }
   @Column(name="Text_8", unique=false, nullable=true)
   public String getText8() {
     return this.text8;
   }
   public void setText8(String text8) {
     this.text8 = text8;
   }
   @Column(name="Text_9", unique=false, nullable=true)
   public String getText9() {
     return this.text9;
   }
   public void setText9(String text9) {
     this.text9 = text9;
   }
   @Column(name="Text_10", unique=false, nullable=true)
   public String getText10() {
     return this.text10;
   }
   public void setText10(String text10) {
     this.text10 = text10;
   }
   @Column(name="project_id", unique=false, nullable=true)
   public Long getProjectId() {
     return this.projectId;
   }
   public void setprojectId(Long projectId) {
     this.projectId = projectId;
   }
   @Column(name="Project_type", unique=false, nullable=true)
   public String getProjectType() {
     return this.projectType;
   }
   public void setProjectType(String projectType) {
     this.projectType = projectType;
   }
   @Column(name="fk_client_source_cd", unique=false, nullable=true)
   public String getFkClientSourceCd() {
     return this.fkClientSourceCd;
   }
   public void setFkClientSourceCd(String fkClientSourceCd) {
     this.fkClientSourceCd = fkClientSourceCd;
   }
   @Column(name="fk_product_type_cd", unique=false, nullable=true)
   public String getFkProductTypeCd() {
     return this.fkProductTypeCd;
   }
   public void setFkProductTypeCd(String fkProductTypeCd) {
     this.fkProductTypeCd = fkProductTypeCd;
   }
   @Column(name="fk_industry_category_cd", unique=false, nullable=true)
   public String getFkIndustryCategoryCd() {
     return this.fkIndustryCategoryCd;
   }
   public void setFkIndustryCategoryCd(String fkIndustryCategoryCd) {
     this.fkIndustryCategoryCd = fkIndustryCategoryCd;
   }
   @Column(name="account_number", unique=false, nullable=true)
   public String getAccountNumber() {
     return this.accountNumber;
   }
   public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
   }
   @Column(name="client_name", unique=false, nullable=true)
   public String getClientName() {
     return this.clientName;
   }
   public void setClientName(String clientName) {
     this.clientName = clientName;
   }
   @Column(name="project_status", unique=false, nullable=true)
   public String getProjectStatus() {
     return this.projectStatus;
   }
   public void setProjectStatus(String projectStatus) {
     this.projectStatus = projectStatus;
   }
   @Column(name="industry_cd", unique=false, nullable=true)
   public String getIndustryCd() {
     return this.industryCd;
   }
   public void setIndustryCd(String industryCd) {
     this.industryCd = industryCd;
   }
   @Column(name="industry_code", unique=false, nullable=true)
   public String getIndustryCode() {
     return this.industryCode;
   }
   public void setIndustryCode(String industryCode) {
     this.industryCode = industryCode;
   }
   @Column(name="industry_category_descr", unique=false, nullable=true)
   public String getIndustryCategoryDescr() {
     return this.industryCategoryDescr;
   }
   public void setIndustryCategoryDescr(String industryCategoryDescr) {
     this.industryCategoryDescr = industryCategoryDescr;
   }
   @Column(name="targeting_tier", unique=false, nullable=true)
   public String getTargetingTier() {
     return this.targetingTier;
   }
   public void setTargetingTier(String targetingTier) {
     this.targetingTier = targetingTier;
   }
   @Column(name="targeting_center", unique=false, nullable=true)
   public String getTargetingCenter() {
     return this.targetingCenter;
   }
   public void setTargetingCenter(String targetingCenter) {
     this.targetingCenter = targetingCenter;
   }
   @Column(name="targeting_team", unique=false, nullable=true)
   public String getTargetingTeam() {
     return this.targetingTeam;
   }
   public void setTargetingTeam(String targetingTeam) {
     this.targetingTeam = targetingTeam;
   }
   @Column(name="region_division", unique=false, nullable=true)
   public String getRegionDivision() {
     return this.regionDivision;
   }
   public void setRegionDivision(String regionDivision) {
     this.regionDivision = regionDivision;
   }
   @Column(name="sales_person", unique=false, nullable=true)
   public String getSalesPerson() {
     return this.salesPerson;
   }
   public void setSalesPerson(String salesPerson) {
     this.salesPerson = salesPerson;
   }
   @Column(name="requestor", unique=false, nullable=true)
   public String getRequestor() {
     return this.requestor;
   }
   public void setRequestor(String requestor) {
     this.requestor = requestor;
   }
   @Column(name="targetor", unique=false, nullable=true)
   public String getTargetor() {
     return this.targetor;
   }
   public void setTargetor(String targetor) {
     this.targetor = targetor;
   }
   @Column(name="total_media_budget", unique=false, nullable=true)
   public String getTotalMediaBudget() {
     return this.totalMediaBudget;
   }
   public void setTotalMediaBudget(String totalMediaBudget) {
     this.totalMediaBudget = totalMediaBudget;
   }
   @Column(name="num_sites_markets", unique=false, nullable=true)
   public String getNumSitesMarkets() {
     return this.numSitesMarkets;
   }
   public void setNumSitesMarkets(String numSitesMarkets) {
     this.numSitesMarkets = numSitesMarkets;
   }
   @Column(name="from_promotional_date", unique=false, nullable=true)
   public Date getFromPromotionalDate() {
     return this.fromPromotionalDate;
   }
   public void setFromPromotionalDate(Date fromPromotionalDate) {
     this.fromPromotionalDate = fromPromotionalDate;
   }
   @Column(name="to_promotional_date", unique=false, nullable=true)
   public Date getToPromotionalDate() {
     return this.toPromotionalDate;
   }
   public void setToPromotionalDate(Date toPromotionalDate) {
     this.toPromotionalDate = toPromotionalDate;
   }
   @Column(name="preferred_ih_date", unique=false, nullable=true)
   public Date getPreferredIhDate() {
     return this.preferredIhDate;
   }
   public void setPreferredIhDate(Date preferredIhDate) {
     this.preferredIhDate = preferredIhDate;
   }
   @Column(name="preferred_ih_qtr", unique=false, nullable=true)
   public String getPreferredIhQtr() {
     return this.preferredIhQtr;
   }
   public void setPreferredIhQtr(String preferredIhQtr) {
     this.preferredIhQtr = preferredIhQtr;
   }
   @Column(name="preferred_ih_mon", unique=false, nullable=true)
   public String getPreferredIhMon() {
     return this.preferredIhMon;
   }
   public void setPreferredIhMon(String preferredIhMon) {
     this.preferredIhMon = preferredIhMon;
   }
   @Column(name="preferred_ih_day", unique=false, nullable=true)
   public String getPreferredIhDay() {
     return this.preferredIhDay;
   }
   public void setPreferredIhDay(String preferredIhDay) {
     this.preferredIhDay = preferredIhDay;
   }
   @Column(name="targeting_due_date", unique=false, nullable=true)
   public Date getTargetingDueDate() {
     return this.targetingDueDate;
   }
   public void setTargetingDueDate(Date targetingDueDate) {
     this.targetingDueDate = targetingDueDate;
   }
   @Column(name="client_due_date", unique=false, nullable=true)
   public Date getClientDueDate() {
     return this.clientDueDate;
   }
   public void setClientDueDate(Date clientDueDate) {
     this.clientDueDate = clientDueDate;
   }
   @Column(name="assignment_due_date", unique=false, nullable=true)
   public Date getAssignmentDueDate() {
     return this.assignmentDueDate;
   }
   public void setAssignmentDueDate(Date assignmentDueDate) {
     this.assignmentDueDate = assignmentDueDate;
   }
   @Column(name="annual_revenue_potential", unique=false, nullable=true)
   public Double getAnnualRevenuePotential() {
     return this.annualRevenuePotential;
   }
   public void setAnnualRevenuePotential(Double annualRevenuePotential) {
     this.annualRevenuePotential = annualRevenuePotential;
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
      result.append(padding + " id                               : " + getId()                      + NEW_LINE);
      result.append(padding + " namespace                        : " + getNamespace()               + NEW_LINE);
      result.append(padding + " section                          : " + getSection()                 + NEW_LINE);
      result.append(padding + " target                           : " + getTarget()                  + NEW_LINE);
      result.append(padding + " action                           : " + getAction()                  + NEW_LINE);
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
     if (!(obj instanceof ImpMetricDaily)) return false;
      ImpMetricDaily other = (ImpMetricDaily) obj;
      return new EqualsBuilder()
          .append(getId(), other.getId())
          .isEquals();
   }
 
}
 
