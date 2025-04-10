
package com.example.payment.service;

import com.example.payment.dto.PaymentRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PaymentService {

    private final Set<String> processedOrders = new HashSet<>();

    public boolean process(PaymentRequest request) {
        if (processedOrders.contains(request.getOrderId())) {
            return false;
        }
        System.out.println("결제 처리됨: 주문번호=" + request.getOrderId() + ", 금액=" + request.getAmount());
        processedOrders.add(request.getOrderId());
        return true;
    }
}
