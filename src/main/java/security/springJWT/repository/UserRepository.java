package security.springJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.springJWT.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
