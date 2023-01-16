package com.example.gestiondestage.controller;

import com.example.gestiondestage.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IProfessorService professorService;

    @RequestMapping(value = {"/index", "/"}, method = GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/inscription", method = {POST, GET})
    public String inscription(Model model){
        model.addAttribute("entrepriseList", companyService.getCompaniesNames());
        model.addAttribute("etudiantList", studentService.getStudentsNames());
        model.addAttribute("professeursList", professorService.getProfessorsNames());
        return "inscription";
    }
}
