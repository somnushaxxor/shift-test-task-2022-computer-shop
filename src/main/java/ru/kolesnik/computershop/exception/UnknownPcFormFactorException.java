package ru.kolesnik.computershop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Unknown form factor!")
public class UnknownPcFormFactorException extends RuntimeException {

}
