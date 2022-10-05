package com.groupsix.documentarchive.Controller;

import com.groupsix.documentarchive.Model.User;
import com.groupsix.documentarchive.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String RegisterUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "registrationForm";
    }

    @PostMapping("/CreateUser")
    public String createUser(User user) {
        userService.addUser(user);
        return "AutoRedirect";
    }

    @GetMapping("/redirect")
    public String Redirect() {
        return "AutoRedirect";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/success")
    public String successPage() {
        return "Success";
    }
}
