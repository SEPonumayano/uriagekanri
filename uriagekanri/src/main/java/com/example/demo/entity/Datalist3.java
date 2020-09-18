package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NamedNativeQuery(name="clients", query = "select id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,statusid,remark,delete_flg,client,stname from(maindata join clientname on maindata.nameid=clientname.nameid)join cliens on maindata.statusid=clients.statusid where clients.nameid=clientname.nameid order by maindata.id ASC")
public class Datalist3 implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//受注日
	private Date orderdate;

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	//顧客ID
	private int nameid;

	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
	}

	//S番号
	private String snumber;

	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}

	//件名
	private String subtitle;

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	//数量
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
		this.billingDate=billingDate;
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
	private String order_amount;

	public String getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
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

	//削除プラグ
	private String delete_flg;

	public String getDelete_flg() {
		return delete_flg;
	}
	public void setDelete_flg(String delete_flg) {
		this.delete_flg=delete_flg;
	}

	//顧客名
	private String client;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
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
