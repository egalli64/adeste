package adeste.svc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adeste.dao.User;
import adeste.dao.UserRepo;

@Service
public class UserSvc {
    @Autowired
    private UserRepo repo;

    public Optional<User> getUser(String name, String password) {
        return repo.findByNameAndPassword(name, password);
    }
}
