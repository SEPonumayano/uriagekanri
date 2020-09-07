package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clients")
public class Clients implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Column(name = "statusid")
	private int statusid;

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	@Column(name="stname")
	private String stname;

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	@Column(name = "nameid")
	private Long nameid;

	public Long getNameid() {
		return nameid;
	}

	public void setNameid(Long nameid) {
		this.nameid = nameid;
	}

}
