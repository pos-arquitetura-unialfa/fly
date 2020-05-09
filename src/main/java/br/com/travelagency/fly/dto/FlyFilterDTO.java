package br.com.travelagency.fly.dto;

import br.com.travelagency.fly.enums.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FlyFilterDTO {

    private String clientName;
    private LocalDateTime dateTimeDeparture;
    private ServiceStatus serviceStatus;

}
