package controllers;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
        //return "Order Id "  + requestDto.getOrderId();
        return paymentService.initiatePayment(
                requestDto.getOrderId(),
                requestDto.getEmail()
        );
    }
}