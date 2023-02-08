package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.services.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.example.gestiondestage.Utils.getParamFromParameterMap;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IInternshipService internshipService;

    @Autowired
    ICompanyService companyService;

    @Autowired
    IProfessorService professorService;

    @Autowired
    IClasseService classeService;

    @RequestMapping("/studentList")
    public String studentList() {
        return "etudiant";
    }

    @RequestMapping(value = "/voirEtudiant", method = GET)
    public String viewStudent(final Model model, @RequestParam final int id) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("internship", internshipService.getInternshipFromStudendId(id));
        model.addAttribute("company", companyService.getCompanyFromStudentId(id));
        return "VoirEtudiant";
    }

    @RequestMapping(value = "/supprimerEtudiant")
    public String supprimerEtudiant(final Model model, @RequestParam final int id) {
        studentService.removeStudent(id);
        return "etudiant";
    }

    @RequestMapping(value = "/modifierEtudiant")
    public String modifierEtudiant(final Model model, @RequestParam final int id) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("classes", classeService.getAllClasses());
        model.addAttribute("modification", true);
        return "modifierEtudiant";
    }

    @RequestMapping(value = "/postModification", method = POST)
    public String postModifier(final HttpServletRequest request) {
        studentService.updateStudent(parseParam(request));
        return "etudiant";
    }

    @RequestMapping(value = "/ajouterEtudiant")
    public String ajouterEtudiant(final Model model) {
        model.addAttribute("classes", classeService.getAllClasses());
        model.addAttribute("modification", false);
        return "modifierEtudiant";
    }

    @RequestMapping(value = "/postAjout", method = POST)
    public String postAjouter(final HttpServletRequest request) {
        studentService.addStudent(parseParam(request));
        return "etudiant";
    }

    private EtudiantEntity parseParam(final HttpServletRequest request) {
        final Map<String, String[]> params = request.getParameterMap();
        final int id = Stream.of(getParamFromParameterMap(params, "id")).filter(str -> !str.equals("")).map(Integer::parseInt).findFirst().orElse(studentService.getLastAvailableId());
        final Date anneeObtention = Stream.of(getParamFromParameterMap(params, "date_obtention")).filter(str -> !str.equals("")).map(Date::valueOf).findFirst().orElse(null);
        final int numClasse = Stream.of(getParamFromParameterMap(params, "classe")).filter(str -> !str.equals("")).map(Integer::parseInt).findFirst().orElse(0);
        return new EtudiantEntity(id, getParamFromParameterMap(params, "nom_etudiant"), getParamFromParameterMap(params, "prenom_etudiant"), anneeObtention,
                getParamFromParameterMap(params, "login"), getParamFromParameterMap(params, "mdp"), numClasse, (byte) 1, null);
    }

    //TODO : Ajouter les profs et les entreprises
    @RequestMapping(value = "/data", method = GET)
    public ResponseEntity<HashMap<String, Iterable<EtudiantEntity>>> dataList() {
        /*final Map<String, List<?>> data = new HashMap<>();
        data.put("students", studentService.getAllStudents());
        data.put("companies", companyService.getAllCompanies());
        data.put("teachers", professorService.getAllProfessors());*/
        return ResponseEntity.ok().body(new HashMap<>() {{
            put("data", studentService.getAllStudents());
        }});
    }


}
