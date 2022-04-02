package com.ondodox.ondodoxlibrary.helpers;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class StringEncryptor {
    private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
    private String text;

    public StringEncryptor(String text) {
        this.text = text;
    }
    public boolean cekPassword(String encrypt){
        return encryptor.checkPassword(text, encrypt);
    }
    public String encrypt(){
        return encryptor.encryptPassword(text);
    }
}
