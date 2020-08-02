package com.note.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	//主页
	@GetMapping({"","/home"})
	public String home(){
		return "home/index";
	}



}
