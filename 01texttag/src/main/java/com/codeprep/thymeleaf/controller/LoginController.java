package com.codeprep.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView homePage(){
        return new ModelAndView("home", Map.of("username", "user1"));
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile(){
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Mr");
        model.put("firstName", "UserFN");
        model.put("surName", "UserLN");
        model.put("dateOfBirth", new GregorianCalendar(2020, 12, 7).getTime());
        model.put("description", "a <strong> fantastic </strong> Java Programmer");
        return new ModelAndView("profile", "model", model);
    }
}
