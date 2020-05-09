package br.com.travelagency.fly.resource;

import br.com.travelagency.fly.dto.FlyFilterDTO;
import br.com.travelagency.fly.enums.ServiceStatus;
import br.com.travelagency.fly.model.Reserve;
import br.com.travelagency.fly.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/flyReserves")
public class FlyReserveResource {

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    private List<Reserve> find(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTimeDeparture, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.reserveService.findByFilter(new FlyFilterDTO(clientName, dateTimeDeparture, serviceStatus));
    }

    @PostMapping
    public Reserve reserve(@RequestBody Reserve reserve){
        return this.reserveService.reserve(reserve);
    }



}
