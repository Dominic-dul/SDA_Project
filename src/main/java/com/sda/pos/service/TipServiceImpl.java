package com.sda.pos.service;

import com.sda.pos.model.POSTip;
import com.sda.pos.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TipServiceImpl implements TipService {

    private final TipRepository tipRepository;

    public TipServiceImpl(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @Override
    public void saveTip(BigDecimal amount, Long orderId) {
        POSTip newTip = new POSTip(amount, orderId);
        tipRepository.save(newTip);
    }

    @Override
    public List<POSTip> getTips() {
        return tipRepository.findAll();
    }
}
