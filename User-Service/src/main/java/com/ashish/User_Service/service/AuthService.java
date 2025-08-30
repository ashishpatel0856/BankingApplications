package com.ashish.User_Service.service;

import com.ashish.User_Service.dto.AuthResponseDto;
import com.ashish.User_Service.dto.LoginDto;
import com.ashish.User_Service.dto.SignUpDto;
import com.ashish.User_Service.dto.UserDto;
import com.ashish.User_Service.entity.User;
import com.ashish.User_Service.repository.UserRepository;
import com.ashish.User_Service.util.BCrypt;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
//@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper, JwtService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public UserDto signUp(SignUpDto signUpDto) throws RuntimeException {

        if (userRepository.existsByEmail(signUpDto.getEmail()))
            throw new RuntimeException("Email has already exists");
        if (userRepository.existsByPhone(signUpDto.getPhone()))
            throw new RuntimeException("Phone number has already exists");
        if (userRepository.existsByAdharcardNumber(signUpDto.getAdharcardNumber()))
            throw new RuntimeException("Adhar card number has  already exists");

        User user = modelMapper.map(signUpDto, User.class);
        user.setPassword(BCrypt.hash(signUpDto.getPassword()));
        user = userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public AuthResponseDto login(LoginDto loginDto) throws BadRequestException {
        log.info("login a user with email: {}", loginDto.getEmail());

        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new BadRequestException("Incorrect email or password, please try again"));

        boolean isPasswordMatch = BCrypt.match(loginDto.getPassword(), user.getPassword());

        if (!isPasswordMatch) {
            throw new BadRequestException("Incorrect email or password, please try again");
        }

        String token= jwtService.genrateAccessToken(user);
        return new AuthResponseDto(token , modelMapper.map(user, UserDto.class));
    }


}
