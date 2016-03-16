package com.application.database;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCT")
public class Product extends BaseEntity {

	private transient static final long serialVersionUID = 8432479068947100637L;

	@Column(name = "FIRST_DAY")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date firstDay = new Date();

	@Column(name = "LAST_USED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUsedDate;

	@Column(name = "SERVICE_PROVIDER_NAME")
	private String providerName;

	@Column(name = "PRODUCT_NAME")
	@NotNull
	private String productName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "EXTERNAL_PRODUCT_NAME")
	private String genericProductName;

	@Column(name = "VALIDITY")
	private Integer validity = null;

	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public Date getLastUsedDate() {
		return lastUsedDate;
	}

	public void setLastUsedDate(Date lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
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

	 public String getGenericProductName() {
		 return genericProductName;
	 }

	 public void setGenericProductName(String genericProductName) {
		 this.genericProductName = genericProductName;
	 }

	 public Integer getValidity() {
		 return validity;
	 }

	 public void setValidity(Integer validity) {
		 this.validity = validity;
	 }

	 @Override
	 public boolean validate() {
		 // TODO Auto-generated method stub
		 return false;
	 }

	 @Override
	 public String toString() {
		 return "product details" + this.getName() + "]";
	 }

}
