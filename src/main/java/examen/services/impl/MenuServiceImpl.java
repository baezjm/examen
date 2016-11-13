package examen.services.impl;


import examen.dto.MenuDto;
import examen.entity.Currency;
import examen.entity.Menu;
import examen.errors.exceptions.NotFoundException;
import examen.repository.MenuRepository;
import examen.errors.exceptions.MenuDoesNotExistException;
import examen.errors.exceptions.PictureFileDoesNotExistException;
import examen.services.CurrencyService;
import examen.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CurrencyService currencyService;

    @Value("#{'${app.pictures}'.split(',')}")
    List<String> pictures;

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Page<Menu> listAllByPageAndSpecification(Specification<Menu> spec, Pageable pageable) {
        return menuRepository.findAll(spec,pageable);
    }

    public Menu findById(Long id) {
        Menu menu = menuRepository.findOne(id);
        if(menu==null) throw new NotFoundException(id.toString(),"Menu");
        return menu;
    }

    public Menu edit(Long id,MenuDto menuDto) {
        Menu menu = findById(id);
        menu.copyFrom(menuDto);

        if (menuDto.getCurrencyId() != null){
            Currency currency= currencyService.findById(menuDto.getCurrencyId());
            menu.setCurrency(currency);
        }

        return menuRepository.save(menu);
    }

    public Menu create(MenuDto menuDto) {
        Menu menu = new Menu();
        return save(menuDto, menu);
    }

    public void delete(Long id) {
        menuRepository.delete(id);
    }

    public List<String> getAvailablePictures() {
        return pictures;
    }

    private void assertPictureFileIsValid(String pictureFile) {
        if(pictureFile!=null && !pictures.contains(pictureFile)) {
            throw new PictureFileDoesNotExistException(pictureFile);
        }
    }

    private Menu save(MenuDto menuDto, Menu menu) {
        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());
        menu.setPrice(menuDto.getPrice());
        Currency currency = currencyService.findById(menuDto.getCurrencyId());
        menu.setCurrency(currency);
        menu.setFromValidDate(menuDto.getFromValidDate());
        menu.setToValidDate(menuDto.getToValidDate());
        menu.setFromHour(menuDto.getFromHour());
        menu.setFromMinute(menuDto.getFromMinute());
        menu.setToHour(menuDto.getToHour());
        menu.setToMinute(menuDto.getToMinute());
        menu.setRanking(menuDto.getRanking());
        menu.setDays(menuDto.getDays());
        assertPictureFileIsValid(menuDto.getPictureFile());
        menu.setPictureFile(menuDto.getPictureFile());
        return menuRepository.save(menu);
    }

}
