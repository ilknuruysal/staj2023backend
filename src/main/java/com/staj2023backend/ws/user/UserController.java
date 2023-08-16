package com.staj2023backend.ws.user;

import com.staj2023backend.ws.error.ApiError;
import com.staj2023backend.ws.model.Product;
import com.staj2023backend.ws.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody Users user) {
        userService.save(user);
        return new GenericResponse("user created");
    }

    @GetMapping("/api/1.0/users")
    public List<Users> getAllUsers() {
        return userService.userRepository.findAll();
    }

    @GetMapping("api/1.0/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Optional<Users> users = userService.userRepository.findById(id);

        if (users.isPresent()) {
            return ResponseEntity.ok(users.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("api/1.0/users/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Long id, @RequestBody Users updatedUser) {
        Optional<Users> existingUser = userService.userRepository.findById(id);

        if (existingUser.isPresent()) {
            Users userToUpdate = existingUser.get();
            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setDisplayName(updatedUser.getDisplayName());
            userToUpdate.setPassword(updatedUser.getPassword());

            userService.userRepository.save(userToUpdate);

            return ResponseEntity.ok(userToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/1.0/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        Optional<Users> userToDelete = userService.userRepository.findById(id);

        if (userToDelete.isPresent()) {
            userService.userRepository.delete(userToDelete.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception) {
        ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();

        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }

}
