package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserData {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 8)
    private String kataSandi;
}
