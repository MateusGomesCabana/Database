package projeto.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto.database.entity.RankingEntity;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Long> {
    @Query(value = "SELECT * FROM ranking f WHERE f.dificuldade like :dif ORDER BY tempo ASC LIMIT 3",
            nativeQuery = true)
    List<RankingEntity> findByDificuldade(String dif);

    @Query(value = "SELECT max(id) FROM ranking f ",
            nativeQuery = true)
    Long findByMaxId();

}
