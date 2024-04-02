package kr.ac.hansung.cse.controller;
import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showYearSemesterCredit(Model model) {
        List<Object[]> yearsemestercredits = courseService.getYearSemesterCredit();
        model.addAttribute("id_yearsemestercredit", yearsemestercredits);

        int totalCredit = 0;
        for (Object[] object : yearsemestercredits) {
            totalCredit += (int)object[2];
        }
        model.addAttribute("id_totalcredit", totalCredit);

        return "courses";
    }

    @GetMapping("/courses/{year}/{semester}")
    public String showCoursesByYearAndSemester(@PathVariable int year, @PathVariable int semester, Model model) {
        // 특정 년도와 학기에 해당하는 과목 가져오기
        List<Course> courses = courseService.getCoursesByYearAndSemester(year, semester);
        model.addAttribute("id_courses", courses);

        return "coursesDetail";
    }
}
