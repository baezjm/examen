package examen.services;

import examen.dto.MenuDto;
import examen.entity.Currency;
import examen.entity.Menu;
import examen.errors.exceptions.MenuDoesNotExistException;
import examen.errors.exceptions.PictureFileDoesNotExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jbaez on 12/11/16.
 */
public interface MenuService {

    Menu findById(Long id);

    Menu edit(Long id,MenuDto menuDto);

    Menu create(MenuDto menuDto);

    void delete(Long id);

    List<String> getAvailablePictures();

    Page<Menu> listAllByPageAndSpecification(Specification<Menu>spec, Pageable pageable);

 }
