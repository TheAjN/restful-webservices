package com.ajn.rest.webservices.restfulwebservices.User.Repository;

import com.ajn.rest.webservices.restfulwebservices.User.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
