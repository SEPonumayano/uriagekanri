package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Clientname;

@Repository
public interface ClientRepository extends JpaRepository<Clientname, Long>{

	@Query(value="SELECT * FROM clientname",nativeQuery=true)
	List<Clientname> clientselect();

}
