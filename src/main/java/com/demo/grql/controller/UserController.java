package com.demo.grql.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.grql.service.EmployeeService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	EmployeeService service;
	@PostMapping("/getemp")
	public ResponseEntity<Object> getEmployeeConfigs(@RequestBody String empReqst)
	{	//System.out.println(service.getAllEmployees().get(0).getAddress().getCountry());
		 ExecutionResult execute= service.getGraphQL().execute(empReqst);
		 return new ResponseEntity<>(execute, HttpStatus.OK);
	}
	
}
