package com.demo.grql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.grql.model.User;
import com.demo.grql.repo.UserRepository;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private UserRepository userRepository;

    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
