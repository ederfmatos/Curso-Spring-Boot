package com.edermatos.cursospring.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@ToString(doNotUseGetters = true)
public class BeanResponseException {

    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm:ss")
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
