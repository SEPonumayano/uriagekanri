package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Datalist3;

@Repository
public interface Datalist3Repository extends JpaRepository<Datalist3, Long>{
	@Query(value = "select id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,statusid,remark,delete_flg,client,stname from(maindata join clientname on maindata.nameid=clientname.nameid)join cliens on maindata.statusid=clients.statusid where clients.nameid=clientname.nameid order by maindata.id ASC",nativeQuery=true)
	List<Datalist3> testlist();

}
