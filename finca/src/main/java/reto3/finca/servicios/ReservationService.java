package reto3.finca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import reto3.finca.entidades.Reservations;
import reto3.finca.entidades.custom.CountClient;
import reto3.finca.entidades.custom.StatusAmount;
import reto3.finca.repositorios.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservations> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservations> getReservation(Long idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    public Reservations save(Reservations r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservations> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }

    public Reservations update(Reservations r){
        if(r.getIdReservation()!=null){
            Optional<Reservations>raux=reservationRepository.getReservation(r.getIdReservation());
            if(!raux.isEmpty()){
                if(r.getStartDate()!=null){
                    raux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    raux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    raux.get().setStatus(r.getStatus());
                }
                reservationRepository.save(raux.get());
                return raux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReservation(Long idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(r -> {
            reservationRepository.delete(r);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public StatusAmount getStatusReport(){
        List<Reservations> completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservations> cancelled=reservationRepository.getReservationsByStatus("cancelled");

        StatusAmount statAmt=new StatusAmount(completed.size(),cancelled.size());
        return statAmt;
    }

    public List<Reservations> getReservationPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }

    }

}
