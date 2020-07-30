package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DataRequest;
import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class DataService {
	//一覧情報
	@Autowired
	private DataRepository dataRepository;

	//登録確認
	public void create(DataRequest dataRequest) {
		Data user = new Data();
		user.setNameid(dataRequest.getNameid());
		user.setOrderDate(dataRequest.getOrderDate());
		user.setsNumber(dataRequest.getsNumber());
		user.setSubTitle(dataRequest.getSubTitle());
		user.setItems(dataRequest.getItems());
		user.setDeliveryDesignatedDate(dataRequest.getDeliveryDesignatedDate());
		user.setDekiveryDate(dataRequest.getDekiveryDate());
		user.setEstimatedAmount(dataRequest.getEstimatedAmount());
		user.setOrderAmount(dataRequest.getOrderAmount());
		user.setStatusid(dataRequest.getStatusid());
		user.setRemark(dataRequest.getRemark());

	}

}
