package mjvapi.gameteam.repository;

import mjvapi.gameteam.model.BibliotecaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaModel, Long> {
}
