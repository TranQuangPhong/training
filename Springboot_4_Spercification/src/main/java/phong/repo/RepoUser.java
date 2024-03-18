package phong.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import phong.model.User;

@Repository
public interface RepoUser extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
