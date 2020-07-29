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
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	private String dekiveryDate;


	public String getDekiveryDate() {
		return dekiveryDate;
	}

	public void setDekiveryDate(String dekiveryDate) {
		this.dekiveryDate = dekiveryDate;
	}

	//見積金額
	@Column(name = "estimatedAmount")
	private int estimatedAmount;

	public int getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(int estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	//受注金額
	@Column(name = "orderAmount")
	private int orderAmount;

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
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
