package com.example.gestiondestage.controller;

import com.example.gestiondestage.services.CompanyService;
import com.example.gestiondestage.services.CompanyServiceImpl;
import com.example.gestiondestage.services.StudentService;
import com.example.gestiondestage.services.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {


    @RequestMapping(value = {"/index", "/"}, method = GET)
    public String index(Model model){
        return "index";
    }


    @RequestMapping(value = "/inscription", method = POST)
    public String inscription(Model model){
        CompanyService companyService = new CompanyServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        model.addAttribute("entrepriseList", companyService.getCompaniesNames());
        model.addAttribute("etudiantList", studentService.getAllStudentsNames());
        return "inscription";
    }
}
