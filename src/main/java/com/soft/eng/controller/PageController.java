package com.soft.eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){

        return "home";
    }


    @RequestMapping("/")
    public String ott(){

        return "home";
    }

    @RequestMapping("/ott/ott/sent")
    public String ottSentSuccessMessage(){

        return "ott-sent";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Principal principal, Model model){

        model.addAttribute("user", principal.getName());

        return "dashboard";
    }

}
