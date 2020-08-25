package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="main")
@Table(name = "maindata")
public class Listdata implements Serializable{
	//DBの情報引き出す用
		private static final long serialVersionUID = -870708489937857961L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@TableGenerator(name="seqTable", table="seq_table", pkColumnName="seq_name", pkColumnValue="word_seq", valueColumnName="seq_value")
		@Column(name = "id")
		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		//@Column(name = "nameid")
		//private String nameId;


		//public String getNameId() {
		//	return nameId;
		//}

		//public void setNameId(String nameId) {
			//this.nameId = nameId;
		//}

		//S番号
		//名前
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
		private String items;

		public String getItems() {
			return items;
		}

		public void setItems(String items) {
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


		//顧客ID
		//結合
		@ManyToOne
		@JoinColumn(name="nameid",referencedColumnName="nameid")
		private  Clientname nameid;

		public Clientname getNameid() {
			return nameid;
		}

		public void setNameid(Clientname nameid) {
			this.nameid = nameid;
		}

		//@ManyToOne
		//@JoinColumn(name="nameid_nameid",referencedColumnName="nameid")
		//private  Clientname clientname;

		//public String getClientname() {
			//return clientname;
		//}

		//public void setClientname(String nameid) {
			//this.nameid = nameid;
		//}

	//,referencedColumnName="nameid"/ (fetch = FetchType.LAZY)
		//@ManyToOne
		//@JoinColumn(name="nameid")
		//private  Clientname nameid;

		//public Clientname getNameid() {
			//return nameid;
		//}

		//public void setNameid(Clientname nameid) {
			//this.nameid = nameid;
		//}


}
