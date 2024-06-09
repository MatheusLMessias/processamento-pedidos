package com.pp.controller;

import com.pp.models.entity.Request;
import com.pp.service.ApiService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    void testGetTotalValue() throws Exception {
        Mockito.when(apiService.getTotalValue(1L)).thenReturn(100.0);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/totalValue")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codeRequest\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("100.0"));
    }

    @Test
    void testCountRequestsByClient() throws Exception {
        Mockito.when(apiService.countRequestsByClient(1)).thenReturn(5L);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client/count")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codeClient\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void testListRequestsByClient() throws Exception {
        Request request = new Request();
        request.setCodeRequest(1);
        request.setCodeClient(1);
        request.setTotalValue(100.0);

        Mockito.when(apiService.findRequestsByClient(1)).thenReturn(Collections.singletonList(request));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codeClient\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"codeRequest\":1,\"codeClient\":1,\"totalValue\":100.0}]"));
    }
}
