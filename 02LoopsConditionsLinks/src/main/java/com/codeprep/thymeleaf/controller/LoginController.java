package com.codeprep.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView homePage(){
        Map<String, Object> model = new HashMap<>();
        model.put("username","user1");
        model.put("id","10");
        return new ModelAndView("home", "model", model);
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile(){
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Mr");
        model.put("firstName", "UserFN");
        model.put("surName", "UserLN");
        model.put("dateOfBirth", new GregorianCalendar(2020, 12, 7).getTime());
        model.put("description", "a <strong> fantastic </strong> Java Programmer");
        model.put("languages", List.of("Java","JavaScript","Unix Shell Programming","Groovy"));
        return new ModelAndView("profile", "model", model);
    }
}
