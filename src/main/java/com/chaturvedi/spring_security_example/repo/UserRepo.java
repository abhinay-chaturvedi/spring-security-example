package com.chaturvedi.spring_security_example.repo;

import com.chaturvedi.spring_security_example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
