package com.demo.grql.service;

import java.util.List;

import com.demo.grql.model.User;
import com.demo.grql.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.demo.grql.model.Employee;
//import com.demo.grql.repo.EmployeeRepo;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class AllEmployeeDataFetcher implements DataFetcher<List<User>>{
//	@Autowired
//	EmployeeRepo repo;
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		return userRepository.findAll();
	}
}
