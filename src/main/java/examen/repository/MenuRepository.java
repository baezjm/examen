package examen.repository;


import examen.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */
public interface MenuRepository extends JpaRepository<Menu, Long> , JpaSpecificationExecutor<Menu> {

}
