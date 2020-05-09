package br.com.travelagency.fly.model;

import br.com.travelagency.fly.enums.ServiceStatus;
import br.com.travelagency.fly.enums.converter.ServiceStatusConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "RESERVAS")
public class Reserve {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NOME_CLIENTE")
    private String clientName;

    @Column(name = "CIDADE_ORIGEM")
    private String departureCity;

    @Column(name = "CIDADE_DESTINO")
    private String destinationCity;

    @Column(name = "PRECO")
    private BigDecimal price;

    @Column(name = "DATA_HORA_SAIDA")
    private LocalDateTime dateTimeDeparture;

    @Convert(converter = ServiceStatusConverter.class)
    @Column(name = "STATUS_SERVICO")
    private ServiceStatus serviceStatus;

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", price=" + price +
                ", dateTimeDeparture=" + dateTimeDeparture +
                ", serviceStatus=" + serviceStatus +
                '}';
    }
}
