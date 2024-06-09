package com.pp.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RequestDTO {
    private int codeRequest;
    private int codeClient;
    private List<ContentRequestDTO> itens;
}
