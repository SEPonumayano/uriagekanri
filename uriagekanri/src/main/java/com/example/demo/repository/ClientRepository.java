package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClientSelect;

@Repository
public interface ClientRepository extends JpaRepository<ClientSelect, Long>{
	@Query(value="SELECT * FROM clientname",nativeQuery=true)
	List<ClientSelect> clientData();

}
