package shoppingmall;

import shoppingmall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_UpdateStock(@Payload Shipped shipped){

        if(!shipped.validate()) return;

        System.out.println("\n\n##### listener UpdateStock : " + shipped.toJson() + "\n\n");

        // REST Request Sample
        shoppingmall.external.Order order =
           InventoryApplication.applicationContext.getBean(shoppingmall.external.OrderService.class)
           .getOrder(/** mapping value needed */);



        // Sample Logic //
        // Inventory inventory = new Inventory();
        // inventoryRepository.save(inventory);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}