package com.putra.portfolio.request;

import lombok.Data;

@Data
public class ForgotPasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmationPassword;
}
