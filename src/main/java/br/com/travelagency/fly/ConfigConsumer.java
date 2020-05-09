package br.com.travelagency.fly;

import static br.com.travelagency.fly.ActiveMQConfigClient.PAYMENT_RESERVE_VOO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.travelagency.fly.dto.FlyFilterDTO;
import br.com.travelagency.fly.service.ReserveServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configuration
public class ConfigConsumer   {
	
	@Autowired
	private ReserveServiceImpl reserveService;
	
	@JmsListener(destination = PAYMENT_RESERVE_VOO)
    public void receiveMessage(@Payload String payladPaymentCar) {
				
        if(!payladPaymentCar.equals(null)) {
        	try {
        		
        		Gson convert = new Gson();
        		
        		FlyFilterDTO objectConverted = convert.fromJson(payladPaymentCar, FlyFilterDTO.class);
        		
        		System.out.println(objectConverted);
        		
        		//reserveService.updateServiceStatus(objectConverted.getId());
        		
        		System.out.println(payladPaymentCar);
			} catch (Exception e) {
				log.error("Erro ao processar..", e);
			}
        }else {
        	
        	log.info("nada encontrado");
        }
    }
}
