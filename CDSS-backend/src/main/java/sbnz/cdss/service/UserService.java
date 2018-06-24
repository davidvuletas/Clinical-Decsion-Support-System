package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.User;

import java.util.List;

@Service
public interface UserService {
    User login(String username, String password);
    boolean addDoctor(User doctor);
    List<User> getAllDoctors();

    User addAdministrator(User user);
    User updateUser(User user);
    void deleteUser(User user);
    void deleteUser(Long id);
}
