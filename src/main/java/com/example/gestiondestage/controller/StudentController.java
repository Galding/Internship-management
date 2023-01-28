package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IInternshipService;
import com.example.gestiondestage.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IInternshipService internshipService;

    @Autowired
    ICompanyService companyService;

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

    @RequestMapping(value = "/data", method = GET)
    public ResponseEntity<HashMap<String, Iterable<EtudiantEntity>>> dataList() {
        return ResponseEntity.ok().body(new HashMap<>() {{
            put("data", studentService.getAllStudents());
        }});
    }
}
