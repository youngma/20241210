package musinsa.bob.main.config.advice;


import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import musinsa.bob.main.config.vo.RespVo;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpEntity<RespVo<Throwable>> handle404(NoHandlerFoundException e){
        return ResponseEntity.badRequest().body(new RespVo<>(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }


    @ExceptionHandler({
        ValidationException.class,
        TypeMismatchException.class,
        IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleDefException(Exception e) {
        log.error("#### handleDefException", e);
        return ResponseEntity.badRequest().body(new RespVo(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespVo<List<String>> processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        List<String> validErrors = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            StringBuilder builder = new StringBuilder();

            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("] => ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");

            validErrors.add(builder.toString());
        }

        return new RespVo<>(validErrors);
    }

    @ExceptionHandler({
        RuntimeException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpEntity<RespVo<String>> handleBaseException(Exception e) {
        log.error("#### handleDefException", e);

        return ResponseEntity.badRequest().body(new RespVo<>(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }


}
