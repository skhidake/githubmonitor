package com.ssk.git.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssk.git.monitor.exception.RecordNotFoundException;
import com.ssk.git.monitor.model.Event;

@RestController
public class GithubController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(path = "/{owner}/{repo}/events", method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public Event[] getEvent(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
		try {
			ResponseEntity<Event[]> response = restTemplate
					.getForEntity("https://api.github.com/repos/" + owner + "/" + repo + "/events", Event[].class);

			return response.getBody();

		} catch (Exception e) {
			throw new RecordNotFoundException("Incorrect input...");
		}
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RecordNotFoundException ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.BAD_REQUEST);
	}
}
