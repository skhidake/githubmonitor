package com.ssk.git.monitor.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.ssk.git.monitor.model.Event;


@Controller
public class GithubWebController {
	
	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping(path="/view/{owner}/{repo}/events")
	
	public String getEvent(ModelMap model, @PathVariable("owner") String owner,@PathVariable("repo") String repo ){
		
		ResponseEntity<Event[]> response=restTemplate.getForEntity("https://api.github.com/repos/"+owner+"/"+repo+"/events", Event[].class);
		model.put("list", response.getBody());
		model.addAttribute("owner", owner);
		model.addAttribute("repo", repo);
		model.addAttribute("mydate", LocalDateTime.now());
		
		return "events";
	}

}
