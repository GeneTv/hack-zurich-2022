package hack.zurich.project;


import hack.zurich.project.database.models.Program;
import hack.zurich.project.database.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilterService {

    public List<Program> filterForAge(User incUser, List<Program> incPrograms) {

        List<Program> programListOut = new ArrayList<>();

        incPrograms.forEach(program -> {
            List<String> minMaxAge = Arrays.stream(program.getRequired_age().split("-")).toList();

            int minAge = Integer.parseInt(minMaxAge.get(0));
            int maxAge = Integer.parseInt(minMaxAge.get(1));

            if(incUser.getAge() <= maxAge && incUser.getAge() >= minAge) {
                programListOut.add(program);
            }

        });

        return programListOut;
    }

}
