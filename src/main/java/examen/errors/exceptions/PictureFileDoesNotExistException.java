package examen.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jbaez on 11/10/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class PictureFileDoesNotExistException extends RuntimeException{


    public PictureFileDoesNotExistException(String pictureId) {
        super("Picture with id "+ pictureId + " not found");
    }

}
