package org.example.daedongyeojido_be.domain.user.repository;


import org.example.daedongyeojido_be.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

}
