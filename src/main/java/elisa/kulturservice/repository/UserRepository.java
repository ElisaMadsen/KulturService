package elisa.kulturservice.repository;

import elisa.kulturservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByName(String name);

}
