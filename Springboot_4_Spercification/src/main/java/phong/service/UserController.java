package phong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import phong.model.User;
import phong.model.UserType;
import phong.model.specification.SpecificationUser;
import phong.repo.RepoUser;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    RepoUser repo;

    @GetMapping("/users")
    public List<User> getUser() {

        Specification<User> specification = Specification.where(SpecificationUser.hasType(UserType.VIP));
        return repo.findAll(specification);
    }

}
