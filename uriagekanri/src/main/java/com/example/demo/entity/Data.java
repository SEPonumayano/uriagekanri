package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="maindata")
@Table(name = "maindata")
public class Data implements Serializable{

	//DBの情報引き出す用
	private static final long serialVersionUID = -870708489937857961L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//受注日
	@Column(name = "orderdate")
	private Date orderDate;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date date) {
		this.orderDate = date;
	}

	//顧客名
	@Column(name = "nameid")
	private int nameid;


	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
	}

	//S番号
	@Column(name = "snumber")
	private String sNumber;

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	//件名
	@Column(name = "subtitle")
	private String subTitle;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	//数量
	@Column(name = "items")
	private Integer items;

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	//納入指定日
	@Column(name = "delivery_designated_date")
	private Date deliveryDesignatedDate;

	public Date getDeliveryDesignatedDate() {
		return deliveryDesignatedDate;
	}

	public void setDeliveryDesignatedDate(Date deliveryDesignatedDate) {
		this.deliveryDesignatedDate = deliveryDesignatedDate;
	}

	//納入日
	@Column(name = "delivery_date")
	private Date deliveryDate;


	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	//請求日
	@Column(name="billing_date")
	private Date billingDate;

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate=billingDate;
	}

	//見積金額
	@Column(name = "estimated_amount")
	private String estimatedAmount;

	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	//受注金額
	@Column(name = "order_amount")
	private String orderAmount;

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}


	//ステータス
	@Column(name = "statusid")
	private int statusid;

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	//備考
	@Column(name = "remark")
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	//削除プラグ
	@Column(name="delete_flg")
	private String delete_flg;

	public String getDelete_flg() {
		return delete_flg;
	}
	public void setDelete_flg(String delete_flg) {
		this.delete_flg=delete_flg;
	}



}
