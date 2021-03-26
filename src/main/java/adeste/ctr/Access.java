package adeste.ctr;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import adeste.svc.UserSvc;

@Controller
public class Access {
    private static Logger log = LogManager.getLogger(Access.class);

    @Autowired
    UserSvc svc;

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model, HttpSession session) {
        log.traceEntry("{}, {}", name, password);

        svc.getUser(name, password).ifPresentOrElse(user -> {
            session.setAttribute("user", user);
        }, () -> {
            session.setAttribute("user", null);
        });
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.traceEntry();

        session.invalidate();
        return "home";
    }
}
