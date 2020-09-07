package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

		List<Datalist3> test=dataService.getTestlist();

		//一覧
		Page<Listdata> listde;

		if(key==null) {
			listde =dataService.getfindAlldataA(pageable);

		}
		else {
			listde =dataService.getsearchword(dataRequest,pageable);
		}

		//ページング
		PageWrapper<Listdata> page = new PageWrapper<Listdata>(listde, "/list");

		//顧客選択
		List<Clientname> clientdd =dataService.getclientselect();

		//ステータス
		List<Client1Ste> ste1 =dataService.getclientSte1();
		List<Client2Ste> ste2 =dataService.getclientSte2();
		List<Client3Ste> ste3 =dataService.getclientSte3();

		model.addAttribute("userlist",listde);
		model.addAttribute("page",page);
		model.addAttribute("words",page.getContent());
		model.addAttribute("keyword", key);
		model.addAttribute("clientdd",clientdd);
		model.addAttribute("ste1",ste1);
		model.addAttribute("ste2",ste2);
		model.addAttribute("ste3",ste3);

		model.addAttribute("test",test);

		return "/list";

	}

	//住所検索
	@RequestMapping(value ="/{keyword}/list" ,method = RequestMethod.POST)
		public String search(@ModelAttribute DataRequest dataRequest,@Validated Listdata listdata,BindingResult result, Model model,@PageableDefault(size=10)Pageable pageable ) {

			DataRequest word =new DataRequest();
			String keyword=word.setKeyword(dataRequest.getKeyword());

			Page<Listdata> seachpage=null;

			if(keyword.isEmpty()) {
				seachpage=dataService.getfindAlldataA(pageable);
			}
			else {
				seachpage = dataService.getsearchword(dataRequest,pageable);
			}


			PageWrapper<Listdata> page = new PageWrapper<Listdata>(seachpage, "/user/list");

			model.addAttribute("userlist",seachpage );
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

	//登録エラー出力
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {

		dataService.create(dataRequest);
		return "/addcheck";
	}

	//登録確認ページ
	@RequestMapping(value="/addCheck" ,method=RequestMethod.POST)
	public String addCheck(@ModelAttribute DataRequest dataRequest, Model model) {

		//登録確認、顧客名
		//Long nameid= dataRequest.getNameid();
		//List<Clientname> selectclient=dataService.getclientselectname(dataRequest);


		model.addAttribute("DataRequest",  dataRequest);
		//model.addAttribute("selectclient",selectclient);

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
		public String displayEdit(@PathVariable("id") Long id,@ModelAttribute DataRequest dataRequest,Model model,DataRequest form) {
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

	//編集エラー出力
	@RequestMapping(value="/{id}/createe",method=RequestMethod.POST)
	public String createe(@ModelAttribute DataRequest dataRequest,BindingResult result,@PathVariable Long id,Model model) {

			//if(result.hasErrors()) {
				//List<String>errorList=new ArrayList<String>();
				//for(ObjectError error:result.getAllErrors()) {
					//errorList.add(error.getDefaultMessage());
				//}

			//model.addAttribute("validationError",errorList);
		    //			return "/edit";
		//	}
			dataService.createe(dataRequest);
			return "/editCheck";
		}

	//編集確認ページ
	@RequestMapping(value="/{id}/editCheck",method=RequestMethod.POST)
	public String editCheck(@PathVariable Long id,@ModelAttribute DataRequest dataRequest,Model model) {
		model.addAttribute("dataRequest",dataRequest);
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
	public String disdelete(@PathVariable("id") Long id,@ModelAttribute DataRequest dataRequest,Model model) {
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
