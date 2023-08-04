package com.example.users.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGateway userGateway;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse findUserById(int id) {
        Optional<TableUser> result = userRepository.findById(id);
//        Optional<UserResponse> result = userGateway.getUserById(id);
        if (result.isPresent()) {
            UserResponse userResponse = new UserResponse(result.get().getId(), result.get().getName(), result.get().getEmail());
            return userResponse;
        }else{
            throw new UserNotFoundException("User not found with id=" + id);
        }
    }
}
