
package com.example.payment.controller;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public String pay(@ModelAttribute PaymentRequest request,
                      RedirectAttributes redirectAttributes) {
        boolean success = paymentService.process(request);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "결제가 완료되었습니다!");
            return "redirect:/pay/success";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "결제에 실패했습니다. (중복 결제 또는 오류)");
            return "redirect:/pay/fail";
        }
    }

    @GetMapping("/pay/success")
    public String showSuccessPage(Model model) {
        return "pay-success";
    }

    @GetMapping("/pay/fail")
    public String showFailPage(Model model) {
        return "pay-fail";
    }
}
