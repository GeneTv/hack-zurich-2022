package hack.zurich.project.controller;


import hack.zurich.project.MatchingService;
import hack.zurich.project.database.models.Program;
import hack.zurich.project.database.models.User;
import hack.zurich.project.database.repositories.ProgramRepository;
import hack.zurich.project.database.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/program")
public class ProgramController {


    @Autowired
    ProgramRepository programRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MatchingService matchingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPrograms (@PathVariable Integer id) {

        User user = userRepository.findById(id).get(); // FIXME: Lul

        List<Program> ageFilteredPrograms = matchingService.filterForAge(user, programRepository.findAll());

        return new ResponseEntity<>(matchingService.matchUserToPrograms(user, ageFilteredPrograms), HttpStatus.OK);
    }

}
