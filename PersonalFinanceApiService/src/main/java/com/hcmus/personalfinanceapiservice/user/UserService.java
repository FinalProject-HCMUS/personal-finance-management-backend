package com.hcmus.personalfinanceapiservice.user;

import com.hcmus.personalfinanceapicommon.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws Exception
    {
        Optional<User> existedUser = userRepository.findByEmail(userRequestDTO.getEmail());
        if(!existedUser.isEmpty())
        {
            throw new DataIntegrityViolationException("Email already exists!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        User user = User.builder().name(userRequestDTO.getName())
                .phone(userRequestDTO.getPhone())
                .email(userRequestDTO.getEmail())
                .dob(Date.valueOf(LocalDate.parse(userRequestDTO.getDateOfBirth(),formatter)))
                .avatar(userRequestDTO.getAvatar())
                .password(passwordEncoder.encode(userRequestDTO.getPassword()))
                .build();
        return UserResponseDTO.fromUser(userRepository.save(user));
    }
}
