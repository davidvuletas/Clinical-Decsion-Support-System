package sbnz.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.cdss.model.entity.Role;
import sbnz.cdss.model.entity.User;
import sbnz.cdss.repository.UserRepository;
import sbnz.cdss.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        User user = this.userRepository.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean addDoctor(User doctor) {
        User existing = this.userRepository.findUserByUsername(doctor.getUsername());
        if(existing != null) {
            return false;
        }else {
            doctor.setOnDuty(false);
            doctor.setRole(Role.DOCTOR);
            this.userRepository.save(doctor);
            return true;
        }

    }

    @Override
    public User addAdministrator(User user) {
        user.setRole(Role.ADMINISTRATOR);
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.userRepository.findUserById(id);
        this.userRepository.delete(user);
    }


    @Override
    public List<User> getAllDoctors() {
        return this.userRepository.findAllByRole(Role.DOCTOR);
    }
}
