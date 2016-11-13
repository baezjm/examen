package examen.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jbaez on 11/10/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CurrencyDoesNotExistException extends RuntimeException {

    public CurrencyDoesNotExistException(Long currencyId) {
        super("Currency with id "+ currencyId + " not found");
    }

}
