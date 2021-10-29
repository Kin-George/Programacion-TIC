package reto3.finca.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reto3.finca.entidades.Reservations;
import java.util.List;
import java.util.Date;

public interface ReservationCrudRepository extends CrudRepository<Reservations, Long> {

    //JPQl
    @Query("select c.client, COUNT(c.client) from Reservations AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();

    //QUERY METHODS!
    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Reservations> findAllByStatus(String statusAAA);
}
