package examen.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jbaez on 11/10/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class MenuDoesNotExistException extends RuntimeException {

    public MenuDoesNotExistException(Long menuId) {
        super("Menu with id "+ menuId + " not found");
    }

}
