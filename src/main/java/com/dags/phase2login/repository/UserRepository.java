package com.dags.phase2login.repository;

import com.dags.phase2login.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
