package reto3.finca.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.finca.repositorios.ScoreRepository;
import reto3.finca.entidades.Score;

@Service
public class ScoreService {
    @Autowired
    public
    ScoreRepository scoreRepository;

    public List<Score> getScores(){
        return scoreRepository.getScores();
    }

    public  Optional<Score> getScore(Long id){
        return scoreRepository.getScoreById(id);
    }

    public Score saveScore(Score Score){
        return scoreRepository.saveScore(Score);
    }
    
    public Score updateScore(Score score){
        if (score != null) {
            if (score.getIdScore() != null){
                Optional<Score> oScore = getScore(score.getIdScore());
                if (!oScore.isEmpty()){
                    Score sco = oScore.get();
                    if (score.getCalificacion() !=null){
                        sco.setCalificacion(score.getCalificacion());
                    }
                    if (score.getMessageText() !=null){
                        sco.setMessageText(score.getMessageText());
                    }
                    if (score.getReservations() !=null){
                        sco.setReservations(score.getReservations());
                    }
                    return scoreRepository.saveScore(sco);
                }
            }
        }
        return score;
    }
    

    public void deleteAll(){
        scoreRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Score> oScore = getScore(id);
        if (!oScore.isEmpty()){
            scoreRepository.deleteScore(oScore.get());                        
        }        
    }
    
}
