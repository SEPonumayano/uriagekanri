package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Statuslist;



@Repository
public interface ClientsRepository extends JpaRepository<Statuslist, Integer>{

	//一覧表示、ステータス用

	//@Query(value="select * from maindata inner join clients on maindata.statusid=clients.statusid where delete_flg=0 and maindata.nameid=clients.nameid order by maindata.id ASC",nativeQuery=true)
	//List<Statuslist> findAlldataB();
}
