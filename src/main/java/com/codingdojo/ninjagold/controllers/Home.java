package com.codingdojo.ninjagold.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		if (session.getAttribute("messages") == null) {
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);	
		}
		model.addAttribute("messages", session.getAttribute("gold"));
		model.addAttribute("messages", session.getAttribute("messages"));
		
		return "index.jsp";
	}
		
	
	@PostMapping("/process")
	public String process(HttpSession session, @RequestParam(value= "building", required = false) String building, Model model) {
		Date date = new Date();
		System.out.println(building);
		String location = building;
		int gold_earned= 0;
		int gold_stored = 0;
		String message;
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		
		if (location.equals("farm")) {
			int num; 
			Random randomGenerator = new Random();
			num = randomGenerator.nextInt(21-10) + 10;
			gold_earned = num ;
		}
		else if (location.equals("cave")) {
			int num; 
			Random randomGenerator = new Random();
			num = randomGenerator.nextInt(11-5) + 5;
			gold_earned = num;
		}
		else if (location.equals("house")) {
			int num; 
			Random randomGenerator = new Random();
			num = randomGenerator.nextInt(6-2) + 2;
			gold_earned = num;
		}
		else if (location.equals("casino")) {
			int num; 
			Random randomGenerator = new Random();
			num = randomGenerator.nextInt(50-(-50)) + (-50);
			gold_earned = num;
		}
		
		gold_stored += gold_earned;
		session.setAttribute("gold", gold_stored);
		gold_earned = (int)session.getAttribute("gold");
		
		if (gold_earned >= 0) {
			message = String.format("Went to %s and got %d gold. (%s)", location, gold_earned, date.toString()); 
		}
		else {
			message = String.format("Went to casino and lost %d gold...Ouch! (%s)", gold_earned, date.toString()); 

		}
		
		messages.add(message);
		session.setAttribute("gold", gold_earned);
		session.setAttribute("messages", messages);
		
//		if (message.contains("lost")) {
//			String loser = message;
//			System.out.println(loser);
//		}
//		else {
//			String winner = message;
//			System.out.println(winner);
//		}
		return "redirect:/";

	}
	
}
