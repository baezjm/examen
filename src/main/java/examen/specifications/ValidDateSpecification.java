package examen.specifications;

import examen.entity.Menu;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by jbaez on 13/11/16.
 */
@And({
        @Spec(path = "fromValidDate", spec = LessThanOrEqual.class, config = "yyyy-MM-dd"),
        @Spec(path = "toValidDate", spec = GreaterThanOrEqual.class, config = "yyyy-MM-dd")
})
public interface ValidDateSpecification extends Specification<Menu>{
}
