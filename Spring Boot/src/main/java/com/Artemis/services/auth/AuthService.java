package com.Artemis.services.auth;

import com.Artemis.dtos.SignupRequest;
import com.Artemis.dtos.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
