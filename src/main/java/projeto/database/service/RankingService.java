package projeto.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.database.entity.RankingEntity;
import projeto.database.repository.RankingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public RankingEntity salvaRanking(RankingEntity rankingEntity){
        rankingEntity.setId(rankingRepository.findByMaxId()+1);
        return rankingRepository.save(rankingEntity);
    }

    public Optional<RankingEntity> buscarPorId(Long id){
        return rankingRepository.findById(id);
    }


    public List<RankingEntity> buscarRankingPorDificuldade(String dificuldade) {
        return rankingRepository.findByDificuldade(dificuldade);
    }
}
