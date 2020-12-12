package com.codeprep.thymeleaf.controller;

import com.codeprep.thymeleaf.model.AddUserModel;
import com.codeprep.thymeleaf.validation.AddUserModelValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping("/addUser")
    public ModelAndView addUser() {
        return new ModelAndView("newUser", "addUserModel", new AddUserModel());
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid AddUserModel addUserModel, BindingResult bindingResult) {
        new AddUserModelValidator().validate(addUserModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        return "userAdded";
    }
}
