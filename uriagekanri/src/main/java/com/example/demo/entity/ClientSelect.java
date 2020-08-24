package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientname")
public class ClientSelect implements Serializable{

	@Id
	@GeneratedValue
	private Long nameid;

	private String client;

	@OneToMany(mappedBy="clientname",cascade=CascadeType.ALL)
	private List<Data> datas;

	public Long getNameid() {
		return nameid;
	}

	public void setNameid(Long nameid) {
		this.nameid = nameid;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}




}
