package dao;

import entity.Atm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends CrudRepository<Atm, Long> {
}
