package sbnz.cdss.service;

import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.User;

@Service
public interface UserService {
    User login(String username, String password);
    boolean addDoctor(User doctor);
}
