package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Datalist3;



@Repository
public interface ClientsRepository extends JpaRepository<Datalist3, Integer>,JpaSpecificationExecutor<Datalist3>{
	//Specification用
		/*private interface Specification<Datalist3> nameContains(int nameidkw){
			return new Specification<Datalist3>() {
				@Override
				public Predicate toPredicate(Root<DataList3> root,CriteriaQuery<?> query,CriteriaBuilder cb) {
					return cb.like(root.get("nameid"),"%"+nameidkw+"%");
				}
			};

		}*/
}
