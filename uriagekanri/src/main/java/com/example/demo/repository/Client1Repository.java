package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client1Ste;

@Repository
public interface Client1Repository extends JpaRepository<Client1Ste, Long>{

}
