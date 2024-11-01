package com.hcmus.personalfinanceapiservice.user;

import com.hcmus.personalfinanceapiservice.user.dto.ForgotPasswordDTO;
import com.hcmus.personalfinanceapiservice.user.dto.UserLoginDTO;
import com.hcmus.personalfinanceapiservice.user.dto.VerifyOtpDTO;
import com.hcmus.personalfinanceapiservice.user.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthApiController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO)
    {
        try {
            String token = userService.login(userLoginDTO.getEmail(),userLoginDTO.getPassword());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            return ResponseEntity.ok().body(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDTO request) {
        try {
            userService.sendOTP(request.getEmail());
            return ResponseEntity.ok("Send OTP successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpDTO request) {
        try {
            boolean isValidOtp = userService.verifyOTP(request.getOtp(),request.getEmail());
            if (!isValidOtp) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OTP is wrong");
            }
            return ResponseEntity.ok("OTP verified successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
