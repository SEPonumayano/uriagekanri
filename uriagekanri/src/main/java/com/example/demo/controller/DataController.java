package com.example.demo.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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


	@RequestMapping (value = "/list",method = RequestMethod.GET)
	public String topPage(Model model) {

		return "/list";

	}

	//登録ページ
	@GetMapping(value = "/add")
	public String displayAdd(DataRequest form,Model model) {

		model.addAttribute("dataRequest", new DataRequest());
		model.addAttribute("selectItems",SELECT_ITEMS);
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

}
