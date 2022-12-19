package com.sda.pos.service;

import com.sda.pos.model.POSTip;
import com.sda.pos.repository.TipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TipServiceImplTest {

    @Mock
    private TipRepository tipRepository;

    @InjectMocks
    private TipServiceImpl tipService;

    private POSTip tip;

    @BeforeEach
    public void setup(){
        tip = new POSTip(BigDecimal.ONE, 1L);
    }

    @DisplayName("JUnit test for saveTip method")
    @Test
    public void givenTipAmountAndOrderId_whenSaveTip_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(tipRepository.save(tip)).willReturn(tip);

        // when -  action or the behaviour that we are going test
        tipService.saveTip(tip.getAmount(), tip.getOrderId());

        // then - verify the output
        verify(tipRepository, times(1)).save(tip);
    }

    @DisplayName("JUnit test for getTips method")
    @Test
    public void givenTipList_whenGetTips_thenReturnTipList(){
        // given - precondition or setup
        given(tipRepository.findAll()).willReturn(List.of(tip));

        // when -  action or the behaviour that we are going test
        List<POSTip> tipList = tipService.getTips();

        // then - verify the output
        assertThat(tipList).isNotNull();
        assertThat(tipList.size()).isEqualTo(1);
    }
}