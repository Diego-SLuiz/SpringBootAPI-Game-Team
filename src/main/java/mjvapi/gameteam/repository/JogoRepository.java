package mjvapi.gameteam.repository;

import mjvapi.gameteam.model.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, Long> {
}
