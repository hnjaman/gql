package com.demo.grql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.demo.grql.model.User;
import com.demo.grql.repo.UserRepository;

public class Mutation implements GraphQLMutationResolver {
    private UserRepository userRepository;
    public Mutation(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User createUser(String name, String userName, String email, String password){
        User user = new User(name,userName,email,password);
        return userRepository.save(user);
    }

}
