package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client1Ste;

@Repository
public interface Client1Repository extends JpaRepository<Client1Ste, Integer>{

	@Query(value="SELECT * FROM client1 where statusid !=0",nativeQuery=true)
	List<Client1Ste> clientSte1();

}
