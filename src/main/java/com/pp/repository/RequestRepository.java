package com.pp.repository;

import com.pp.models.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Long countByCodeClient(int codeClient);
    List<Request> findByCodeClient(int codeClient);
}
