package com.nutfreedom.controller;

import com.nutfreedom.model.StudentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        StudentModel studentModel = new StudentModel();
        model.addAttribute("student", studentModel);
        LinkedHashMap<String, String> listCountry = new LinkedHashMap<>();
        listCountry.put("Brazil", "Brazil");
        listCountry.put("France", "France");
        listCountry.put("Germany", "Germany");
        listCountry.put("India", "India");
        model.addAttribute("listCountry", listCountry);

        LinkedHashMap<String, String> listLanguage = new LinkedHashMap<>();
        listLanguage.put("java", "Java");
        listLanguage.put("php", "PHP");
        listLanguage.put("ruby", "Ruby");
        model.addAttribute("listLanguage", listLanguage);

        LinkedHashMap<String, String> listOperatingSystem = new LinkedHashMap<>();
        listOperatingSystem.put("Linux", "Linux");
        listOperatingSystem.put("Mac OS", "Mac OS");
        listOperatingSystem.put("Ms Window", "Ms Window");
        model.addAttribute("listOperatingSystem", listOperatingSystem);

        return "student-form";
    }

    @GetMapping("/process-form")
    public String processForm(@ModelAttribute StudentModel studentModel) {
        log.info("First name: " + studentModel.getFirstName() +
            "\nLast name: " + studentModel.getLastName() +
            "\nCountry: " + studentModel.getCountry());
        return "student-confirmation";
    }
}