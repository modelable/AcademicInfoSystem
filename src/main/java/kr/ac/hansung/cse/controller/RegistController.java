package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistController {

    @Autowired
    private RegistService registService;

    @GetMapping("/registrations")
    public String showRegistrations(Model model) {
        List<Course> registrations = registService.getAllRegistrations();
        model.addAttribute("id_registrations", registrations);

        return "registrations";
    }

    @GetMapping("/registcourse")
    public String registCourse(Model model) {

        model.addAttribute("course", new Course());

        return "registcourse";
    }

    @PostMapping("/doregist")
    public String doRegist(Model model, @Valid Course course, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for (ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "registcourse";
        }

        registService.insert(course);

        return "courseregisted";
    }
}
