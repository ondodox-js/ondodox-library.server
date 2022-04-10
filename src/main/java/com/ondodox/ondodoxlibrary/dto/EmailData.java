package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;

@Data
public class EmailData {
    private String to;
    private String fromEmail = "wpondodox@gmail.com";
    private String fromPersonal = "Ondodox technologies";
    private String component;
    private String subject;
}
