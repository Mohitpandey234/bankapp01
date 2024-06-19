package com.example.Bankapp1.service.impl;

import com.example.Bankapp1.dto.BankResponse;
import com.example.Bankapp1.dto.UserRequest;

public interface UserService {

   BankResponse createAccount(UserRequest userRequest);
}
