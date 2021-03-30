package adeste.svc;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import adeste.dao.User;
import adeste.dao.UserRepo;

@Service
public class UserSvc {
    public static final int ADMINISTRATOR = 1;
    public static final int PLAIN = 2;

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

        repo.save(new User(name, password, admin.isPresent() ? ADMINISTRATOR : PLAIN));
        return true;
    }

    public Optional<User> edit(User current, Optional<String> name, String password) {
        log.traceEntry();

        User edited = new User();

        if (current.getRole() == ADMINISTRATOR && name.isPresent()) {
            String newName = name.get();
            if (!current.getName().equals(newName) && repo.existsByName(newName)) {
                log.debug("Can't rename user to {}, already existing", name);
                return Optional.empty();
            } else {
                edited.setName(newName);
            }
        } else {
            edited.setName(current.getName());
        }

        edited.setId(current.getId());
        edited.setPassword(password);
        edited.setRole(current.getRole());

        return Optional.of(repo.save(edited));
    }
}
