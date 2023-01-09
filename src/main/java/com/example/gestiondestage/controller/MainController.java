package com.example.gestiondestage.controller;

import com.example.gestiondestage.services.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessorService professorService;

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

    @RequestMapping(value = "/entreprise", method = {POST, GET})
    public String entreprise(Model model){
        model.addAttribute("entrepriseList", companyService.getAllCompanies());
        return "entreprise";
    }
}
