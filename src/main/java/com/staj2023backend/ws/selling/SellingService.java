package com.staj2023backend.ws.selling;

import org.springframework.stereotype.Service;

@Service
public class SellingService {

    SellingRepository sellingRepository;

    public SellingService(SellingRepository sellingRepository) {
        this.sellingRepository = sellingRepository;
    }

}
