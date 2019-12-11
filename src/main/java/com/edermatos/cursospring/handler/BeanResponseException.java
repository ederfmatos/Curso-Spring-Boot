package com.edermatos.cursospring.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString(doNotUseGetters = true)
public class BeanResponseException {

    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus status;
    private Integer code;

    public BeanResponseException(String message, String details, HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.status = status;
        this.code = status.value();
    }

}
