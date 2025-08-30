package com.ashish.User_Service.service;

import com.ashish.User_Service.dto.UserDto;
import com.ashish.User_Service.entity.KycStatus;
import com.ashish.User_Service.entity.User;
import com.ashish.User_Service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;


    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id"));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUserById(Long id,UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id"));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());

        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto verifyKyc(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id"));
        user.setKycStatus(KycStatus.VERIFIED);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }
}
