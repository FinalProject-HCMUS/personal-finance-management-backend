package com.hcmus.personalfinanceapiservice.user;

import com.hcmus.personalfinanceapiservice.user.dto.UpdateUserDTO;
import com.hcmus.personalfinanceapiservice.user.dto.UserRequestDTO;
import com.hcmus.personalfinanceapiservice.user.dto.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserApiController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
            return ResponseEntity.ok(userResponseDTO);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserDTO userDTO, @PathVariable Long userId, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            UserResponseDTO userResponseDTO = userService.updateUser(userDTO,userId);
            return ResponseEntity.ok(userResponseDTO);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
