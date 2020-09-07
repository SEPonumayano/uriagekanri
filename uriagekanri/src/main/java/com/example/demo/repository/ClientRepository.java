package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Clientname;

@Repository
public interface ClientRepository extends JpaRepository<Clientname, Long>{

	@Query(value="SELECT * FROM clientname",nativeQuery=true)
	List<Clientname> clientselect();


	//登録確認、顧客名
	@Query(value="SELECT client FROM clientname WHERE nameid=:clientnameid",nativeQuery=true)
	List<Clientname> clientselectname(@Param("clientnameid")Long clientnameid);

}
