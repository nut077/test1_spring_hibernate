package com.nutfreedom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloWorldController {

    @GetMapping("/show-form")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/process-form")
    public String procesForm(Model model, String studentName) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        model.addAttribute("studentName", studentName);
        model.addAttribute("list", list);
        return "helloworld";
    }
}
