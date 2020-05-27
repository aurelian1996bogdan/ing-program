package service;

import dao.AtmRepository;
import entity.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    AtmRepository atmRepository;


    @Override
    public void save(Atm atm) {
        atmRepository.save(atm);
    }


    @Override
    public void delete(Atm atm) {
        atmRepository.delete(atm);
    }

}
