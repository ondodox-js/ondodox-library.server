package com.ondodox.ondodoxlibrary.helpers;

import lombok.Data;

@Data
public class Response {
    private boolean status;
    private Object data;

    public Response(boolean status, Object data) {
        this.status = status;
        this.data = data;
    }
}
