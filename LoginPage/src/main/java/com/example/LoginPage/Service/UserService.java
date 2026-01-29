package com.example.LoginPage.Service;

import com.example.LoginPage.Entity.User;
import com.example.LoginPage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password)
    {
        return  userRepository.findByUsernameAndPassword(username,password);
    }
}
