package examen.services.impl;


import examen.entity.Currency;
import examen.errors.exceptions.NotFoundException;
import examen.repository.CurrencyRepository;
import examen.errors.exceptions.CurrencyDoesNotExistException;
import examen.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */
@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }


    public Currency findById(Long id) {
        Currency currency = currencyRepository.findOne(id);
        if(currency==null) throw new NotFoundException(id.toString(),"Currency");
        return currency;
    }
    public Currency edit(Long id, String name) {
        Currency currency = findById(id);
        currency.setName(name);
        return currencyRepository.save(currency);
    }
    public Currency create(String name) {
        Currency currency = new Currency(name);
        return currencyRepository.save(currency);
    }
    public void delete(Long id) {
        currencyRepository.delete(id);
    }
}
