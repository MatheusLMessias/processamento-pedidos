package com.pp.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.models.dto.ContentRequestDTO;
import com.pp.models.dto.RequestDTO;
import com.pp.models.entity.ContentRequest;
import com.pp.models.entity.Request;
import com.pp.service.MessagingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private final ObjectMapper objectMapper;
    private final MessagingService messagingService;

    public MessageConsumer(ObjectMapper objectMapper, MessagingService messagingService) {
        this.objectMapper = objectMapper;
        this.messagingService = messagingService;
    }

    @RabbitListener(queues = "queue-requests")
    public void consumeMessage(String mensagemJson) {
        try {
            RequestDTO requestDTO = objectMapper.readValue(mensagemJson, RequestDTO.class);

            Request request = new Request();
            request.setCodeRequest(requestDTO.getCodeRequest());
            request.setCodeClient(requestDTO.getCodeClient());

            double totalValue = 0.0;
            for (ContentRequestDTO itemDTO : requestDTO.getItens()) {
                ContentRequest item = new ContentRequest();
                item.setProduct(itemDTO.getProduct());
                item.setQuantity(itemDTO.getQuantity());
                item.setValue(itemDTO.getValue());
                item.setRequest(request);
                request.getItens().add(item);

                totalValue += itemDTO.getQuantity() * itemDTO.getValue();
            }
            request.setTotalValue(totalValue);
            messagingService.saveRequest(request);
        } catch (Exception e) {
            System.out.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}
