package com.nutfreedom.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentModel {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private List<String> operatingSystem = new ArrayList<>();
}
