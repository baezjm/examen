package examen.repository;

import examen.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jbaez on 11/10/16.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
