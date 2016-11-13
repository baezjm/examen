package examen.services;

import examen.entity.Currency;

import java.util.List;

/**
 * Created by jbaez on 12/11/16.
 */
public interface CurrencyService {

    List<Currency> getAll();

    Currency findById(Long id);

    Currency edit(Long id, String name);

    Currency create(String name);

    void delete(Long id);
}
