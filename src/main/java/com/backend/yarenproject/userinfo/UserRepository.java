package com.backend.yarenproject.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> // db ye erişmemiz için olan bir interface
{

}
