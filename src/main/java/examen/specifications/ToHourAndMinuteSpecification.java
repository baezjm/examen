package examen.specifications;

import examen.entity.Menu;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Disjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by jbaez on 13/11/16.
 */
@Disjunction(value = {
        @And({
                @Spec(path = "toMinute", spec = GreaterThanOrEqual.class),
                @Spec(path = "toHour", spec = GreaterThanOrEqual.class)
        })
}, or = @Spec(path = "toHour", spec = GreaterThan.class))
public interface ToHourAndMinuteSpecification extends Specification<Menu>{
}
