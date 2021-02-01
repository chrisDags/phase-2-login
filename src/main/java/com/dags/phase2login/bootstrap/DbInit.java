package com.dags.phase2login.bootstrap;

import com.dags.phase2login.entity.User;
import com.dags.phase2login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
    Creates initial user data in the database
 */
@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        User user2 = new User();

        user1.setUsername("foo");
        user1.setPassword("123");
        user2.setUsername("foo2");
        user2.setPassword("321");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
