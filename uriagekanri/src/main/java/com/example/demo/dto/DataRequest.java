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


	//顧客名ID
	private String nameid;

	public String getNameid() {
		return nameid;
	}

	public void setNameid(String nameid) {
		this.nameid = nameid;
	}


	//受注日
	private String orderDate;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	//S番号
	private String sNumber;

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}


	//件名
	private String subTitle;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	//数量
	private String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}


	//納入指定日
	private String deliveryDesignatedDate;

	public String getDeliveryDesignatedDate() {
		return deliveryDesignatedDate;
	}

	public void setDeliveryDesignatedDate(String deliveryDesignatedDate) {
		this.deliveryDesignatedDate = deliveryDesignatedDate;
	}


	//納入日
	private String deliveryDate;

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	//見積金額
	private String estimatedAmount;

	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}


	//受注金額
	private String orderAmount;

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}


	//ステータス
	private int statusid;

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}


	//備考
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
