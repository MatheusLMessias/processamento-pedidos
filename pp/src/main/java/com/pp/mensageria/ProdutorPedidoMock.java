package com.pp.mensageria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.models.dto.ItemPedido;
import com.pp.models.dto.Pedido;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutorPedidoMock {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProdutorPedidoMock(RabbitTemplate rabbitTemplate, Queue queue, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void mockarMensagens() {
        try {
            for (int i = 1; i <= 10; i++) {
                Pedido mensagem = criarMensagemMock(i);
                String mensagemJson = objectMapper.writeValueAsString(mensagem);
                rabbitTemplate.convertAndSend(queue.getName(), mensagemJson);
                System.out.println("Mensagem " + i + " enviada para a fila." + queue.getName() + mensagemJson);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mockar mensagens: " + e.getMessage());
        }
    }

    private Pedido criarMensagemMock(int numeroMensagem) {
        Pedido mensagem = new Pedido();
        mensagem.setCodigoPedido(1000 + numeroMensagem);
        mensagem.setCodigoCliente(numeroMensagem);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido("Produto " + numeroMensagem, numeroMensagem * 10, numeroMensagem * 1.10));
        mensagem.setItens(itens);

        return mensagem;
    }
}
