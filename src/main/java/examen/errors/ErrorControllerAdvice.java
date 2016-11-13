package examen.errors;

import com.google.common.collect.Maps;
import examen.errors.exceptions.GenericErrorException;
import examen.errors.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jbaez on 11/10/16.
 */
@ControllerAdvice
public class ErrorControllerAdvice{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleArgumentValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.joining(". "));

        return returnError(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericErrorException.class)
    public ResponseEntity<Map<String, Object>> handleGenericErrorException(GenericErrorException ex) {
        return returnError(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoFoundException(NotFoundException ex) {
        return returnError(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Map<String, Object>> returnError(String message,HttpStatus status) {
        Map<String, Object> body = Maps.newHashMap();
        body.put("timestamp",new Timestamp(new Date().getTime()));
        body.put("status",status.value());
        body.put("error",status.getReasonPhrase());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}
