package com.pp.service;

import com.pp.models.entitys.Request;
import com.pp.repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    private RequestRepository requestRepository;

    public MessagingService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Transactional
    public Request saveRequest(Request request) {
        Double totalValue = request.getItens().stream()
                .mapToDouble(item -> {
                    Double value = item.getValue();
                    return value != null ? value * item.getQuantity() : 0.0;
                })
                .sum();
        request.setTotalValue(totalValue);
        return requestRepository.save(request);
    }
}
