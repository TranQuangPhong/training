package phong.model.specification;

import org.springframework.data.jpa.domain.Specification;
import phong.model.User;
import phong.model.UserType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class SpecificationUser {

    public static Specification<User> hasType(UserType type){
        return (root, criteriaQuery , criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<User> hasId(Long id){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

    public static Specification<User> hasIdIn(Collection<Long> ids){
        return (root, criteriaQuery, criteriaBuilder) -> root.get("id").in(ids);
    }
}
