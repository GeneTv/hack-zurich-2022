package hack.zurich.project.controller;

import hack.zurich.project.database.models.User;
import hack.zurich.project.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> createUser(@RequestBody User incUser) {

        if (userRepository.existsByName(incUser.getName())) return new ResponseEntity<>( "User does already exist :(", HttpStatus.CREATED);

        User user = User.builder()
                        .name(incUser.getName())
                        .age(incUser.getAge())
                        .isOnboarding(true)
                        .build();

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }


}
