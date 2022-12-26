package com.sda.pos.controller;

import com.sda.pos.model.POSRefund;
import com.sda.pos.model.POSRefundCreate;
import com.sda.pos.service.RefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Customer support")
@RequestMapping("/customer-support")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }


    @Operation(summary = "Get refund by requestId")
    @GetMapping(value = "/refund/{requestId}/downloadInvoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public POSRefund getRefundByRequestId(@PathVariable("requestId") Long requestId){
        return refundService.getRefundByRequestId(requestId);
    }

    @Operation(summary = "Post a refund")
    @PostMapping(value = "/refund", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveRefund(@RequestBody POSRefundCreate refund){
        refundService.saveRefund(
                refund.getUserId(),
                refund.getOrderId(),
                refund.getName(),
                refund.getDescription()
        );
    }

    @Operation(summary = "Finalize a refund")
    @PutMapping(value = "/refund/{requestId}/finalize", produces = MediaType.APPLICATION_JSON_VALUE)
    public void finalizeRefund(@PathVariable("requestId") Long requestId){
        refundService.finalizeRefund(requestId);
    }
}
