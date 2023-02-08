package com.example.gestiondestage.controller;

import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IProfessorService;
import com.example.gestiondestage.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    public String index(final Model model) {
        return "index";
    }

    @RequestMapping(value = "/inscription", method = {POST, GET})
    public String inscription(final Model model, @RequestParam final Optional<String> companyName) {
        model.addAttribute("companyName", companyName.orElseGet(() -> "null"));
        model.addAttribute("entrepriseList", companyService.getCompaniesNames());
        model.addAttribute("etudiantList", studentService.getStudentsNames());
        model.addAttribute("professeursList", professorService.getProfessorsNames());
        return "inscription";
    }
}
