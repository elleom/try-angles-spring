package com.martins.leonardo.triangles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String displayError(){
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
