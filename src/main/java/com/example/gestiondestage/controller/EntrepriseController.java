package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.entities.SpecialiteEntity;
import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IInternshipService;
import com.example.gestiondestage.services.ISpecialityService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IInternshipService internshipService;

    @Autowired
    private ISpecialityService specialityService;
    @RequestMapping(value = "/listEntreprise", method = {POST, GET})
    public String listEntreprise(Model model){
        return "entreprise";
    }

    @RequestMapping(value = "/voirEntreprise", method = GET)
    public String voirEntreprise(Model model, @RequestParam int id){
        model.addAttribute("entreprise", companyService.getCompanyById(id));
        model.addAttribute("stages", internshipService.getAllInternshipFromCompanyId(id));
        model.addAttribute("student", internshipService.getStudentNameForAnInternshipFromCompanyId(id));
        return "voirEntreprise";
    }

    @RequestMapping(value = "/supprimerEntreprise")
    public String supprimerEntreprise(@RequestParam int id){
        companyService.removeCompanyById(id);
        return "entreprise";
    }

    @RequestMapping(value = "/modifierEntreprise")
    public String modifierEntreprise(Model model, @RequestParam int id){
        model.addAttribute("entreprise", companyService.getCompanyById(id));
        model.addAttribute("specialitesList", specialityService.getAllSpeciality());
        model.addAttribute("modification", true);
        return "modifierEntreprise";
    }

    @RequestMapping(value = "/postModification", method = POST)
    public String postModif(HttpServletRequest request){
        companyService.updateCompany(parseParam(request));
        return "entreprise";
    }

    private EntrepriseEntity parseParam(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        Set<SpecialiteEntity> selectedSpec = new HashSet<>();
        specialityService.getAllSpeciality().forEach(spec -> {
            if(stream(params.get("specialite")).anyMatch(s -> s.equals(spec.getLibelle()))){
                selectedSpec.add(spec);
            }
        });
        return new EntrepriseEntity(parseInt(getParam(params, "id")), getParam(params, "nom_entreprise"), getParam(params, "nom_contact"), getParam(params, "nom_resp"), getParam(params, "rue"),
                parseInt(getParam(params, "cp")), getParam(params, "ville"), getParam(params, "tel"), getParam(params, "fax"), getParam(params, "email"), getParam(params, "observation"),
        getParam(params, "site"), getParam(params, "niveau"), (byte) 1, (Set<SpecialiteEntity>) selectedSpec);
    }

    private static String getParam(Map<String, String[]> params, String paramName) {
        return params.containsKey(paramName) ? params.get(paramName)[0] : "";
    }

    @RequestMapping(value = "/data", method = GET)
    public ResponseEntity<HashMap<String, Iterable<EntrepriseEntity>>> dataList() {
        return ResponseEntity.ok().body(new HashMap<>(){{put("data", companyService.getAllCompanies());}});
    }
}
