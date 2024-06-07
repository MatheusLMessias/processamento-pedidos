package com.pp.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "request")
@Getter
@Setter
public class Request {
    @Id
    private int codeRequest;
    private int codeClient;
    private Double totalValue;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContentRequest> itens = new ArrayList<>();
}
