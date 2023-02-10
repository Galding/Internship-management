package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.entities.SpecialiteEntity;
import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IInternshipService;
import com.example.gestiondestage.services.ISpecialityService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.gestiondestage.Utils.getParamFromParameterMap;
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
    public String listEntreprise(final Model model, final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            return "redirect:/index";
        }
        model.addAttribute("currentUserRole", session.getAttribute("role"));
        return "entreprise";
    }

    @RequestMapping(value = "/voirEntreprise", method = GET)
    public String voirEntreprise(final Model model, @RequestParam final int id) {
        model.addAttribute("entreprise", companyService.getCompanyById(id));
        model.addAttribute("stages", internshipService.getAllInternshipFromCompanyId(id));
        model.addAttribute("student", internshipService.getStudentNameForAnInternshipFromCompanyId(id));
        return "voirEntreprise";
    }

    @RequestMapping(value = "/supprimerEntreprise")
    public String supprimerEntreprise(@RequestParam final int id) {
        companyService.removeCompanyById(id);
        return "entreprise";
    }

    @RequestMapping(value = "/modifierEntreprise")
    public String modifierEntreprise(final Model model, @RequestParam final int id) {
        model.addAttribute("entreprise", companyService.getCompanyById(id));
        model.addAttribute("specialitesList", specialityService.getAllSpeciality());
        model.addAttribute("modification", true);
        return "modifierEntreprise";
    }

    @RequestMapping(value = "/postModification", method = POST)
    public String postModif(final HttpServletRequest request) {
        companyService.updateCompany(parseParam(request));
        return "entreprise";
    }

    @RequestMapping(value = "/ajoutEntreprise")
    public String ajoutEntreprise(final Model model) {
        model.addAttribute("specialitesList", specialityService.getAllSpeciality());
        model.addAttribute("modification", false);
        return "modifierEntreprise";
    }

    @RequestMapping(value = "/postAjouter", method = POST)
    public String postAjouter(final HttpServletRequest request) {
        companyService.addCompany(parseParam(request));
        return "entreprise";
    }

    private EntrepriseEntity parseParam(final HttpServletRequest request) {
        final Map<String, String[]> params = request.getParameterMap();
        final Set<SpecialiteEntity> selectedSpec = new HashSet<>();
        specialityService.getAllSpeciality().forEach(spec -> {
            final String[] specialites = params.get("specialite");
            if (specialites != null && stream(specialites).anyMatch(s -> s.equals(spec.getLibelle()))) {
                selectedSpec.add(spec);
            }
        });
        final int id = Stream.of(getParamFromParameterMap(params, "id")).filter(str -> !str.equals("")).map(Integer::parseInt).findFirst().orElse(companyService.getLastAvailableId());
        return new EntrepriseEntity(id, getParamFromParameterMap(params, "raison_sociale"), getParamFromParameterMap(params, "nom_contact"), getParamFromParameterMap(params, "nom_resp"), getParamFromParameterMap(params, "rue"),
                parseInt(getParamFromParameterMap(params, "cp")), getParamFromParameterMap(params, "ville"), getParamFromParameterMap(params, "tel"), getParamFromParameterMap(params, "fax"), getParamFromParameterMap(params, "email"), getParamFromParameterMap(params, "observation"),
                getParamFromParameterMap(params, "site"), getParamFromParameterMap(params, "niveau"), (byte) 1, selectedSpec);
    }


    @RequestMapping(value = "/data", method = GET)
    public ResponseEntity<HashMap<String, Iterable<EntrepriseEntity>>> dataList() {
        return ResponseEntity.ok().body(new HashMap<>() {{
            put("data", companyService.getAllCompanies());
        }});
    }
}
