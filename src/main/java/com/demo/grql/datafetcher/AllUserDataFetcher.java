package com.demo.grql.datafetcher;

import com.demo.grql.model.User;
import com.demo.grql.repo.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AllUserDataFetcher implements DataFetcher<List<User>> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        return userRepository.findAll();
    }
}
