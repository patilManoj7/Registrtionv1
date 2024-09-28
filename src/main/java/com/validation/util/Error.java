package com.validation.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor

public class Error {
    private String message;
    private Date date;
    private String uri;
}
