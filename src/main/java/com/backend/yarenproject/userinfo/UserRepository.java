package com.backend.yarenproject.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> // db ye erişmek için olan bir interface
{
    User findByUsername (String username); // Spring Data arka planda buna uygun bir query üretir
}