package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;

@Data
public class LoginHandle {
    private boolean status;

    public LoginHandle(boolean status, String akun, Object data) {
        this.status = status;
        this.akun = akun;
        this.data = data;
    }

    private String akun;
    private Object data;

}
