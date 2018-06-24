package sbnz.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.cdss.model.entity.Role;
import sbnz.cdss.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUsernameAndPassword(String username,String password);
    User findUserByUsername(String username);
    User findUserById(Long id);
    List<User> findAllByRole(Role role);
}
