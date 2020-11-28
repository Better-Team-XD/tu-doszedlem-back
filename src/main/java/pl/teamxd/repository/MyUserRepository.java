package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teamxd.model.entity.MyUser;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findMyUserByUsername(String username);
    Optional<MyUser> deleteMyUserByUsername(String username);
}
