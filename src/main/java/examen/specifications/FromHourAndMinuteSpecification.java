package examen.specifications;

import examen.entity.Menu;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Disjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by jbaez on 13/11/16.
 */
@Disjunction(value = {
        @And({
                @Spec(path = "fromMinute", spec = LessThanOrEqual.class),
                @Spec(path = "fromHour", spec = LessThanOrEqual.class)
        })
}, or = @Spec(path = "fromHour", spec = LessThan.class))
public interface FromHourAndMinuteSpecification extends Specification<Menu>{
}
