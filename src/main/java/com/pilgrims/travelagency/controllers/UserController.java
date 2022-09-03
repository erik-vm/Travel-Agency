package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle all user related requests
 *
 * @author Ott Pikk
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public String showAllUserPage(Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/list-user";
    }

}
