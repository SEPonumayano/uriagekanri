package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dto.DataRequest;
import com.example.demo.dto.PageWrapper;
import com.example.demo.entity.Client1Ste;
import com.example.demo.entity.Client2Ste;
import com.example.demo.entity.Client3Ste;
import com.example.demo.entity.Clientname;
import com.example.demo.entity.Data;
import com.example.demo.entity.Datalist3;
import com.example.demo.entity.Listdata;
import com.example.demo.service.DataService;


@Controller
@SessionAttributes("keyword")
public class DataController {
	@Autowired
	DataService dataService;

	//日付
	@InitBinder("DataRequest")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "DateRequest.upDate",new CustomDateEditor(dateFormat,true));

		binder.setAllowedFields("dateRequest.orderDate","dateRequest.deliveryDesignatedDate","dateRequest.deliveryDate");

	}



	//一覧表示
	@RequestMapping (value = "/list",method = RequestMethod.GET)
	public String topPage(DataRequest dataRequest,@PageableDefault(size=10)Pageable pageable,Model model) {

		//キーワード
		DataRequest word =new DataRequest();
		String key=word.setKeyword(dataRequest.getKeyword());

		//3テーブル結合

		//List<Datalist3> test=dataService.getTestlist();

		//一覧
		//Page<Listdata> listde;getfindAlldataA(pageable);
		Page<Datalist3> listde;

		if(key==null) {
			listde =dataService.getTestlist(pageable);

		}
		else {
			listde =dataService.getSearchlist(dataRequest,pageable);
		}

		//ページング
		//PageWrapper<Listdata> page = new PageWrapper<Listdata>(listde, "/list");
		PageWrapper<Datalist3> page = new PageWrapper<Datalist3>(listde, "/list");

		//顧客選択
		List<Clientname> clientdd =dataService.getclientselect();

		//ステータス
		List<Client1Ste> ste1 =dataService.getclientSte1();
		List<Client2Ste> ste2 =dataService.getclientSte2();
		List<Client3Ste> ste3 =dataService.getclientSte3();

		model.addAttribute("test",listde);
		model.addAttribute("page",page);
		model.addAttribute("words",page.getContent());
		model.addAttribute("keyword", key);
		model.addAttribute("clientdd",clientdd);
		model.addAttribute("ste1",ste1);
		model.addAttribute("ste2",ste2);
		model.addAttribute("ste3",ste3);

		//model.addAttribute("test",test);

		return "/list";

	}

	//住所検索
	@RequestMapping(value ="/{keyword}/list" ,method = RequestMethod.POST)
		public String search(@ModelAttribute DataRequest dataRequest,@Validated Listdata listdata,BindingResult result, Model model,@PageableDefault(size=10)Pageable pageable ) {

			DataRequest word =new DataRequest();
			String keyword=word.setKeyword(dataRequest.getKeyword());

			//Page<Listdata> seachpage=null;

			//if(keyword.isEmpty()) {
			//	seachpage=dataService.getfindAlldataA(pageable);
			//}
			//else {
				//seachpage = dataService.getsearchword(dataRequest,pageable);
			//}

			Page<Datalist3> listde;

			if(keyword==null) {
				listde =dataService.getTestlist(pageable);

			}
			else {
				listde =dataService.getSearchlist(dataRequest,pageable);
			}


			//PageWrapper<Listdata> page = new PageWrapper<Listdata>(seachpage, "/user/list");
			PageWrapper<Datalist3> page = new PageWrapper<Datalist3>(listde, "/list");

			model.addAttribute("test",listde );
			model.addAttribute("keyword",keyword );
			model.addAttribute("page", page);
			model.addAttribute("words",page.getContent());

			return "/list";
		}

	//登録ページ
	@GetMapping(value = "/add")
	public String displayAdd(DataRequest form,Model model) {
		//顧客選択
		List<Clientname> clientdd =dataService.getclientselect();

		//ステータス
		List<Client1Ste> ste1 =dataService.getclientSte1();
		List<Client2Ste> ste2 =dataService.getclientSte2();
		List<Client3Ste> ste3 =dataService.getclientSte3();


		model.addAttribute("dataRequest", new DataRequest());
		model.addAttribute("clientdd",clientdd);
		model.addAttribute("ste1",ste1);
		model.addAttribute("ste2",ste2);
		model.addAttribute("ste3",ste3);

		return "/add";

	}

	//登録エラー出力 (使ってない)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@Validated@ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			//顧客選択
			List<Clientname> clientdd =dataService.getclientselect();

			//ステータス
			List<Client1Ste> ste1 =dataService.getclientSte1();
			List<Client2Ste> ste2 =dataService.getclientSte2();
			List<Client3Ste> ste3 =dataService.getclientSte3();

			model.addAttribute("clientdd",clientdd);
			model.addAttribute("ste1",ste1);
			model.addAttribute("ste2",ste2);
			model.addAttribute("ste3",ste3);
			model.addAttribute("validationError", errorList);
			return "/add";
		}

		// dataService.create(dataRequest); 使ってない
		return "/addcheck";
	}

	//登録確認ページ
	@RequestMapping(value="/addCheck" ,method=RequestMethod.POST)
	public String addCheck(@Validated@ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {

		Date orderDate=dataRequest.getOrderDate();

		if(orderDate==null) {
			dataRequest.setOrderDate(null);
		}

		int nameid=dataRequest.getNameid();

		//入力確認
		if (result.hasErrors()||nameid==0) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}

			String nameidms=null;
			if(nameid==0) {
				nameidms="顧客名を選択してください";
			}
			//顧客選択
			List<Clientname> clientdd =dataService.getclientselect();

			//ステータス
			List<Client1Ste> ste1 =dataService.getclientSte1();
			List<Client2Ste> ste2 =dataService.getclientSte2();
			List<Client3Ste> ste3 =dataService.getclientSte3();

			model.addAttribute("clientdd",clientdd);
			model.addAttribute("ste1",ste1);
			model.addAttribute("ste2",ste2);
			model.addAttribute("ste3",ste3);
			model.addAttribute("validationError", errorList);
			model.addAttribute("nameidms",nameidms);
			return "/add";
		}

		//顧客名取得
		//int nameid=dataRequest.getNameid();
		Clientname clientname=dataService.findByIdA(nameid);


		//ステータス名取得
		Client1Ste select1 =null;
		Client2Ste select2 =null;
		Client3Ste select3 =null;

		int clientid=dataRequest.getNameid();
		int statusid =dataRequest.getStatusid();

		if(clientid==1) {
			select1=dataService.findById1(statusid);
		}
		else if(clientid==2) {
			select2=dataService.findById2(statusid);
		}else {
			select3=dataService.findById3(statusid);
		}

		model.addAttribute("DataRequest",  dataRequest);
		model.addAttribute("clientname",clientname);
		model.addAttribute("sta1",select1);
		model.addAttribute("sta2",select2);
		model.addAttribute("sta3",select3);


		return "/addCheck";
	}

	//登録完了
	@RequestMapping(value = "/creat", method = RequestMethod.POST)
	public String creat(@ModelAttribute DataRequest dataRequest, Model model) {

		dataService.creat(dataRequest);
		return "redirect:/list";
	}

//-----------------------------------------------------------------------------------------------

	//編集ページ
		@RequestMapping("/{id}/edit")
		public String displayEdit(@PathVariable("id") int id,@ModelAttribute DataRequest dataRequest,Model model,DataRequest form) {
			Data user =dataService.findById(id);

			//顧客名
			String client  = dataRequest.getClient();

			//ステータス
			List<Client1Ste> ste1 =dataService.getclientSte1();
			List<Client2Ste> ste2 =dataService.getclientSte2();
			List<Client3Ste> ste3 =dataService.getclientSte3();

			model.addAttribute("dataRequest",user);
			model.addAttribute("client",client);
			model.addAttribute("ste1",ste1);
			model.addAttribute("ste2",ste2);
			model.addAttribute("ste3",ste3);

			return "/edit";
		}

	//編集エラー出力(ここ使ってない)
	@RequestMapping(value="/{id}/createe",method=RequestMethod.POST)
	public String createe(@ModelAttribute DataRequest dataRequest,BindingResult result,@PathVariable int id,Model model) {

			if(result.hasErrors()) {
				List<String>errorList=new ArrayList<String>();
				for(ObjectError error:result.getAllErrors()) {
					errorList.add(error.getDefaultMessage());
				}

			model.addAttribute("validationError",errorList);
				return "/edit";
			}
			//dataService.createe(dataRequest);

			model.addAttribute("dataRequest",dataRequest);

			return "/editCheck";
		}

	//編集確認ページ
	@RequestMapping(value="/{id}/editCheck",method=RequestMethod.POST)
	public String editCheck(@PathVariable int id,@Validated@ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {

		//入力確認
		if(result.hasErrors()) {
			List<String>errorList=new ArrayList<String>();
			for(ObjectError error:result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			//顧客名
			String client  = dataRequest.getClient();

			//ステータス
			List<Client1Ste> ste1 =dataService.getclientSte1();
			List<Client2Ste> ste2 =dataService.getclientSte2();
			List<Client3Ste> ste3 =dataService.getclientSte3();

			model.addAttribute("client",client);
			model.addAttribute("ste1",ste1);
			model.addAttribute("ste2",ste2);
			model.addAttribute("ste3",ste3);
			model.addAttribute("validationError",errorList);
			return "/edit";
		}

		//ステータス名取得
		Client1Ste select1 =null;
		Client2Ste select2 =null;
		Client3Ste select3 =null;
		int select4=0;

		int clientid=dataRequest.getNameid();
		int statusid =dataRequest.getStatusid();

		if(statusid==0) {
			select4=0;
		}
		else if(clientid==1) {
			select1=dataService.findById1(statusid);
		}
		else if(clientid==2) {
			select2=dataService.findById2(statusid);
		}
		else if(clientid==3){
			select3=dataService.findById3(statusid);
		}

		model.addAttribute("dataRequest",dataRequest);

		model.addAttribute("sta1",select1);
		model.addAttribute("sta2",select2);
		model.addAttribute("sta3",select3);

		return "/editCheck";
	}

	//更新
	@RequestMapping(value="/creatt",method=RequestMethod.POST)
	public String creatt(@Validated @ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {
		dataService.creatt(dataRequest);
		return String.format("redirect:/list");
	}

//-----------------------------------------------------------------------------------------

	//削除ページ
	@RequestMapping("/{id}/delete")
	public String disdelete(@PathVariable("id") int id,@ModelAttribute DataRequest dataRequest,Model model) {
		Data user =dataService.findById(id);

		//顧客名
		String client  = dataRequest.getClient();

		model.addAttribute("dataRequest",user);
		model.addAttribute("client",client);
		return "/delete";
	}

	//更新
	@RequestMapping(value="/datadelete",method=RequestMethod.POST)
	public String datadelete(@Validated @ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {
		dataService.creattt(dataRequest);
		return String.format("redirect:/list");
	}

}
