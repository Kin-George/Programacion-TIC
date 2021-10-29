package reto3.finca.repositorios;

import java.util.Optional;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.Client;
import reto3.finca.entidades.Reservations;
import reto3.finca.entidades.custom.CountClient;


@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservations> getAll() {
        return (List<Reservations>) reservationCrudRepository.findAll();
    }

    public Optional<Reservations> getReservation(Long idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservations save(Reservations r) {
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservations r){
        reservationCrudRepository.delete(r);
    }

    public List<Reservations> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservations> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }

}
