package com.nutfreedom.controller;

import com.nutfreedom.model.CustomerModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    /* ใช้ @NotBlank แทนง่ายกว่า
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }*/

    @GetMapping("/show-form")
    public String showForm(CustomerModel customerModel) {
        return "customer-form";
    }

    @PostMapping("/process-form")
    public String processForm(
        @Valid @ModelAttribute CustomerModel customerModel,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }
}
