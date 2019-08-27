package com.demo.grql.datafetcher;

import com.demo.grql.model.User;
import com.demo.grql.repo.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class UserDataFetcher implements DataFetcher<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment env) {
        Map arguments = env.getArguments();
        return userRepository.getOne(Integer.valueOf((String) arguments.get("id")));
    }
}
