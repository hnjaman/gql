package com.demo.grql.controller;



import com.demo.grql.datafetcher.AllUserDataFetcher;
import com.demo.grql.datafetcher.SaveUser;
import com.demo.grql.datafetcher.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import graphql.ExecutionResult;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;


@RestController
public class UserController {
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Value("classpath:user.graphqls")
	private Resource schemaResourse;
	private GraphQL graphQL;

	@Autowired
	private AllUserDataFetcher getUsers;
	@Autowired
	private UserDataFetcher getUser;
	@Autowired
	private SaveUser saveUser;

	@PostConstruct
	public void loadSchema() throws IOException{
		File schemaFile = schemaResourse.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);     // parse schema
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("users", getUsers)
						.dataFetcher("user", getUser)
						.dataFetcher("createUser", saveUser )
				).build();
	}

	@GetMapping(value = "/graphql-users")
	public ResponseEntity<Object> getGraphQlUsers(@RequestBody String userQuery){
		ExecutionResult result = graphQL.execute(userQuery);
		LOGGER.info(String.valueOf(result.getErrors()));
		return ResponseEntity.ok(result.getData());
	}
}
