package com.app.cruduser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/user-list")
    public String getUserListPage() {
        return "user-list";
    }

    @GetMapping("/user-form")
    public String getUserFormPage() {
        return "user-form";
    }
}
