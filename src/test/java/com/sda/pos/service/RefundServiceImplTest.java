package com.sda.pos.service;

import com.sda.pos.model.POSRefund;
import com.sda.pos.repository.RefundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RefundServiceImplTest {
    @Mock
    private RefundRepository refundRepository;

    @InjectMocks
    private RefundServiceImpl refundService;

    private POSRefund refund;

    @BeforeEach
    public void setup(){
        refund = new POSRefund(1L, 1L, "testName", "test Description");
    }

    @DisplayName("JUnit test for saveRefund method")
    @Test
    public void givenRefundObject_whenSaveRefund_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(refundRepository.save(refund)).willReturn(refund);

        // when -  action or the behaviour that we are going test
        refundService.saveRefund(
                refund.getUserId(),
                refund.getOrderId(),
                refund.getName(),
                refund.getDescription()
        );

        // then - verify the output
        verify(refundRepository, times(1)).save(refund);
    }

    @DisplayName("JUnit test for getRefundByRequestId method")
    @Test
    public void givenRefundId_whenGetRefundByRequestId_thenReturnRefundObject() {
        // given
        given(refundRepository.findById(refund.getRequestId())).willReturn(Optional.ofNullable(refund));

        // when
        POSRefund newRefund = refundService.getRefundByRequestId(refund.getRequestId());

        // then
        assertThat(newRefund).isNotNull();
    }


    @DisplayName("JUnit test for getRefundByRequestId method which throws exception")
    @Test
    public void givenRefundId_whenGetRefundByRequestId_thenThrowsException(){
        // given - precondition or setup
        given(refundRepository.findById(refund.getRequestId())).willReturn(Optional.empty());
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                refundService.getRefundByRequestId(refund.getRequestId()));
    }

    @DisplayName("JUnit test for finalizeRefund method")
    @Test
    public void givenRefundId_whenFinalizeRefund_thenRepositoryExistsAndSaveWereInvoked() {
        // given

        refund.setRequestId(2L);
        given(refundRepository.existsById(refund.getRequestId())).willReturn(true);
        given(refundRepository.findById(refund.getRequestId())).willReturn(Optional.ofNullable(refund));

        // when
        refundService.finalizeRefund(
                refund.getRequestId()
        );

        // then
        verify(refundRepository, times(1)).existsById(refund.getRequestId());
        verify(refundRepository, times(1)).save(refund);
    }

    @DisplayName("JUnit test for finalizeRefund method which throws exception")
    @Test
    public void givenRefundId_whenFinalizeRefund_thenThrowsException() {
        // given

        given(refundRepository.findById(refund.getRequestId())).willReturn(Optional.empty());

        // when
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                refundService.finalizeRefund(refund.getRequestId()));

    }
}