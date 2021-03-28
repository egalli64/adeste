package adeste.svc;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adeste.ctr.Home;
import adeste.dao.User;
import adeste.dao.UserRepo;

@Service
public class UserSvc {
    private static final Logger log = LogManager.getLogger(Home.class);

    @Autowired
    private UserRepo userRepo;

    public Optional<User> get(String name, String password) {
        log.traceEntry();
        return userRepo.findByNameAndPassword(name, password);
    }

    public boolean create(String name, String password, Optional<String> admin) {
        log.traceEntry();

        if (userRepo.existsByName(name)) {
            log.debug("User {} already saved", name);
            return false;
        }

        userRepo.save(new User(name, password, admin.isPresent() ? 1 : 2));
        return true;
    }
}
