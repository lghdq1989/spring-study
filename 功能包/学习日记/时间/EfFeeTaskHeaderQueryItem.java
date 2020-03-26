package com.sinoservices.bms.payment.query;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.sinoservices.framework.core.query.BaseQueryItem;
/**
 * <p>Description:结果类 </p>
 * @author  hugo
 * @version 1.00
 * <pre>
 * 修改记录:
 * 修改后版本            修改人         修改日期        修改内容
 * 20191114.1       hugo        20191114        create
 * 
 * </pre>
 */
@Entity
public class EfFeeTaskHeaderQueryItem extends BaseQueryItem {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 物理主键
     */ 
    private Long jobId;
    /**
     * 任务编号
     */ 
    private String feeTaskCode;
    /**
     * 分公司
     */ 
    private String companyCode;
    
    /**
     * 分公司名称
     */
    private String companyName;
    
    /**
     * 服务平台
     */ 
    private String siteCode;
    
    /**
     * 服务平台名称
     */
    private String siteName;
    
    
    /**
     * 运作供应商
     */ 
    private String feeSupplierCode;
    
    
    /**
     * 供应商名称
     */
    private String feeSupplierName;
    
    /**
     * 结算供应商
     */ 
    private String clearingSupplierCode;
    
    private String clearingSupplierName;
    
    /**
     * 会计主体ID
     */ 
    private Long ledgerId;
    
    private String ledgerName;
    
    /**
     * 任务类型
     */ 
    private String feeTaskType;
    /**
     * 业务类型
     */ 
    private String businessType;
    /**
     * 业务日期
     */ 
    private Date taskDate;
    /**
     * 状态
     */ 
    private String status;
    /**
     * 供应商确认状态
     */ 
    private String supStatus;
    /**
     * 币种
     */ 
    private String currencyCode;
    /**
     * 含税总金额
     */ 
    private Double amount;
    /**
     * 税额
     */ 
    private Double taxAmount;
    /**
     * 不含税总金额
     */ 
    private Double noTaxAmount;
    /**
     * 供应商确认金额
     */ 
    private Double supplierComfirmAmount;
    /**
     * 异常信息
     */ 
    private String errorMsg;
    /**
     * 创建人
     */ 
    private String creator;
    
    private String createName;
    
    
    /**
     * 创建时间
     */ 
    private Date createTime;
    /**
     * 最后修改人
     */ 
    private String modifier;
    
    private String modifierName;
    
    /**
     * 最后修改时间
     */ 
    private Date modifyTime;
    /**
     * 版本号
     */ 
    private Long recVer;
    /**
     * 提交供应商确认时间
     */
    private Date toSupTime;
    /**
     * 供应商提交确认时间
     */
    private Date supComfirmTime;
    /**
     * 任务确认时间
     */
    private Date taskComfirmTime;
    /**
     * 付款条件 SYS_SU_PAY_CONDITION
     */
    private Long paymentTerms;
    /**
     * 是否代结标识 SYS_BMS_YES_NO
     */
    private Long isReplaceSettlement;
    /**
     * 是否虚拟付款
     */
    private Long isVirtual;
    
    private String apBillNo;
 
    
    private String substr1;

    private String substr2;

    private String substr3;

    private String substr4;

    private Date subdate1;

    private Date subdate2;

    private Double subnum1;

    private Double subnum2;
 
    
    private String remark;	//备注
    
    
    
    
    
    
    @Column(name = "CREATOR_NAME")
    public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
		 addValidField("createName");
	}
	@Column(name = "MODIFIER_NAME")
	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
		 addValidField("modifierName");
	}

	/**
     * Set 物理主键
     */
    public void setJobId(Long jobId){
        this.jobId = jobId;
        addValidField("jobId");
    }
    
    /**
     * Get 物理主键
     */
    @Column(name = "JOB_ID")
    public Long getJobId(){
        return jobId;
    }
    
    /**
     * Set 任务编号
     */
    public void setFeeTaskCode(String feeTaskCode){
        this.feeTaskCode = feeTaskCode;
        addValidField("feeTaskCode");
    }
    
    /**
     * Get 任务编号
     */
    @Column(name = "FEE_TASK_CODE")
    public String getFeeTaskCode(){
        return feeTaskCode;
    }
    
    /**
     * Set 分公司
     */
    public void setCompanyCode(String companyCode){
        this.companyCode = companyCode;
        addValidField("companyCode");
    }
    
    /**
     * Get 分公司
     */
    @Column(name = "COMPANY_CODE")
    public String getCompanyCode(){
        return companyCode;
    }
    
    /**
     * Set 服务平台
     */
    public void setSiteCode(String siteCode){
        this.siteCode = siteCode;
        addValidField("siteCode");
    }
    
    /**
     * Get 服务平台
     */
    @Column(name = "SITE_CODE")
    public String getSiteCode(){
        return siteCode;
    }
    
    /**
     * Set 运作供应商
     */
    public void setFeeSupplierCode(String feeSupplierCode){
        this.feeSupplierCode = feeSupplierCode;
        addValidField("feeSupplierCode");
    }
    
    /**
     * Get 运作供应商
     */
    @Column(name = "FEE_SUPPLIER_CODE")
    public String getFeeSupplierCode(){
        return feeSupplierCode;
    }
    
    /**
     * Set 结算供应商
     */
    public void setClearingSupplierCode(String clearingSupplierCode){
        this.clearingSupplierCode = clearingSupplierCode;
        addValidField("clearingSupplierCode");
    }
    
    /**
     * Get 结算供应商
     */
    @Column(name = "CLEARING_SUPPLIER_CODE")
    public String getClearingSupplierCode(){
        return clearingSupplierCode;
    }
    
    /**
     * Set 会计主体ID
     */
    public void setLedgerId(Long ledgerId){
        this.ledgerId = ledgerId;
        addValidField("ledgerId");
    }
    
    /**
     * Get 会计主体ID
     */
    @Column(name = "LEDGER_ID")
    public Long getLedgerId(){
        return ledgerId;
    }
    
    /**
     * Set 任务类型
     */
    public void setFeeTaskType(String feeTaskType){
        this.feeTaskType = feeTaskType;
        addValidField("feeTaskType");
    }
    
    /**
     * Get 任务类型
     */
    @Column(name = "FEE_TASK_TYPE")
    public String getFeeTaskType(){
        return feeTaskType;
    }
    
    /**
     * Set 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
        addValidField("businessType");
    }
    
    /**
     * Get 业务类型
     */
    @Column(name = "BUSINESS_TYPE")
    public String getBusinessType() {
        return businessType;
    }
    
    /**
     * Set 业务日期
     */
    public void setTaskDate(Date taskDate){
        this.taskDate = taskDate;
        addValidField("taskDate");
    }
    
    /**
     * Get 业务日期
     */
    @Column(name = "TASK_DATE")
    public Date getTaskDate(){
        return taskDate;
    }
    
    /**
     * Set 状态
     */
    public void setStatus(String status){
        this.status = status;
        addValidField("status");
    }
    
    /**
     * Get 状态
     */
    @Column(name = "STATUS")
    public String getStatus(){
        return status;
    }
    
    /**
     * Set 供应商确认状态
     */
    public void setSupStatus(String supStatus){
        this.supStatus = supStatus;
        addValidField("supStatus");
    }
    
    /**
     * Get 供应商确认状态
     */
    @Column(name = "SUP_STATUS")
    public String getSupStatus(){
        return supStatus;
    }
    
    /**
     * Set 币种
     */
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = currencyCode;
        addValidField("currencyCode");
    }
    
    /**
     * Get 币种
     */
    @Column(name = "CURRENCY_CODE")
    public String getCurrencyCode(){
        return currencyCode;
    }
    
    /**
     * Set 含税总金额
     */
    public void setAmount(Double amount){
        this.amount = amount;
        addValidField("amount");
    }
    
    /**
     * Get 含税总金额
     */
    @Column(name = "AMOUNT")
    public Double getAmount(){
        return amount;
    }
    
    /**
     * Set 税额
     */
    public void setTaxAmount(Double taxAmount){
        this.taxAmount = taxAmount;
        addValidField("taxAmount");
    }
    
    /**
     * Get 税额
     */
    @Column(name = "TAX_AMOUNT")
    public Double getTaxAmount(){
        return taxAmount;
    }
    
    /**
     * Set 不含税总金额
     */
    public void setNoTaxAmount(Double noTaxAmount){
        this.noTaxAmount = noTaxAmount;
        addValidField("noTaxAmount");
    }
    
    /**
     * Get 不含税总金额
     */
    @Column(name = "NO_TAX_AMOUNT")
    public Double getNoTaxAmount(){
        return noTaxAmount;
    }
    
    /**
     * Set 供应商确认金额
     */
    public void setSupplierComfirmAmount(Double supplierComfirmAmount){
        this.supplierComfirmAmount = supplierComfirmAmount;
        addValidField("supplierComfirmAmount");
    }
    
    /**
     * Get 供应商确认金额
     */
    @Column(name = "SUPPLIER_COMFIRM_AMOUNT")
    public Double getSupplierComfirmAmount(){
        return supplierComfirmAmount;
    }
    
    /**
     * Set 异常信息
     */
    public void setErrorMsg(String errorMsg){
        this.errorMsg = errorMsg;
        addValidField("errorMsg");
    }
    
    /**
     * Get 异常信息
     */
    @Column(name = "ERROR_MSG")
    public String getErrorMsg(){
        return errorMsg;
    }
    
    /**
     * Set 创建人
     */
    public void setCreator(String creator){
        this.creator = creator;
        addValidField("creator");
    }
    
    /**
     * Get 创建人
     */
    @Column(name = "CREATOR")
    public String getCreator(){
        return creator;
    }
    
    /**
     * Set 创建时间
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
        addValidField("createTime");
    }
    
    /**
     * Get 创建时间
     */
    @Column(name = "CREATE_TIME")
    public Date getCreateTime(){
        return createTime;
    }
    
    /**
     * Set 最后修改人
     */
    public void setModifier(String modifier){
        this.modifier = modifier;
        addValidField("modifier");
    }
    
    /**
     * Get 最后修改人
     */
    @Column(name = "MODIFIER")
    public String getModifier(){
        return modifier;
    }
    
    /**
     * Set 最后修改时间
     */
    public void setModifyTime(Date modifyTime){
        this.modifyTime = modifyTime;
        addValidField("modifyTime");
    }
    
    /**
     * Get 最后修改时间
     */
    @Column(name = "MODIFY_TIME")
    public Date getModifyTime(){
        return modifyTime;
    }
    
    /**
     * Set 版本号
     */
    public void setRecVer(Long recVer){
        this.recVer = recVer;
        addValidField("recVer");
    }
    
    /**
     * Get 版本号
     */
    @Column(name = "REC_VER")
    public Long getRecVer(){
        return recVer;
    }

    @Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	 @Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "FEE_SUPPLIER_NAME")
	public String getFeeSupplierName() {
		return feeSupplierName;
	}

	public void setFeeSupplierName(String feeSupplierName) {
		this.feeSupplierName = feeSupplierName;
	}

	@Column(name = "CLEARING_SUPPLIER_NAME")
	public String getClearingSupplierName() {
		return clearingSupplierName;
	}

	public void setClearingSupplierName(String clearingSupplierName) {
		this.clearingSupplierName = clearingSupplierName;
	}

	
	@Column(name = "LEDGER_NAME")
	public String getLedgerName() {
		return ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
    
    /**
     * Set 提交供应商确认时间
     */
    public void setToSupTime(Date toSupTime) {
        this.toSupTime = toSupTime;
        addValidField("toSupTime");
    }

    /**
     * Get 提交供应商确认时间
     */
    @Column(name = "TO_SUP_TIME")
    public Date getToSupTime() {
        return toSupTime;
    }

    /**
     * Set 供应商提交确认时间
     */
    public void setSupComfirmTime(Date supComfirmTime) {
        this.supComfirmTime = supComfirmTime;
        addValidField("supComfirmTime");
    }

    /**
     * Get 供应商提交确认时间
     */
    @Column(name = "SUP_COMFIRM_TIME")
    public Date getSupComfirmTime() {
        return supComfirmTime;
    }

    /**
     * Set 任务确认时间
     */
    public void setTaskComfirmTime(Date taskComfirmTime) {
        this.taskComfirmTime = taskComfirmTime;
        addValidField("taskComfirmTime");
    }

    /**
     * Get 任务确认时间
     */
    @Column(name = "TASK_COMFIRM_TIME")
    public Date getTaskComfirmTime() {
        return taskComfirmTime;
    }

    /**
     * Set 付款条件 SYS_SU_PAY_CONDITION
     */
    public void setPaymentTerms(Long paymentTerms) {
        this.paymentTerms = paymentTerms;
        addValidField("paymentTerms");
    }

    /**
     * Get 付款条件 SYS_SU_PAY_CONDITION
     */
    @Column(name = "PAYMENT_TERMS")
    public Long getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Set 是否代结标识 SYS_BMS_YES_NO
     */
    public void setIsReplaceSettlement(Long isReplaceSettlement) {
        this.isReplaceSettlement = isReplaceSettlement;
        addValidField("isReplaceSettlement");
    }

    /**
     * Get 是否代结标识 SYS_BMS_YES_NO
     */
    @Column(name = "IS_REPLACE_SETTLEMENT")
    public Long getIsReplaceSettlement() {
        return isReplaceSettlement;
    }
    
    /**
     * 是否虚拟付款标识
     * @return
     */
    @Column(name = "IS_VIRTUAL")
    public Long getIsVirtual() {
        return isVirtual;
    }

    /**
     * 是否虚拟付款标识
     * @param isVirtual
     */
    public void setIsVirtual(Long isVirtual) {
        this.isVirtual = isVirtual;
        addValidField("isVirtual");
    }

    @Column(name = "AP_BILL_NO")
	public String getApBillNo() {
		return apBillNo;
	}

	public void setApBillNo(String apBillNo) {
		this.apBillNo = apBillNo;
		addValidField("apBillNo");
	}
	
	@Column(name = "SUBSTR1")
    public String getSubstr1() {
        return substr1;
    }

    public void setSubstr1(String substr1) {
        this.substr1 = substr1;
        addValidField("substr1");
    }

    @Column(name = "SUBSTR2")
    public String getSubstr2() {
        return substr2;
    }

    public void setSubstr2(String substr2) {
        this.substr2 = substr2;
        addValidField("substr2");
    }

    @Column(name = "SUBSTR3")
    public String getSubstr3() {
        return substr3;
    }

    public void setSubstr3(String substr3) {
        this.substr3 = substr3;
        addValidField("substr3");
    }

    @Column(name = "SUBSTR4")
    public String getSubstr4() {
        return substr4;
    }

    public void setSubstr4(String substr4) {
        this.substr4 = substr4;
        addValidField("substr4");
    }

    @Column(name = "SUBDATE1")
    public Date getSubdate1() {
        return subdate1;
    }

    public void setSubdate1(Date subdate1) {
        this.subdate1 = subdate1;
        addValidField("subdate1");
    }

    @Column(name = "SUBDATE2")
    public Date getSubdate2() {
        return subdate2;
    }

    public void setSubdate2(Date subdate2) {
        this.subdate2 = subdate2;
        addValidField("subdate2");
    }

    @Column(name = "SUBNUM1")
    public Double getSubnum1() {
        return subnum1;
    }

    public void setSubnum1(Double subnum1) {
        this.subnum1 = subnum1;
        addValidField("subnum1");
    }

    @Column(name = "SUBNUM2")
    public Double getSubnum2() {
        return subnum2;
    }

    public void setSubnum2(Double subnum2) {
        this.subnum2 = subnum2;
        addValidField("subnum2");
    }

    @Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
		 addValidField("remark");
	}
    
    

}
