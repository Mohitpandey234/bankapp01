package com.example.Bankapp1.service.impl;


import com.example.Bankapp1.dto.AccountInfo;
import com.example.Bankapp1.dto.BankResponse;
import com.example.Bankapp1.dto.UserRequest;
import com.example.Bankapp1.entity.User;
import com.example.Bankapp1.repository.UserRepository;
import com.example.Bankapp1.utils.Accountutils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public BankResponse createAccount(UserRequest userRequest) {
/**
 * Creating an account - saving new user info db
 * Check if user already has an account by email
 */

      if(userRepository.existByEmail(userRequest.getEmail())){
 return BankResponse.builder()
        .responseCode(Accountutils.ACCOUNT_EXIST_CODE)
        .responseMessage(Accountutils.ACCOUNT_EXIST_MESSAGE)
         .accountInfo(null)
        .build();
      }
        User newUser= User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateofOrigin(userRequest.getStateofOrigin())
                .accountNumber(Accountutils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternatePhoneNumber(userRequest.getAlternatePhoneNumber())
                .status("ACTIVE")
                .build();

User savedUser=userRepository.save(newUser);
return BankResponse.builder()
        .responseCode(Accountutils.ACCOUNT_CREATION_SUCCESS)
        .responseMessage(Accountutils.ACCOUNT_CREATION_MESSAGE)
        .accountInfo(AccountInfo.builder()
                .accountBalance(savedUser.getAccountBalance())
                .accountNumber(savedUser.getAccountNumber())
                .accountName(savedUser.getFirstName()+" "+ savedUser.getLastName() +" "+savedUser.getOtherName())
                .build())
        .build();
    }
}
