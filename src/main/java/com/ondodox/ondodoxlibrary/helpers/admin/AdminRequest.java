package com.ondodox.ondodoxlibrary.helpers.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;

import javax.validation.constraints.NotNull;

@Data
public class AdminRequest {
    @NotNull(message = "Nama pengguna tidak valid")
    private String namaPengguna;
    @NotNull(message = "Kata sandi tidak valid")
    @Length(max = 20, min = 8, message = "Batas maksimal {max} dan minimal {min}")
    private String kataSandi;

    public String kataSandiEncrypted(){
        BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();
        return encryptor.encryptPassword(kataSandi);
    }

}
