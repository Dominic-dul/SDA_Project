package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrder;
import com.sda.pos.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private POSOrder order;

    @BeforeEach
    public void setup(){
        Timestamp date = Timestamp.from(Instant.now());
        order = new POSOrder(1L, date, date, date, "testString", OrderStatus.FINISHED, "testId");
    }

    @DisplayName("JUnit test for saveOrder method")
    @Test
    public void givenOrderObject_whenSaveOrder_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(orderRepository.save(order)).willReturn(order);

        // when -  action or the behaviour that we are going test
        orderService.saveOrder(order.getUserId(), order.getStartDate(), order.getEndDate(), order.getEstimatedEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId());

        // then - verify the output
        verify(orderRepository, times(1)).save(order);
    }

    @DisplayName("JUnit test for getOrders method")
    @Test
    public void givenOrderList_whenGetOrders_thenReturnOrderList(){
        // given - precondition or setup
        given(orderRepository.findAll()).willReturn(List.of(order));

        // when -  action or the behaviour that we are going test
        List<POSOrder> orderList = orderService.getOrders();

        // then - verify the output
        assertThat(orderList).isNotNull();
        assertThat(orderList.size()).isEqualTo(1);
    }

    @DisplayName("JUnit test for updateOrder method")
    @Test
    public void givenOrderObject_whenUpdateOrder_thenRepositoryDeleteAndExistsAndSaveWereInvoked(){
        // given - precondition or setup
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.ofNullable(order));
        given(orderRepository.existsById(order.getUserId())).willReturn(true);

        // when -  action or the behaviour that we are going test
        orderService.updateOrder(order.getUserId(), order.getStartDate(), order.getEndDate(), order.getEstimatedEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId());

        // then - verify the output
        verify(orderRepository, times(1)).existsById(order.getUserId());
        verify(orderRepository, times(1)).findById(order.getUserId());
        verify(orderRepository, times(1)).save(order);
    }

    @DisplayName("JUnit test for updateOrderStatusToConfirmed method")
    @Test
    public void givenOrderId_whenUpdateOrderStatusToConfirmed_thenRepositoryFindAndDeleteAndExistsAndSaveWereInvoked(){
        // given - precondition or setup
        given(orderRepository.existsById(order.getUserId())).willReturn(true);
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.ofNullable(order));

        // when -  action or the behaviour that we are going test
        orderService.updateOrderStatusToConfirmed(order.getUserId());

        // then - verify the output
        verify(orderRepository, times(1)).existsById(order.getUserId());
        verify(orderRepository, times(1)).findById(order.getUserId());
        verify(orderRepository, times(1)).save(order);
    }

    @DisplayName("JUnit test for getOrderStatus method")
    @Test
    public void givenOrderId_whenGetOrderStatus_thenReturnOrderStatus(){
        // given
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.ofNullable(order));

        // when
        OrderStatus orderStatus = orderService.getOrderStatus(order.getUserId());

        // then
        assertThat(orderStatus).isNotNull();
    }

    @DisplayName("JUnit test for getOrderByUserId method")
    @Test
    public void givenOrderId_whenGetOrderByUserId_thenReturnOrderObject(){
        // given
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.ofNullable(order));

        // when
        POSOrder newOrder = orderService.getOrderByUserId(order.getUserId());

        // then
        assertThat(newOrder).isNotNull();
    }

    @DisplayName("JUnit test for getCompletedOrders method")
    @Test
    public void givenOrderList_whenGetCompletedOrders_thenReturnOrderList(){
        // given - precondition or setup
        given(orderRepository.findAll()).willReturn(List.of(order));

        // when -  action or the behaviour that we are going test
        List<POSOrder> completedOrderList = orderService.getCompletedOrders();

        // then - verify the output
        assertThat(completedOrderList).isNotNull();
        assertThat(completedOrderList.size()).isEqualTo(1);
    }

    @DisplayName("JUnit test for updateOrder method which throws exception")
    @Test
    public void givenOrderDetails_whenUpdateOrder_thenThrowsException(){
        // given - precondition or setup
        given(orderRepository.existsById(order.getUserId())).willReturn(false);
        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                orderService.updateOrder(order.getUserId(), order.getStartDate(), order.getEndDate(), order.getEstimatedEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId()));

        verify(orderRepository, never()).findById(order.getUserId());
        verify(orderRepository, never()).save(order);
    }

    @DisplayName("JUnit test for updateOrderStatusToConfirmed method which throws exception")
    @Test
    public void givenOrderDetails_whenUpdateOrderStatusToConfirmed_thenThrowsException(){
        // given - precondition or setup
        given(orderRepository.existsById(order.getUserId())).willReturn(false);
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                orderService.updateOrderStatusToConfirmed(order.getUserId()));

        verify(orderRepository, never()).findById(order.getUserId());
        verify(orderRepository, never()).save(order);
    }

    @DisplayName("JUnit test for getOrderStatus method which throws exception")
    @Test
    public void givenOrderId_whenGetOrderStatus_thenThrowsException(){
        // given - precondition or setup
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.empty());
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                orderService.getOrderStatus(order.getUserId()));
    }

    @DisplayName("JUnit test for getOrderByUserId method which throws exception")
    @Test
    public void givenOrderId_whenGetOrderByUserId_thenThrowsException(){
        // given - precondition or setup
        given(orderRepository.findById(order.getUserId())).willReturn(Optional.empty());
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                orderService.getOrderByUserId(order.getUserId()));
    }
}