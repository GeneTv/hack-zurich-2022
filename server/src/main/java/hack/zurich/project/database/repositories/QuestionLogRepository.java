package hack.zurich.project.database.repositories;

import hack.zurich.project.database.models.QuestionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLogRepository extends JpaRepository<QuestionLog, Integer> {
}
