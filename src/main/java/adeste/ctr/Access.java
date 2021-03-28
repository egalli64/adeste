package adeste.ctr;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import adeste.dao.User;
import adeste.svc.UserSvc;

@Controller
public class Access {
    private static final Logger log = LogManager.getLogger(Access.class);

    @Autowired
    UserSvc userSvc;

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, HttpSession session) {
        log.traceEntry("{}, {}", name, password.length());

        userSvc.get(name, password).ifPresentOrElse(user -> {
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

    @GetMapping("/register")
    public String register(HttpSession session) {
        log.traceEntry();

        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String name, @RequestParam String password,
            @RequestParam Optional<String> admin, Model model) {
        log.traceEntry("{}, {}, {}", name, password.length(), admin);

        if (userSvc.create(name, password, admin)) {
            model.addAttribute("name", name);
        } else {
            model.addAttribute("user", new User(name, password, admin.isPresent() ? 1 : 2));
        }

        return "register";
    }
}
