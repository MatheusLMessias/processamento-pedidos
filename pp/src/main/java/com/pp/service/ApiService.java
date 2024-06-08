package com.pp.service;

import com.pp.models.entity.Request;
import com.pp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {

    private final RequestRepository requestRepository;

    @Autowired
    public ApiService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Double getTotalValue(long codeRequest) {
        Optional<Request> request = requestRepository.findById(codeRequest);
        return request.map(Request::getTotalValue).orElse(null);
    }
    public Long countRequestsByClient(int codeClient) {
        return requestRepository.countByCodeClient(codeClient);
    }

    public List<Request> findRequestsByClient(int codeClient) {
        return requestRepository.findByCodeClient(codeClient);
    }
}
