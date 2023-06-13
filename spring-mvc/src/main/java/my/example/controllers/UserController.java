package my.example.controllers;

import my.example.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/register")
    public ModelAndView registerUser(@RequestParam("name") String name, @RequestParam("age") int age) {
        userService.registerUser(name, age);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registered");
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @GetMapping("/get-users")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("allUsers");
        modelAndView.addObject("users", userService.getAllUsers().toString());

        return modelAndView;
    }
}
