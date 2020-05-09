package br.com.travelagency.fly.service;

import br.com.travelagency.fly.dto.FlyFilterDTO;
import br.com.travelagency.fly.enums.ServiceStatus;
import br.com.travelagency.fly.model.Reserve;

import java.time.LocalDateTime;
import java.util.List;

public interface ReserveService {

    List<Reserve> findByFilter(FlyFilterDTO filter);

    Reserve reserve(Reserve reserve);

}
