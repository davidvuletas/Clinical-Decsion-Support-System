package sbnz.cdss.controller;

import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbnz.cdss.model.dto.DoctorDto;
import sbnz.cdss.model.dto.LoginDto;
import sbnz.cdss.model.dto.LogoutDto;
import sbnz.cdss.model.dto.UserDto;
import sbnz.cdss.model.entity.User;
import sbnz.cdss.service.UserService;
import sbnz.cdss.service.UtilService;

import java.util.HashMap;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UtilService utilService;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {

        User user = userService.login(loginDto.getUsername(), loginDto.getPassword());

        if (user != null) {
            UserDto dto = modelMapper.map(user, UserDto.class);
            this.utilService.createKieSession(user.getUsername());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("Invalid login");
    }

    @PostMapping("/add-doctor")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorDto doctorDto) {
        boolean added = this.userService.addDoctor(modelMapper.map(doctorDto, User.class));
        if (added) {
            return new ResponseEntity<>("Doctor was added successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("There are already doctor with that username,try again!", HttpStatus.CONFLICT);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutDto logoutDto) {
        this.sessions.get(logoutDto.getUsername()).dispose();
        this.sessions.remove(logoutDto.getUsername());
        return ResponseEntity.accepted().body(null);
    }
}
