package com.example.LoginPage.Controller;

import com.example.LoginPage.Entity.User;
import org.springframework.ui.Model;
import com.example.LoginPage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String LoginPage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                       Model model) {

        User user = userService.login(username, password);

        if(user != null){
            model.addAttribute("username", username);
            return "home";
        }
        else{
            model.addAttribute("error", "Invalid User or Password");
            return "login";
        }

    }

}
