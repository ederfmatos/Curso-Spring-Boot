package com.edermatos.cursospring.handler;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@ToString(doNotUseGetters = true)
public class BeanResponseException {

    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus status;
    private Integer code;

    public BeanResponseException(String message, String details, HttpStatus status) {
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
        this.status = status;
        this.code = status.value();
    }

}
