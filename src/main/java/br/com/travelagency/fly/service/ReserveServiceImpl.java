package br.com.travelagency.fly.service;

import br.com.travelagency.fly.dto.FlyFilterDTO;
import br.com.travelagency.fly.enums.ServiceStatus;
import br.com.travelagency.fly.model.Reserve;
import br.com.travelagency.fly.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepository repository;

    @Override
    public List<Reserve> findByFilter(FlyFilterDTO filterDTO) {
        return repository.findByClientNameIgnoreCaseAndDateTimeDepartureOrServiceStatus(filterDTO.getClientName(), filterDTO.getDateTimeDeparture(), filterDTO.getServiceStatus());
    }

    @Override
    public Reserve reserve(Reserve reserve) {
        reserve.setServiceStatus(ServiceStatus.REQUEST);
        return repository.save(reserve);
    }
}
