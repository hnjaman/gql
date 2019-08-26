package com.demo.grql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.demo.grql.repo.UserRepository;

public class Mutation implements GraphQLMutationResolver {
    private UserRepository userRepository;

    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
