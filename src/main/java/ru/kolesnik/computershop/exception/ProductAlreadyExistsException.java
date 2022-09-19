package ru.kolesnik.computershop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,
        reason = "Product with given series number and manufacturer name already exists!")
public class ProductAlreadyExistsException extends RuntimeException {

}
