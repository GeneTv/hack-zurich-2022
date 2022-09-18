package hack.zurich.project.database.repositories;

import hack.zurich.project.database.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
