package com.example.demo.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DataRequest;
import com.example.demo.entity.Client1Ste;
import com.example.demo.entity.Client2Ste;
import com.example.demo.entity.Client3Ste;
import com.example.demo.entity.Clientname;
import com.example.demo.entity.Data;
import com.example.demo.entity.Datalist3;
import com.example.demo.entity.Listdata;
import com.example.demo.repository.Client1Repository;
import com.example.demo.repository.Client2Repository;
import com.example.demo.repository.Client3Repository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ClientsRepository;
import com.example.demo.repository.DataRepository;
import com.example.demo.repository.Datalist3Repository;
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

	@Autowired
	private Client1Repository client1Repository;

	@Autowired
	private Client2Repository client2Repository;

	@Autowired
	private Client3Repository client3Repository;

	@Autowired
	private ClientsRepository clientsRepository;

	@Autowired
	private Datalist3Repository datalist3Repository;


	//3テーブル結合（テスト）
	public Page<Datalist3> getTestlist(Pageable pageable){
		return datalist3Repository.testlist(pageable);
	}

	public Page<Datalist3> getSearchlist(DataRequest dataRequest, Pageable pageable) {
		DataRequest word =new DataRequest();
		String keyword=word.setKeyword(dataRequest.getKeyword());
		int nameid=dataRequest.getNameid();
		int statusid=dataRequest.getStatusid();

		return datalist3Repository.searchlist(keyword,nameid,statusid,pageable);
	}

	public Page<Datalist3> getSeachKey(DataRequest dataRequest, Pageable pageable) {
		DataRequest word =new DataRequest();
		String keyword=word.setKeyword(dataRequest.getKeyword());

		return datalist3Repository.searchlist(keyword,pageable);
	}

	public Page<Datalist3> getSeachKeyNameid(DataRequest dataRequest,Pageable pageable) {
		DataRequest word =new DataRequest();
		String keyword=word.setKeyword(dataRequest.getKeyword());
		int nameid=dataRequest.getNameid();
		return datalist3Repository.searchKeyNameid(keyword,nameid,pageable);
	}


	//一覧表示(今は使ってないやつ)
	public Page<Listdata> getfindAlldataA (Pageable pageable){
		return listRepository.findAlldataA(pageable);
	}


	//検索、ページング(使ってないやつ)
	public Page<Listdata> getsearchword(DataRequest dataRequest,Pageable pageable) {
			DataRequest word =new DataRequest();
			String keyword=word.setKeyword(dataRequest.getKeyword());
			return listRepository.searchword(keyword,pageable);
		}

	//ID取得
	public Data findById(int id) {
		return dataRepository.findById(id).get();
	}

	//顧客名選択
	public List<Clientname> getclientselect(){
		return clientRepository.clientselect();
	}

	//顧客名検索
	public Clientname findByIdA(int nameid) {
		return clientRepository.findById(nameid).get();
	}

	//ステータス1
	public List<Client1Ste> getclientSte1(){
		return client1Repository.clientSte1();
	}

	//ステータス2
	public List<Client2Ste> getclientSte2(){
		return client2Repository.clientSte2();
	}

	//ステータス3
	public List<Client3Ste> getclientSte3(){
		return client3Repository.clientSte3();
	}

	//登録確認、顧客名取得
	public List<Clientname> getclientselectname(DataRequest dataRequest){
		DataRequest word =new DataRequest();
		int clientnameid=word.getNameid();
		return clientRepository.clientselectname(clientnameid);
	}

	//selectステータス名取得
	public Client1Ste findById1(int statusid) {
		return client1Repository.findById(statusid).get();
	}

	public Client2Ste findById2(int statusid) {
		return client2Repository.findById(statusid).get();
	}

	public Client3Ste findById3(int statusid) {
		return client3Repository.findById(statusid).get();
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
