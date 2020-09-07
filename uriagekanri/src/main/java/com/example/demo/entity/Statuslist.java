package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;

//一覧表示、ステータス部分

@Entity(name="statuslist")
@NamedNativeQueries(value="select client,stname from(maindata join clientname on maindata.nameid=clientname.nameid)join cliens on maindata.statusid=clients.statusid where clients.nameid=clientname.nameid order by maindata.id ASC")
public class Statuslist extends Listdata implements Serializable{;

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
private Clientname nameid;

public Clientname getNameid() {
	return nameid;
}

public void setNameid(Clientname nameid) {
	this.nameid = nameid;
}


}
