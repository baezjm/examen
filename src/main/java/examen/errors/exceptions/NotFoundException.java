package examen.errors.exceptions;

/**
 * Created by jbaez on 12/11/16.
 */
public class NotFoundException extends GenericErrorException{

    public NotFoundException(String id, String entityClass) {
        super(entityClass + " with id "+ id + " not found");
    }
}
