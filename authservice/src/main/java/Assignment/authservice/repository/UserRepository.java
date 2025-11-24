package Assignment.authservice.repository;

import Assignment.authservice.entity.User; //Import user class from entity
import org.springframework.data.jpa.repository.JpaRepository; // import class JPARepository from Spring Data JPA
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}


