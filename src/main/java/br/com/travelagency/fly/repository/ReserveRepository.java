package br.com.travelagency.fly.repository;

import br.com.travelagency.fly.enums.ServiceStatus;
import br.com.travelagency.fly.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    List<Reserve> findByClientNameIgnoreCaseAndDateTimeDepartureOrServiceStatus(String clientName, LocalDateTime dateTimeDeparture, ServiceStatus serviceStatus);

}
