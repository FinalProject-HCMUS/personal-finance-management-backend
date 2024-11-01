package com.hcmus.personalfinanceapiservice.user;

import com.hcmus.personalfinanceapicommon.entity.User;
import com.hcmus.personalfinanceapiservice.exception_handler.DataNotFoundException;
import com.hcmus.personalfinanceapiservice.user.dto.UpdateUserDTO;
import com.hcmus.personalfinanceapiservice.user.dto.UserRequestDTO;
import com.hcmus.personalfinanceapiservice.user.dto.UserResponseDTO;
import com.hcmus.personalfinanceapiservice.user.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
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

    public UserResponseDTO updateUser(UpdateUserDTO userDTO, Long userId ) throws Exception
    {
        Optional<User> existedUser = userRepository.findById(userId);
        if(existedUser.isEmpty())
        {
            throw new DataNotFoundException("User is not exists!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        User user = existedUser.get();
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setDob(Date.valueOf(LocalDate.parse(userDTO.getDateOfBirth(),formatter)));
        user.setAvatar(userDTO.getAvatar());
        return UserResponseDTO.fromUser(userRepository.save(user));
    }

    public String login(String email, String password) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty())
        {
            throw new DataNotFoundException("Invalid email!");
        }
        User existedUser = optionalUser.get();
        if(!passwordEncoder.matches(password,existedUser.getPassword()))
        {
            throw new BadCredentialsException("Invalid password!");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwtTokenUtil.generateToken(existedUser);
    }
}
