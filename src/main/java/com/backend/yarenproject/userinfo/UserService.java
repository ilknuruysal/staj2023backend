package com.backend.yarenproject.userinfo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service // Okunurluğu artırmak için
public class UserService
{
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    // @Autowired --> Tek constructor varsa gerek yok
    public UserService(UserRepository userRepository) // Constructor Injection
    {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Dependency Injection a gerek yok
    }

    public void save(User user)
    {
        String encryptedPass = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);

        userRepository.save(user);
    }
}