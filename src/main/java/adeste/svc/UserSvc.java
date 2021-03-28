package adeste.svc;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import adeste.dao.User;
import adeste.dao.UserRepo;

@Service
public class UserSvc {
    private static final Logger log = LogManager.getLogger(UserSvc.class);

    private UserRepo repo;

    public UserSvc(UserRepo repo) {
        this.repo = repo;
    }

    public Optional<User> get(String name, String password) {
        log.traceEntry();
        return repo.findByNameAndPassword(name, password);
    }

    public boolean create(String name, String password, Optional<String> admin) {
        log.traceEntry();

        if (repo.existsByName(name)) {
            log.debug("User {} already saved", name);
            return false;
        }

        repo.save(new User(name, password, admin.isPresent() ? 1 : 2));
        return true;
    }
}
