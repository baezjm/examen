package examen.specifications.impl;

import examen.entity.Menu;
import examen.entity.Menu_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;

/**
 * Created by jbaez on 13/11/16.
 */
public class DaySpecification implements Specification<Menu>{

    private String day;

    public DaySpecification(String day) {
        this.day = day;
    }

    @Override
    public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.isMember(day,root.get(Menu_.days));
    }
}
