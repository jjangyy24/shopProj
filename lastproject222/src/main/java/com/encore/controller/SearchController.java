package com.encore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.encore.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService service;
	
	@RequestMapping("/search_getList")
	public String search_getList(@RequestParam ("searchword") String word, Model model) {
		
		model.addAttribute("prodlist", service.searchProd(word).size()==0?null:service.searchProd(word));
		model.addAttribute("storelist", service.searchStore(word).size()==0?null:service.searchStore(word));
		
		return "search_getList";
	}
}
