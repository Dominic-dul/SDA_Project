package com.sda.pos.service;

import com.sda.pos.model.POSRefund;

public interface RefundService {

    void saveRefund(Long userId, Long orderId, String name, String description);

    void finalizeRefund(Long requestId);

    POSRefund getRefundByRequestId(Long requestId);
}
