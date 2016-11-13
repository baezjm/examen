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

    public Currency findById(Long id) {
        Currency currency = currencyRepository.findOne(id);
        if(currency==null) throw new NotFoundException(id.toString(),"Currency");
        return currency;
    }

}
