package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client2Ste;

@Repository
public interface Client2Repository extends JpaRepository<Client2Ste, Integer>{

	@Query(value="SELECT * FROM client2",nativeQuery=true)
	List<Client2Ste> clientSte2();

}
