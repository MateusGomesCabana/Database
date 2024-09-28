package projeto.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import projeto.database.entity.RankingEntity;
import projeto.database.repository.RankingRepository;
import jakarta.validation.Valid;
import projeto.database.service.RankingService;

import java.util.List;
@CrossOrigin
@RestController
public class RankingController {

    @Autowired
    private RankingService rankingService;


    @CrossOrigin
    @PostMapping("/saveRanking")
    @ResponseStatus(HttpStatus.CREATED)
    public RankingEntity saveRanking(@RequestBody RankingEntity rankingEntity){
        return rankingService.salvaRanking(rankingEntity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RankingEntity consultaPorId(@PathVariable Long id){
        return rankingService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ranking nao encontrado."));
    }



    @GetMapping("/api/jogo/hello")
    @ResponseStatus(HttpStatus.OK)
    public List<RankingEntity> consultaRankingPorDificuldade(@RequestParam String dificuldade){
        return rankingService.buscarRankingPorDificuldade(dificuldade);
    }
}