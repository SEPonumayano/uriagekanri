package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.DataRequest;

@Controller
public class DataController {
	//@Autowired
	//Service userService;

	@RequestMapping (value = "/list",method = RequestMethod.GET)
	public String topPage(Model model) {

		return "/list";

	}

	//登録ページ
	@GetMapping(value = "/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new DataRequest());
		return "/add";

	}

}
