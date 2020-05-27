package dao;

import entity.Atm;
import entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository  extends CrudRepository<Bank, Long> {
}
