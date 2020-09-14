package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "clientname")
@Table(name = "clientname")
public class Clientname implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nameid;

	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
	}

	private String client;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}


	//@OneToMany(mappedBy="nameid")
	//private Data data;

	//public Data getData() {
		//return data;
	//}

	//public void setData(Data data) {
		//this.data = data;
	//}


}
