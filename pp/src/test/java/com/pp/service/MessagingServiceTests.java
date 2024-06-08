package com.pp.service;

import com.pp.models.entitys.Request;
import com.pp.models.entitys.ContentRequest;
import com.pp.repository.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessagingServiceTest {

    private MessagingService messagingService;

    @Mock
    private RequestRepository requestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messagingService = new MessagingService(requestRepository);
    }

    @Test
    void calculateTotalValue() {
        Request request = new Request();
        ContentRequest contentRequest1 = new ContentRequest("Product 1", 10, 5.0);
        ContentRequest contentRequest2 = new ContentRequest("Product 2", 5, 3.0);
        request.setItens(Arrays.asList(contentRequest1, contentRequest2));

        when(requestRepository.save(request)).thenReturn(request);

        Request savedRequest = messagingService.saveRequest(request);

        assertEquals(10 * 5.0 + 5 * 3.0, savedRequest.getTotalValue());
    }

    @Test
    void repositorySave() {
        Request request = new Request();

        when(requestRepository.save(request)).thenReturn(request);

        messagingService.saveRequest(request);

        verify(requestRepository, times(1)).save(request);
    }
}
