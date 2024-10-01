package syksyy.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import syksyy.kirjakauppa.domain.UserRepository;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}