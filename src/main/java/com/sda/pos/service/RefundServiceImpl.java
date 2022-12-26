package com.sda.pos.service;

import com.sda.pos.enums.RefundStatus;
import com.sda.pos.model.POSRefund;
import com.sda.pos.repository.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository;

    public RefundServiceImpl(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }


    @Override
    public void saveRefund(Long userId, Long orderId, String name, String description) {
        POSRefund newRefund = new POSRefund(userId, orderId, name, description);
        refundRepository.save(newRefund);
    }

    @Override
    public void finalizeRefund(Long requestId) {
        if(refundRepository.existsById(requestId)){
            POSRefund refundInfo = refundRepository.findById(requestId).orElse(null);
            if (refundInfo != null) {
                refundInfo.setStatus(RefundStatus.FINALIZED);
                refundRepository.save(refundInfo);
            }
        }
        else {
            throw new NoSuchElementException("Refund with this id does not exist");
        }
    }

    @Override
    public POSRefund getRefundByRequestId(Long requestId) {
        return refundRepository.findById(requestId).orElseThrow();
    }
}
