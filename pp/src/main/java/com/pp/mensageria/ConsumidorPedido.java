package com.pp.mensageria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.models.dto.ItemPedido;
import com.pp.models.dto.Pedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorPedido {

    private final ObjectMapper objectMapper;

    public ConsumidorPedido(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "fila-pedidos")
    public void consumeMessage(String mensagemJson) {
        try {
            Pedido pedido = objectMapper.readValue(mensagemJson, Pedido.class);
            System.out.println("Mensagem recebida:");
            System.out.println("Código do Pedido: " + pedido.getCodigoPedido());
            System.out.println("Código do Cliente: " + pedido.getCodigoCliente());
            System.out.println("Itens do Pedido:");
            for (ItemPedido item : pedido.getItens()) {
                System.out.println("  Produto: " + item.getProduto());
                System.out.println("  Quantidade: " + item.getQuantidade());
                System.out.println("  Preço: " + item.getPreco());
            }
            // Adicione aqui a lógica para processar a mensagem
        } catch (Exception e) {
            System.out.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}
