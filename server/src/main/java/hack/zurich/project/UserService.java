package hack.zurich.project;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import hack.zurich.project.database.models.Program;
import hack.zurich.project.database.models.Skill;
import hack.zurich.project.database.models.User;
import hack.zurich.project.database.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Gson gson;

    @Autowired
    private SkillRepository skillRepository;


    public List<Skill> getSkills (User incUser) {

        JsonArray skillIds = gson.fromJson(incUser.getSkills(), JsonArray.class);
        List<Skill> skillListOut = new ArrayList<>();

        skillIds.forEach(id -> {
            skillListOut.add(skillRepository.findById(id.getAsInt()).get()); //TODO: fix
        });

        return skillListOut;
    }

}
