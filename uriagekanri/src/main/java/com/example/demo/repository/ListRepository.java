package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Listdata;

@Repository
public interface ListRepository extends JpaRepository<Listdata, Long>{
	@Query(value="SELECT id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,statusid,remark,delete_flg,clientname.nameid,client FROM maindata INNER JOIN clientname ON maindata.nameid=clientname.nameid WHERE delete_flg=0",nativeQuery=true)
	Page<Listdata> findAlldataA(Pageable pageable);

	@Query(value="SELECT id,maindata.nameid,orderdate,snumber,subtitle,items,delivery_designated_date,delivery_date,billing_date,estimated_amount,order_amount,statusid,remark,delete_flg,clientname.nameid,client FROM maindata INNER JOIN clientname ON maindata.nameid=clientname.nameid WHERE delete_flg=0 AND subtitle LIKE %:keyword%",nativeQuery=true)
	Page<Listdata> searchword(@Param("keyword")String keyword, Pageable pageable);


}
