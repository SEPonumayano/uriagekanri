package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;


public class DataRequest implements Serializable{


	//キーワード：件名
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public String setKeyword(String keyword) {
		return this.keyword = keyword;
	}

	//キーワード：顧客ID
	private int nameidkw;

	public int getNameidkw() {
		return nameidkw;
	}

	public int setNameidkw(int nameidkw) {
		return this.nameidkw = nameidkw;
	}

	//キーワード：ステータスID
	private int statusidkw;

	public int getStatusidkw() {
		return statusidkw;
	}

	public int setStatusidkw(int statusidkw) {
		return this.statusidkw = statusidkw;
	}


	//ID
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//顧客名ID
	private int nameid;

	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
	}

	//顧客名
	private String client;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	//受注日
	private Date orderDate;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
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
	@NotEmpty(message="件名は必須項目です")
	private String subTitle;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	//数量
	@Range(min=0 , max=99999,message="最大桁数は5桁です。")
	private Integer items;

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}


	//納入指定日
	private Date deliveryDesignatedDate;

	public Date getDeliveryDesignatedDate() {
		return deliveryDesignatedDate;
	}

	public void setDeliveryDesignatedDate(Date deliveryDesignatedDate) {
		this.deliveryDesignatedDate = deliveryDesignatedDate;
	}


	//納入日
	private Date deliveryDate;

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	//請求日
	private Date billingDate;

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}


	//見積金額
	//@Size(max=12,message="最大桁数は12桁です。")
	private Integer estimatedAmount;

	public Integer getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(Integer estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}


	//受注金額
	//@Size(max=12,message="最大桁数は12桁です。")
	private Integer orderAmount;

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}


	//ステータス
	private int statusid;

	public  int getStatusid() {
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


	//ステータス名
	private String stname;

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}





}
