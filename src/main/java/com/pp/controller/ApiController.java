package com.pp.controller;

import com.pp.models.dto.RequestDTO;
import com.pp.models.entity.Request;
import com.pp.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/totalValue")
    public Double getTotalValue(@RequestBody RequestDTO requestDTO) {
        return apiService.getTotalValue(requestDTO.getCodeRequest());
    }

    @GetMapping("/client/count")
    public Long countRequestsByClient(@RequestBody RequestDTO requestDTO) {
        return apiService.countRequestsByClient(requestDTO.getCodeClient());
    }

    @GetMapping("/client/list")
    public List<Request> listRequestsByClient(@RequestBody RequestDTO requestDTO) {
        return apiService.findRequestsByClient(requestDTO.getCodeClient());
    }
}