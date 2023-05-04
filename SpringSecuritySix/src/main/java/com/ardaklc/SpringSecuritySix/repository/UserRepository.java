package com.ardaklc.SpringSecuritySix.repository;

import com.ardaklc.SpringSecuritySix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String user_name);
}
