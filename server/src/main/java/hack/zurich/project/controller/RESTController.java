package hack.zurich.project.controller;

import hack.zurich.project.database.models.User;
import hack.zurich.project.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public List<User> getUser() {
        int userid = 10;

        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
