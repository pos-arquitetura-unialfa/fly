package br.com.travelagency.fly;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQConfigClient {

    public static final String PAYMENT_RESERVE_VOO = "PagamentoReservaVoo";
    
}
