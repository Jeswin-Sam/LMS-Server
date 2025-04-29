package com.ust.LMS.security;

import lombok.Data;

@Data
public class VerifyOtpRequest {
    private String email;
    private String otp;
}
