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
	private DataRepository userRepository;

	//登録確認
	public void create(DataRequest userRequest) {
		Data user = new Data();
		user.setName(userRequest.getName());

	}

}
