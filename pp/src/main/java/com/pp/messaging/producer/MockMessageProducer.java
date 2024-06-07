package com.pp.messaging.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.models.dto.ContentRequestDTO;
import com.pp.models.dto.RequestDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper objectMapper;

    @Autowired
    public MockMessageProducer(RabbitTemplate rabbitTemplate, Queue queue, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void mockMessage() {
        try {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 10; j++) {
                    RequestDTO message = createMessageMock(i, 1000 + i * 10 + j, i);
                    String messageJson = objectMapper.writeValueAsString(message);
                    rabbitTemplate.convertAndSend(queue.getName(), messageJson);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao mockar mensagens: " + e.getMessage());
        }
    }

    private RequestDTO createMessageMock(int numberClient, int codeRequest, int codeClient) {
        RequestDTO message = new RequestDTO();
        message.setCodeRequest(codeRequest);
        message.setCodeClient(codeClient);

        List<ContentRequestDTO> itens = new ArrayList<>();
        itens.add(new ContentRequestDTO("Produto " + ((numberClient - 1) * 10 + 1), ((numberClient - 1) * 10 + 1) * 10, ((numberClient - 1) * 10 + 1) * 1.10));
        itens.add(new ContentRequestDTO("Produto " + ((numberClient - 1) * 10 + 2), ((numberClient - 1) * 10 + 2) * 10, ((numberClient - 1) * 10 + 2) * 1.10));

        message.setItens(itens);

        return message;
    }
}
