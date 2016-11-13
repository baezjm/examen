package examen.controller;

import examen.dto.MenuDto;
import examen.entity.Menu;
import examen.services.MenuService;
import examen.specifications.impl.DaySpecification;
import examen.specifications.FromHourAndMinuteSpecification;
import examen.specifications.ToHourAndMinuteSpecification;
import examen.specifications.ValidDateSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */

@RestController
@RequestMapping("/menu")
public class MenuController{

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Menu> list(FromHourAndMinuteSpecification fromHourAndMinuteSpecification, ToHourAndMinuteSpecification toHourAndMinuteSpecification, ValidDateSpecification validDateSpecification,
                           @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(value = "day", required = false) String day) {
        return menuService.listAllByPageAndSpecification(Specifications.where(fromHourAndMinuteSpecification).and(toHourAndMinuteSpecification).and(validDateSpecification).and(day != null ? new DaySpecification(day):null),pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Menu> getMenu(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Menu> createMenu(@RequestBody @Valid MenuDto menuDto) {
        Menu menuSaved = menuService.create(menuDto);
        return new ResponseEntity<>(createHeadersWithLocation(menuSaved), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Menu editMenu(@PathVariable Long id, @RequestBody MenuDto menuDto) {
        return menuService.edit(id, menuDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
    }

    @RequestMapping(value = "/pictures", method = RequestMethod.GET)
    public List<String> getAvailablePictures() {
        return menuService.getAvailablePictures();
    }

    private HttpHeaders createHeadersWithLocation(Menu menuSaved) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(menuSaved.getId())
                        .toUri());
        return httpHeaders;
    }

}
