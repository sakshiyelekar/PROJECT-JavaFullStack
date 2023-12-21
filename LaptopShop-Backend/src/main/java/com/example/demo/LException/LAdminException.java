package com.example.demo.LException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LAdminException extends RuntimeException {

    public LAdminException(Long id) {
        super("Admin not found with id: " + id);
    }
}
