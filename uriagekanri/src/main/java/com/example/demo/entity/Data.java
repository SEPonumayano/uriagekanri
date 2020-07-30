package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "maindata")
public class Data implements Serializable{

	//DBの情報引き出す用
		private static final long serialVersionUID = -870708489937857961L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name="seqTable", table="seq_table", pkColumnName="seq_name", pkColumnValue="word_seq", valueColumnName="seq_value")
	@Column(name = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//顧客名
	@Column(name = "nameid")
	private String nameid;

	public String getNameid() {
		return nameid;
	}

	public void setNameid(String nameid) {
		this.nameid = nameid;
	}

	//受注日
	@Column(name = "orderDate")
	private String orderDate;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	//S番号
	//名前
	@Column(name = "sNumber")
	private String sNumber;

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	//件名
	@Column(name = "subTitle")
	private String subTitle;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	//数量
	@Column(name = "items")
	private String items;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	//納入指定日
	@Column(name = "deliveryDesignatedDate")
	private String deliveryDesignatedDate;

	public String getDeliveryDesignatedDate() {
		return deliveryDesignatedDate;
	}

	public void setDeliveryDesignatedDate(String deliveryDesignatedDate) {
		this.deliveryDesignatedDate = deliveryDesignatedDate;
	}

	//納入日
	@Column(name = "deliveryDate")
	private String deliveryDate;


	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	//見積金額
	@Column(name = "estimatedAmount")
	private String estimatedAmount;

	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	//受注金額
	@Column(name = "orderAmount")
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






}
