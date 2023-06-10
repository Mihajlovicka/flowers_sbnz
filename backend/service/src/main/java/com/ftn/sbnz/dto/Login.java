package com.ftn.sbnz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {
    private String email;
    private String password;
}
