package dao;

import entity.AbstractAcount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AbstractAcount,Long> {
}
