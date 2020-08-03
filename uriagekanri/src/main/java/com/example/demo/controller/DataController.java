package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.DataRequest;
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

	@RequestMapping (value = "/list",method = RequestMethod.GET)
	public String topPage(Model model) {

		return "/list";

	}

	//登録ページ
	@GetMapping(value = "/add")
	public String displayAdd(DataRequest form,Model model) {

		model.addAttribute("dataRequest", new DataRequest());
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
		//Date order=dataRequest.getOrderDate();

		model.addAttribute("DataRequest",  dataRequest);
		//model.addAttribute("order",  order);

		return "/addCheck";
	}

	//登録完了
	@RequestMapping(value = "/creat", method = RequestMethod.POST)
	public String creat(@ModelAttribute DataRequest dataRequest, Model model) {

		dataService.creat(dataRequest);
		return "redirect:/list";
	}

}
