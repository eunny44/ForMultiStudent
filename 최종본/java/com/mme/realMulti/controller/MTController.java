package com.mme.realMulti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mme.realMulti.dto.MT;
import com.mme.realMulti.service.MTService;

@Controller
public class MTController {
	@Autowired
	MTService mtService;
	
	//200411
	//mt신청.
	@PostMapping(path="/applyMT")
	public String applyMT(@ModelAttribute MT mt, HttpSession session) {
		mtService.addMT(mt);

		return "redirect:/mt";
	}
}