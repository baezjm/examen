package examen.controller;


import examen.entity.Currency;
import examen.dto.CurrencyDto;
import examen.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Currency getCurrency(@PathVariable Long id) {
        return currencyService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Currency createCurrency(@RequestBody @Valid CurrencyDto currencyDto) {
        return currencyService.create(currencyDto.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Currency editCurrency(@PathVariable Long id, @RequestBody @Valid CurrencyDto currencyDto) {
        return currencyService.edit(id, currencyDto.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCurrency(@PathVariable Long id) {
        currencyService.delete(id);
    }

}
