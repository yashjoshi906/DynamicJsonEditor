package com.dynamic_json_editor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic_json_editor.dto.JsonModelDTO;
import com.dynamic_json_editor.service.JsonLogsServiceImpl;

@RestController
public class JsonLogsController {

	@Autowired
	JsonLogsServiceImpl jsonLogsServiceImpl;

	@GetMapping("/edit/{val1}")
	public ResponseEntity<JsonModelDTO> editJsonUsingGet(@PathVariable("val1") String val1) {

		return new ResponseEntity<JsonModelDTO>(jsonLogsServiceImpl.updateJsonModel(val1), HttpStatus.OK);
	}
	
	
	@PostMapping("/edit")
	public ResponseEntity<JsonModelDTO> editJsonUsingPost(@RequestBody String val2) {

		return new ResponseEntity<JsonModelDTO>(jsonLogsServiceImpl.updateJsonModel(val2), HttpStatus.OK);
	}

}
