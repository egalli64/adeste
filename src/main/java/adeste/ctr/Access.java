package adeste.ctr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import adeste.svc.UserSvc;

@Controller
public class Access {
    private static Logger log = LogManager.getLogger(Access.class);

    @Autowired
    UserSvc svc;

    @PostMapping("/login")
    public String login(Model model) {
        log.traceEntry();

        svc.getUser("admin", "password").ifPresent(user -> {
            model.addAttribute("user", user);   
        });
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        log.traceEntry();

        return "home";
    }
}
