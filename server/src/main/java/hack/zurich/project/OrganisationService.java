package hack.zurich.project;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import hack.zurich.project.database.models.Organisation;
import hack.zurich.project.database.models.Program;
import hack.zurich.project.database.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    private Gson gson;

    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getPrograms(Organisation incOrganisation) {

        JsonArray programIds = gson.fromJson(incOrganisation.getPrograms(), JsonArray.class);
        List<Program> programListOut = new ArrayList<>();

        programIds.forEach(id -> {
            programListOut.add(programRepository.findById(id.getAsInt()).get()); //TODO: fix
        });

        return programListOut;
    }



}
