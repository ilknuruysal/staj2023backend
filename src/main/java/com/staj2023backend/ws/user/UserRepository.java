package com.staj2023backend.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    //Users findByUsername(String username);

}
