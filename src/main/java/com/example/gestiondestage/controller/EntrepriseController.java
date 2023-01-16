package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IInternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IInternshipService internshipService;
    @RequestMapping(value = "/listEntreprise", method = {POST, GET})
    public String listEntreprise(Model model){
        model.addAttribute("entrepriseList", companyService.getAllCompanies());
        return "entreprise";
    }

    @RequestMapping(value = "/voirEntreprise", method = GET)
    public String voirEntreprise(Model model, @RequestParam int id){
        model.addAttribute("entreprise", companyService.getCompanyById(id));
        model.addAttribute("stages", internshipService.getAllInternshipFromCompanyId(id));
        model.addAttribute("student", internshipService.getStudentNameForAnInternshipFromCompanyId(id));
        return "voirEntreprise";
    }

    @RequestMapping(value = "/data", method = GET)
    public ResponseEntity<HashMap<String, Iterable<EntrepriseEntity>>> dataList() {
        return ResponseEntity.ok().body(new HashMap<>(){{put("data", companyService.getAllCompanies());}});
    }
}
