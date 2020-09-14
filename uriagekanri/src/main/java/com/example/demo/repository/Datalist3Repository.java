package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Datalist3;

@Repository
public interface Datalist3Repository extends JpaRepository<Datalist3, Integer>{
	@Query(value = "select id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,maindata.statusid,remark,delete_flg,client,stname from(maindata join clientname on maindata.nameid=clientname.nameid)join clients on maindata.statusid=clients.statusid where clients.nameid=clientname.nameid AND delete_flg=0 order by maindata.id ASC",nativeQuery=true)
	Page<Datalist3> testlist(Pageable pageable);

	@Query(value = "select id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,maindata.statusid,remark,delete_flg,client,stname from(maindata join clientname on maindata.nameid=clientname.nameid)join clients on maindata.statusid=clients.statusid where clients.nameid=clientname.nameid AND delete_flg=0 AND subtitle LIKE %:keyword% order by maindata.id ASC",nativeQuery=true)
	Page<Datalist3> searchlist(@Param("keyword")String keyword, Pageable pageable);

}
