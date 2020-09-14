package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{

}

