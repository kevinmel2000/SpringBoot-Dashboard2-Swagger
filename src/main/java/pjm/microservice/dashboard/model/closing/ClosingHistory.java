package pjm.microservice.dashboard.model.closing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ClosingHistory {
    private String polis;
    private int id;
    private int createdBy;
    private String applicationNo;
    private String reffNumber;
    private String name;
    private String insuranceName;
    private String branchName;
    private String productName;
    private String productType;
    private String attribution;
    private String tenorMonth;
    private BigDecimal plafond;
    private BigDecimal coverageFeePartner;
    private BigDecimal coverageFeeInsurance;
    private BigDecimal coverageFeePenalty;
    private BigDecimal premi;
    private BigDecimal adminFee;
    private Date akadDate;
    private String akadNumber;
    private Date dateofBirth;
    private String ageWhenAkad;
    private String ageAfterAkad;

    public String getPolis() {
        return polis;
    }

    public void setPolis(String polis) {
        this.polis = polis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getReffNumber() {
        return reffNumber;
    }

    public void setReffNumber(String reffNumber) {
        this.reffNumber = reffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getTenorMonth() {
        return tenorMonth;
    }

    public void setTenorMonth(String tenorMonth) {
        this.tenorMonth = tenorMonth;
    }

    public BigDecimal getPlafond() {
        return plafond;
    }

    public void setPlafond(BigDecimal plafond) {
        this.plafond = plafond;
    }

    public BigDecimal getCoverageFeePartner() {
        return coverageFeePartner;
    }

    public void setCoverageFeePartner(BigDecimal coverageFeePartner) {
        this.coverageFeePartner = coverageFeePartner;
    }

    public BigDecimal getCoverageFeeInsurance() {
        return coverageFeeInsurance;
    }

    public void setCoverageFeeInsurance(BigDecimal coverageFeeInsurance) {
        this.coverageFeeInsurance = coverageFeeInsurance;
    }

    public BigDecimal getCoverageFeePenalty() {
        return coverageFeePenalty;
    }

    public void setCoverageFeePenalty(BigDecimal coverageFeePenalty) {
        this.coverageFeePenalty = coverageFeePenalty;
    }

    public BigDecimal getPremi() {
        return premi;
    }

    public void setPremi(BigDecimal premi) {
        this.premi = premi;
    }

    public BigDecimal getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(BigDecimal adminFee) {
        this.adminFee = adminFee;
    }

    public Date getAkadDate() {
        return akadDate;
    }

    public void setAkadDate(Date akadDate) {
        this.akadDate = akadDate;
    }

    public String getAkadNumber() {
        return akadNumber;
    }

    public void setAkadNumber(String akadNumber) {
        this.akadNumber = akadNumber;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getAgeWhenAkad() {
        return ageWhenAkad;
    }

    public void setAgeWhenAkad(String ageWhenAkad) {
        this.ageWhenAkad = ageWhenAkad;
    }

    public String getAgeAfterAkad() {
        return ageAfterAkad;
    }

    public void setAgeAfterAkad(String ageAfterAkad) {
        this.ageAfterAkad = ageAfterAkad;
    }
}
