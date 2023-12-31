package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public void deleteUser(long userId){

        userRepository.deleteById(userId);
    }

    public User updateUser(User user){
        if (user == null && !userRepository.existsById(user.getId())) {
            return null;
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id){

        return userRepository.findById(id).orElse(null);
    }
}