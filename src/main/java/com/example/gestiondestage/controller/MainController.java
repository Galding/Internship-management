package com.example.gestiondestage.controller;

import com.example.gestiondestage.entities.StageEntity;
import com.example.gestiondestage.services.ICompanyService;
import com.example.gestiondestage.services.IInternshipService;
import com.example.gestiondestage.services.IProfessorService;
import com.example.gestiondestage.services.IStudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;

import static com.example.gestiondestage.Utils.getParamFromParameterMap;
import static java.lang.Integer.parseInt;
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

    @Autowired
    private IInternshipService internshipService;

    @RequestMapping(value = {"/index", "/"}, method = {GET, POST})
    public String index(final Model model, @RequestParam(required = false, defaultValue = "-1") final int success, final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final Object currentLogin = session.getAttribute("login");
        model.addAttribute("currentLogin", currentLogin);
        model.addAttribute("success", currentLogin != null ? 1 : success);
        return "index";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(final Model model, final HttpServletRequest request, final RedirectAttributes attributes) {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final String role = request.getParameter("type");
        final boolean result = switch (role) {
            case "student" -> studentService.login(login, password);
            case "teacher" -> professorService.login(login, password);
            default -> false;
        };
        if (result) {
            final HttpSession session = request.getSession();
            session.setAttribute("role", role);
            session.setAttribute("login", login);
        }
        attributes.addAttribute("success", result ? 1 : 0);
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.setAttribute("role", null);
        session.setAttribute("login", null);
        return "index";
    }

    @RequestMapping(value = "/inscription", method = {POST, GET})
    public String inscription(final Model model, @RequestParam final Optional<String> companyName, final HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) return "redirect:/index";

        model.addAttribute("companyName", companyName.orElseGet(() -> "null"));
        model.addAttribute("entrepriseList", companyService.getAllCompanies());
        model.addAttribute("etudiantList", studentService.getAllStudents());
        model.addAttribute("professeursList", professorService.getAllProfessors());
        return "inscription";
    }

    @RequestMapping(value = "/postInscription", method = POST)
    public String postInscription(final Model model, final HttpServletRequest request) {
        internshipService.addStage(parseParam(request));
        return "redirect:/inscription";
    }

    private StageEntity parseParam(final HttpServletRequest request) {
        final Map<String, String[]> params = request.getParameterMap();
        final int id = internshipService.getLastInsertedId() + 1;
        final int numEtudiant = parseInt(getParamFromParameterMap(params, "etudiants"));
        return new StageEntity(id, Date.valueOf(getParamFromParameterMap(params, "date_debut")),
                Date.valueOf(getParamFromParameterMap(params, "date_fin")), getParamFromParameterMap(params, "type_stage"), getParamFromParameterMap(params, "description_projet"),
                getParamFromParameterMap(params, "observations"), numEtudiant, parseInt(getParamFromParameterMap(params, "professeurs")), parseInt(getParamFromParameterMap(params, "entreprises")),
                studentService.getStudentById(numEtudiant));
    }

    @RequestMapping("/aide")
    public String aide() {
        return "aide";
    }
}
