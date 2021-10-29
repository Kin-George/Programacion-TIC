package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    
}
