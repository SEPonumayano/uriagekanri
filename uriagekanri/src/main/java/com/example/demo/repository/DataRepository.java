package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{
	//総件数
	@Query(value="SELECT * FROM maindata WHERE delete_flg=0",nativeQuery=true)
	List<Data> findAlldata();

}
