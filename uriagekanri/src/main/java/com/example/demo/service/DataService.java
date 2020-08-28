package com.example.demo.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DataRequest;
import com.example.demo.entity.Clientname;
import com.example.demo.entity.Data;
import com.example.demo.entity.Listdata;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DataRepository;
import com.example.demo.repository.ListRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class DataService {
	//DB情報
	@Autowired
	private DataRepository dataRepository;

	@Autowired
	private ListRepository listRepository;

	@Autowired
	private ClientRepository clientRepository;

	//一覧表示
	public Page<Listdata> getfindAlldataA (Pageable pageable){
		return listRepository.findAlldataA(pageable);
	}

	//検索、ページング
	public Page<Listdata> getsearchword(DataRequest dataRequest,Pageable pageable) {
			DataRequest word =new DataRequest();
			String keyword=word.setKeyword(dataRequest.getKeyword());
			return listRepository.searchword(keyword,pageable);
		}

	//ID取得
	public Data findById(Long id) {
		return dataRepository.findById(id).get();
	}

	//顧客名選択
	public List<Clientname> getclientselect(){
		return clientRepository.clientselect();
	}

	//顧客名検索
	public Clientname findByIdA(Long nameid) {
		return clientRepository.findById(nameid).get();
	}


//-----------------------------------------------------------------------------

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
		user.setBillingDate(dataRequest.getBillingDate());
		user.setEstimatedAmount(dataRequest.getEstimatedAmount());
		user.setOrderAmount(dataRequest.getOrderAmount());
		user.setStatusid(dataRequest.getStatusid());
		user.setRemark(dataRequest.getRemark());
		//Clientname select=findByIdA(dataRequest.getNameid());

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
			user.setBillingDate(dataRequest.getBillingDate());
			user.setEstimatedAmount(dataRequest.getEstimatedAmount());
			user.setOrderAmount(dataRequest.getOrderAmount());
			user.setStatusid(dataRequest.getStatusid());
			user.setRemark(dataRequest.getRemark());
			user.setDelete_flg("0");

			return user;
		}

//-------------------------------------------------------------------------------

	//編集確認
		public void createe(DataRequest dataRequest) {
			Data user =new Data();

			user.setNameid(dataRequest.getNameid());
			user.setOrderDate(dataRequest.getOrderDate());
			user.setsNumber(dataRequest.getsNumber());
			user.setSubTitle(dataRequest.getSubTitle());
			user.setItems(dataRequest.getItems());
			user.setDeliveryDesignatedDate(dataRequest.getDeliveryDesignatedDate());
			user.setDeliveryDate(dataRequest.getDeliveryDate());
			user.setBillingDate(dataRequest.getBillingDate());
			user.setEstimatedAmount(dataRequest.getEstimatedAmount());
			user.setOrderAmount(dataRequest.getOrderAmount());
			user.setStatusid(dataRequest.getStatusid());
			user.setRemark(dataRequest.getRemark());
		}

	//DB登録
		public void creatt(DataRequest dataRequest) {
			Data user =findById(dataRequest.getId());

			user.setNameid(dataRequest.getNameid());
			user.setOrderDate(dataRequest.getOrderDate());
			user.setsNumber(dataRequest.getsNumber());
			user.setSubTitle(dataRequest.getSubTitle());
			user.setItems(dataRequest.getItems());
			user.setDeliveryDesignatedDate(dataRequest.getDeliveryDesignatedDate());
			user.setDeliveryDate(dataRequest.getDeliveryDate());
			user.setBillingDate(dataRequest.getBillingDate());
			user.setEstimatedAmount(dataRequest.getEstimatedAmount());
			user.setOrderAmount(dataRequest.getOrderAmount());
			user.setStatusid(dataRequest.getStatusid());
			user.setRemark(dataRequest.getRemark());
			user.setDelete_flg("0");

			dataRepository.save(user);
		}

//----------------------------------------------------------------------------------

	//削除
		public void creattt(DataRequest dataRequest) {
			Data user =findById(dataRequest.getId());

			user.setDelete_flg("1");

			dataRepository.save(user);
		}

}
