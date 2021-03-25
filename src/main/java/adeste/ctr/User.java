package adeste.ctr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User {
    private static Logger log = LogManager.getLogger(User.class);

    @PostMapping("/login")
    public String login(Model model) {
        log.traceEntry();

        model.addAttribute("user", "fake");
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        log.traceEntry();

        return "home";
    }
}
