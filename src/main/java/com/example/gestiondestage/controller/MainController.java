package com.example.gestiondestage.controller;

import com.example.gestiondestage.services.ICompanyService;
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

    @RequestMapping(value = {"/index", "/"}, method = {GET, POST})
    public String index(final Model model, @RequestParam(required = false, defaultValue = "-1") final int success, final HttpServletRequest request) {
        model.addAttribute("success", success);
        final HttpSession session = request.getSession();
        model.addAttribute("currentLogin", session.getAttribute("login"));
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
        model.addAttribute("entrepriseList", companyService.getCompaniesNames());
        model.addAttribute("etudiantList", studentService.getStudentsNames());
        model.addAttribute("professeursList", professorService.getProfessorsNames());
        return "inscription";
    }

    @RequestMapping("/aide")
    public String aide() {
        return "aide";
    }
}
