package com.application.database;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCT")
public class Product extends BaseEntity {

    private transient static final long serialVersionUID = 8432479068947100637L;

    @Column(name = "INTRODUCTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date introductionDate = new Date();

    @Column(name = "SUPPORT_DISCONTINUATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supportDiscontinuationDate;

    @Column(name = "SALES_DISCONTINUATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date salesDiscontinuationDate;

    @Column(name = "INTERNAL_NAME")
    private String internalName;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "IS_SERIALIZED", nullable=false)
    private boolean isSerialized = false;

    //This determines whether a new agreement needs to be signed when this product is sold.
    @Column(name="REQUIRES_AGREEMENT", nullable=false)
    private boolean isRequiresAgreement = false;

    @Column(name = "IMEI_AS_SN", nullable=false)
    private boolean isImeiSn = true;

    @Column(name = "PRODUCT_NAME")
    @NotNull
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_PHYSICAL", nullable=false)
    private boolean isPhysical = false;

    @Column(name = "IS_TAXABLE", nullable=false)
    @NotNull
    private boolean isTaxable = false;

    @Column(name = "IS_CREDIT_CHECK")
    @NotNull
    private boolean isCreditCheck = false;

    @Column(name = "REORDER_QUANTITY")
    private Integer reorderQuantity = 0;

	@Column(name="PRODUCT_TYPE_CODE", insertable=true, updatable=false, length=20)
	private String productTypeCode;

	@Column(name = "TIME_TO_LIVE")
    private Integer timeToLive;

	@Column(name = "PRODUCT_ACTION_CLASS")
    private String productActionClass;

	@Column(name="DEFAULT_DECIMAL_QUANTITY")
	private BigDecimal defaultQuantity = BigDecimal.ONE;

	@Column(name = "EXTERNAL_PRODUCT_NUM")
    private String externalProductNumber;

    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    // should be in ServiceProduct, but moved here due to classcastexceptions from hibernate
	@Column(name = "TRIAL")
    private Boolean trial = null;

	@Column(name = "TRIAL_DAYS")
    private Integer trialDays = null;

	@Column(name = "ALLOW_TRIAL_OVERRIDE")
    private Boolean trialOverride = null;

    public Date getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate = introductionDate;
    }

    public Date getSupportDiscontinuationDate() {
        return supportDiscontinuationDate;
    }

    public void setSupportDiscontinuationDate(Date supportDiscontinuationDate) {
        this.supportDiscontinuationDate = supportDiscontinuationDate;
    }

    public Date getSalesDiscontinuationDate() {
        return salesDiscontinuationDate;
    }

    public void setSalesDiscontinuationDate(Date salesDiscontinuationDate) {
        this.salesDiscontinuationDate = salesDiscontinuationDate;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    /**
     * @deprecated use getName()
     */
    @Deprecated
    public String getProductName() {
        return productName;
    }

    /**
     * @deprecated use setName()
     */
    @Deprecated
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "com.transverse.bleep.domain.core.entity.Product[productId=" + this.getName() + "]";
    }
	/**
	 * Set the products related to this product
	 *
	 * @param productRelations
	 */
	
	/**
	 * Return a list of related products that match the given relationship type and given product classification.
	 *
	 * @param productRelationType
	 * @param productClassification
	 * @return relatedProducts
	 */

	/**
	 * Return a list of active related products that match the given relationship type.
	 *
	 * @param productRelationType
	 * @return relatedProducts
	 */
	/**
	 * Indicates if the given product is related with the given relation type
	 *
	 * @param product
	 * @param productRelationType
	 * @return
	 */
	 
	/**
	 * Checks to see whether product price is entered properly. If a product has a subscription, then needs to have
	 * a recurring price (Can have a fixed price as well, but definitely needs recurring price).
	 *
	 * If product is not a subscription, then needs to have a fixed price. Cannot have recurring price.
	 *
	 * @return
	 */
	
	/**
	 * Make the product not available to sale
	 */
	public boolean getIsTaxable() {
		return isTaxable;
	}

	public void setIsTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	/**
	 * @param productFeatureValues the productFeatureValues to set
	 */
	
	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param isSerialized the isSerialized to set
	 */

	/**
	 * @return the isSerialized
	 */

	public boolean getIsCreditCheck() {
		return isCreditCheck;
	}

	public void setIsCreditCheck(boolean isCreditCheck) {
		this.isCreditCheck = isCreditCheck;
	}

	/**
	 * @return the productType
	 */

    /**
     * @return the reorderQuantity
     */
    public Integer getReorderQuantity() {
        return reorderQuantity;
    }

    public boolean isSerialized() {
		return isSerialized;
	}

	public void setSerialized(boolean isSerialized) {
		this.isSerialized = isSerialized;
	}

	public boolean isPhysical() {
		return isPhysical;
	}

	public void setPhysical(boolean isPhysical) {
		this.isPhysical = isPhysical;
	}

	public void setRequiresAgreement(boolean isRequiresAgreement) {
		this.isRequiresAgreement = isRequiresAgreement;
	}

	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	public void setCreditCheck(boolean isCreditCheck) {
		this.isCreditCheck = isCreditCheck;
	}

	/**
     * @param reorderQuantity the reorderQuantity to set
     */
    public void setReorderQuantity(Integer reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

	/**
	 * @return the preferredVendor
	 */


	/**
	 * @param preferredVendor the preferredVendor to set
	 */
	/**
	 * @return the agreements
	 */

	/***
	 * Add new agreements if doesn't exist
	 *
	 * @param newAgreements
	 */    

	/**
	 * @return the isRequiresAgreement
	 */
	public boolean isRequiresAgreement() {
		return isRequiresAgreement;
	}

	/**
	 * @param isRequiresAgreement the isRequiresAgreement to set
	 */
	public void setIsRequiresAgreement(boolean isRequiresAgreement) {
		this.isRequiresAgreement = isRequiresAgreement;
	}

    public boolean isImeiSn() {
        return isImeiSn;
    }

    public void setImeiSn(boolean isImeiSn) {
        this.isImeiSn = isImeiSn;
    }

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public String getProductTypeCode() {
		return productTypeCode;
	}


	public void setTimeToLive(Integer timeToLive) {
		this.timeToLive = timeToLive;
	}

	public Integer getTimeToLive() {
		return timeToLive;
	}


	/**
	 * @return
	 */

	public void setProductActionClass(String productActionClass) {
		this.productActionClass = productActionClass;
	}

	public String getProductActionClass() {
		return productActionClass;
	}

	public BigDecimal getDefaultQuantity() {
		return defaultQuantity;
	}

	public void setDefaultQuantity(BigDecimal defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}


	public String getExternalProductNumber() {
		return externalProductNumber;
	}

	public void setExternalProductNumber(String externalProductNumber) {
		this.externalProductNumber = externalProductNumber;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	public Boolean getTrial() {
		return trial;
	}

	public boolean isTrial() {
		boolean b = trial == null ? false : trial;

		return b;
	}

	public void setTrial(Boolean trial) {
		this.trial = trial;
	}

	public Integer getTrialDays() {
		return trialDays;
	}

	public void setTrialDays(Integer trialDays) {
		this.trialDays = trialDays;
	}

	/**
	 * For determining whether the price has adhoc /scheduled charge.
	 *
	 * @return
	 */
	public boolean isTrialOverride() {
		return trialOverride == null ? false : trialOverride;
	}

	public Boolean getTrialOverride() {
		return trialOverride;
	}

	public void setTrialOverride(Boolean trialOverride) {
		this.trialOverride = trialOverride;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This method is overridden by specific classes to provide specific implementation.
	 *
	 * @param criteria
	 * @return
	 */
	/**
	 * Finds the list of products that are compatible with the current instance of the product.
	 *
	 * @return list of compatible products
	 */
	

	/**
	 * Finds the list of products that are compatible with originalProduct
	 * @param originalService
	 * @param parentProduct
	 * @param hasCurrentAgreementService  - This is to indicate whether the current service has an agreement. The product may have agreement added or removed later on.
	 * @param preserveAgreement - If agreement will be preserved, display products which may or may not have agreements.
	 * @return list of compatible products
	 */
	


	/**
	 * Finds the list of products that are compatible with originalProduct and are active in the future on the passed in date.
	 *
	 * @param futureDate required date to filter out future discontinued products.
	 * @param currentProduct
	 * @return list of products active at the date passed in.
 	 */


	/*
	 * Determines whether the number of product's service resources is in range for a target product.
	 * @param origService - current service
	 * @param targetProduct - target product
	 * @return true if number of service resources in curService will fit into the targetProduct
	 */

	/*
	 * Determines whether the number of product's service resources is in range for a target product.
	 * @param currentProduct - current product
	 * @param nextProduct - next product
	 * @return true if number of service resources in curService will fit into the targetProduct
	 */
}
