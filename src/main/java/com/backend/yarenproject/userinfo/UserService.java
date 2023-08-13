package com.backend.yarenproject.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // okunurluğu artırmak için
public class UserService
{
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    // @Autowired --> tek constructor varsa gerek yoktur
    public UserService(UserRepository userRepository) // constructor injection
    {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); //dependency injectiona gerek yok
    }

    public void save(User user)
    {
        String encryptedPass = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);

        userRepository.save(user);
    }
}
