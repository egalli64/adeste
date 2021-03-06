package adeste.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    boolean existsByName(String name);

    Optional<User> findByName(String name);

    Optional<User> findByNameAndPassword(String name, String password);
}
