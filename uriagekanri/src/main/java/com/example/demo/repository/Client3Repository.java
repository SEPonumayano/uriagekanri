package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client3Ste;


@Repository
public interface Client3Repository extends JpaRepository<Client3Ste, Integer>{

	@Query(value="SELECT * FROM client3",nativeQuery=true)
	List<Client3Ste> clientSte3();

}
