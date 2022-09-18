package hack.zurich.project;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import hack.zurich.project.database.models.Program;
import hack.zurich.project.database.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MatchingService {

    @Autowired
    private Gson gson;


    public HashMap<Integer, Program> matchUserToPrograms (User incUser, List<Program> incPrograms) {

        JsonArray userSkillIds = gson.fromJson(incUser.getSkills(), JsonArray.class);

        HashMap<Integer, Program> matchingPrograms = new HashMap<Integer, Program>();

        incPrograms.forEach(program -> {
            JsonArray requiredSkillsIds = gson.fromJson(program.getRequired_skills(), JsonArray.class);
            AtomicReference<Integer> matchCounter = new AtomicReference<>(0);

            requiredSkillsIds.forEach(requiredSkillId -> {
                if (userSkillIds.contains(requiredSkillId)) {
                    matchCounter.getAndSet(matchCounter.get() + 1);
                }
            });

            int matchRatio = matchCounter.get() != 0 ? requiredSkillsIds.size() / matchCounter.get() : 0;

            if (matchRatio > 0.8) {
                matchingPrograms.put(matchRatio, program);
            }


        });

        return matchingPrograms;

    }

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
