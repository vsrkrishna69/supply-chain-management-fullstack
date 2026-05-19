package jsp.supplychainmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jsp.supplychainmanagement.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}

