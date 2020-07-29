package com.example.demo.dto;

import java.io.Serializable;

public class DataRequest implements Serializable{

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	private String orderDate;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	private String sNumber;

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}


	private String subTitle;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	private String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}


	private String deliveryDesignatedDate;

	public String getDeliveryDesignatedDate() {
		return deliveryDesignatedDate;
	}

	public void setDeliveryDesignatedDate(String deliveryDesignatedDate) {
		this.deliveryDesignatedDate = deliveryDesignatedDate;
	}

	private String dekiveryDate;


	public String getDekiveryDate() {
		return dekiveryDate;
	}

	public void setDekiveryDate(String dekiveryDate) {
		this.dekiveryDate = dekiveryDate;
	}


	private int estimatedAmount;

	public int getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(int estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}


	private int orderAmount;

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}


	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



}
