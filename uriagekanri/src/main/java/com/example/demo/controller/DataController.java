package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

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

import com.example.demo.dto.DataRequest;
import com.example.demo.dto.PageWrapper;
import com.example.demo.entity.Data;
import com.example.demo.service.DataService;


@Controller
public class DataController {
	@Autowired
	DataService dataService;

		final static Map<String,String> SELECT_ITEMS=Collections.unmodifiableMap(new LinkedHashMap<String, String>(){
			{
				put("1です","1");
				put("2です","2");
			}
		});

		final static Map<String,String> SELECT_ST=Collections.unmodifiableMap(new LinkedHashMap<String, String>(){
			{
				put("1です","1");
				put("2です","2");
			}
		});

	@InitBinder("DataRequest")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "DateRequest.upDate",new CustomDateEditor(dateFormat,true));

		binder.setAllowedFields("dateRequest.orderDate","dateRequest.deliveryDesignatedDate","dateRequest.deliveryDate");

	}

	//一覧表示
	@RequestMapping (value = "/list",method = RequestMethod.GET)
	public String topPage(@PageableDefault(size=10)Pageable pageable,Model model) {
		Page<Data> listde =dataService.getfindAlldataA(pageable);

		//ページング
		PageWrapper<Data> page = new PageWrapper<Data>(listde, "/list");

		model.addAttribute("userlist",listde);
		model.addAttribute("page",page);
		model.addAttribute("words",page.getContent());

		return "/list";

	}

	//登録ページ
	@GetMapping(value = "/add")
	public String displayAdd(DataRequest form,Model model) {
		//List<ClientSelect> client =dataService.getclientData();

		model.addAttribute("dataRequest", new DataRequest());
		//model.addAttribute("clientD",client);
		model.addAttribute("selectItems",SELECT_ITEMS);
		model.addAttribute("selectSt",SELECT_ST);
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

		model.addAttribute("DataRequest",  dataRequest);

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
		public String displayEdit(@PathVariable("id") Long id,Model model,DataRequest form) {
			Data user =dataService.findById(id);

			model.addAttribute("dataRequest",user);
			model.addAttribute("selectSt",SELECT_ST);
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
	public String disdelete(@PathVariable("id") Long id,Model model) {
		Data user =dataService.findById(id);

		model.addAttribute("dataRequest",user);
		return "/delete";
	}

	//更新
	@RequestMapping(value="/datadelete",method=RequestMethod.POST)
	public String datadelete(@Validated @ModelAttribute DataRequest dataRequest,BindingResult result,Model model) {
		dataService.creattt(dataRequest);
		return String.format("redirect:/list");
	}

}
