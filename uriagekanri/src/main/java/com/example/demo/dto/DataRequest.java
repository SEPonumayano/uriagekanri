package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class DataRequest implements Serializable{


	//キーワード
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public String setKeyword(String keyword) {
		return this.keyword = keyword;
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
	@Pattern(regexp="S-[0-9]{4}$" ,message="S番号は「S-4桁の数字」で入力してください")
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
	@Size(max=5,message="最大桁数は5桁です。")
	private String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
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
	@Size(max=12,message="最大桁数は12桁です。")
	private String estimatedAmount;

	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}


	//受注金額
	@Size(max=12,message="最大桁数は12桁です。")
	private String orderAmount;

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
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
