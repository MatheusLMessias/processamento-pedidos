package com.pp.service;

import com.pp.models.entity.Request;
import com.pp.repository.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApiServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private ApiService apiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTotalValue() {
        Request request = new Request();
        request.setTotalValue(100.0);
        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));

        Double totalValue = apiService.getTotalValue(1L);
        assertNotNull(totalValue);
        assertEquals(100.0, totalValue);
    }

    @Test
    void testGetTotalValueNotExist() {
        when(requestRepository.findById(1L)).thenReturn(Optional.empty());

        Double totalValue = apiService.getTotalValue(1L);
        assertNull(totalValue);
    }

    @Test
    void testCountRequestsByClient() {
        when(requestRepository.countByCodeClient(1)).thenReturn(5L);

        Long count = apiService.countRequestsByClient(1);
        assertEquals(5L, count);
    }

    @Test
    void testFindRequestsByClient() {
        Request request1 = new Request();
        Request request2 = new Request();
        List<Request> requests = Arrays.asList(request1, request2);
        when(requestRepository.findByCodeClient(1)).thenReturn(requests);

        List<Request> result = apiService.findRequestsByClient(1);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(request1));
        assertTrue(result.contains(request2));
    }
}
