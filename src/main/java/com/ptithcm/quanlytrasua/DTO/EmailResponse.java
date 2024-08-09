package com.ptithcm.quanlytrasua.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailResponse {
    private String subject;
    private String message;
    private String mailTo;
}
