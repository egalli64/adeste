package adeste.ctr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import adeste.dao.CourseRepo;

@Controller
public class Home {
    private static Logger log = LogManager.getLogger(Home.class);

    @Autowired
    private CourseRepo repo;

    @GetMapping("/")
    public String hello(Model model) {
        log.traceEntry();
        repo.findFirstByOrderByLastDesc().ifPresent(course -> model.addAttribute("course", course.getName()));

        return "/home";
    }
}
