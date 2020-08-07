package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DataRequest;
import com.example.demo.dto.DataUpdateRequest;
import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class DataService {
	//一覧情報
	@Autowired
	private DataRepository dataRepository;

	//主キー
	public Data findById(Long id) {
		return dataRepository.findById(id).get();
	}

	//一覧
	public List<Data> getfindListAll(){
		return dataRepository.findListAll();
	}

//--------------------------------------------------------------

	//登録確認
	public void create(DataRequest dataRequest) {

		Data user = new Data();
		user.setNameid(dataRequest.getNameid());
		user.setOrderDate(dataRequest.getOrderDate());
		user.setsNumber(dataRequest.getsNumber());
		user.setSubTitle(dataRequest.getSubTitle());
		user.setItems(dataRequest.getItems());
		user.setDeliveryDesignatedDate(dataRequest.getDeliveryDesignatedDate());
		user.setDeliveryDate(dataRequest.getDeliveryDate());
		user.setEstimatedAmount(dataRequest.getEstimatedAmount());
		user.setOrderAmount(dataRequest.getOrderAmount());
		user.setStatusid(dataRequest.getStatusid());
		user.setRemark(dataRequest.getRemark());

	}

	//DB登録
		public void creat(DataRequest dataRequest) {
			dataRepository.save(Order(dataRequest));
		}

	//登録データ
		public Data Order(DataRequest dataRequest) {
			Data user =new Data();
			user.setNameid(dataRequest.getNameid());
			user.setOrderDate(dataRequest.getOrderDate());
			user.setsNumber(dataRequest.getsNumber());
			user.setSubTitle(dataRequest.getSubTitle());
			user.setItems(dataRequest.getItems());
			user.setDeliveryDesignatedDate(dataRequest.getDeliveryDesignatedDate());
			user.setDeliveryDate(dataRequest.getDeliveryDate());
			user.setEstimatedAmount(dataRequest.getEstimatedAmount());
			user.setOrderAmount(dataRequest.getOrderAmount());
			user.setStatusid(dataRequest.getStatusid());
			user.setRemark(dataRequest.getRemark());

			user.setDelete_flg("0");

			return user;
		}

//----------------------------------------------------------------

	//編集確認
	public void createe(DataUpdateRequest dataUpdateRequest) {
		Data user = new Data();
		user.setNameid(dataUpdateRequest.getNameid());
		user.setOrderDate(dataUpdateRequest.getOrderDate());
		user.setsNumber(dataUpdateRequest.getsNumber());
		user.setSubTitle(dataUpdateRequest.getSubTitle());
		user.setItems(dataUpdateRequest.getItems());
		user.setDeliveryDesignatedDate(dataUpdateRequest.getDeliveryDesignatedDate());
		user.setDeliveryDate(dataUpdateRequest.getDeliveryDate());
		user.setEstimatedAmount(dataUpdateRequest.getEstimatedAmount());
		user.setOrderAmount(dataUpdateRequest.getOrderAmount());
		user.setStatusid(dataUpdateRequest.getStatusid());
		user.setRemark(dataUpdateRequest.getRemark());

	}

	//DB更新
	public void creatt(DataUpdateRequest dataUpdateRequest) {
		Data user =findById(dataUpdateRequest.getId());

		user.setNameid(dataUpdateRequest.getNameid());
		user.setOrderDate(dataUpdateRequest.getOrderDate());
		user.setsNumber(dataUpdateRequest.getsNumber());
		user.setSubTitle(dataUpdateRequest.getSubTitle());
		user.setItems(dataUpdateRequest.getItems());
		user.setDeliveryDesignatedDate(dataUpdateRequest.getDeliveryDesignatedDate());
		user.setDeliveryDate(dataUpdateRequest.getDeliveryDate());
		user.setEstimatedAmount(dataUpdateRequest.getEstimatedAmount());
		user.setOrderAmount(dataUpdateRequest.getOrderAmount());
		user.setStatusid(dataUpdateRequest.getStatusid());
		user.setRemark(dataUpdateRequest.getRemark());

		dataRepository.save(user);
	}

//------------------------------------------------------------------

	//削除
	public void creattt(DataUpdateRequest dataUpdateRequest) {
		Data user =findById(dataUpdateRequest.getId());

		user.setDelete_flg("1");

		dataRepository.save(user);
	}

}
