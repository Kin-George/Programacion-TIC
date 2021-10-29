package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.Score;

@Repository
public interface ScoreCrudRepository extends CrudRepository<Score, Long> {
    
}
