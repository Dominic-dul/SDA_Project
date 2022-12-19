package com.sda.pos.service;

import com.sda.pos.model.POSOrderProduct;
import com.sda.pos.repository.OrderProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderProductServiceImplTest {
    @Mock
    private OrderProductRepository orderProductRepository;

    @InjectMocks
    private OrderProductServiceImpl orderProductService;

    private POSOrderProduct orderProduct;

    @BeforeEach
    public void setup(){
        orderProduct = new POSOrderProduct(1L, 2L);
    }

    @DisplayName("JUnit test for saveOrderProduct method")
    @Test
    public void givenOrderProductObject_whenSaveOrderProduct_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(orderProductRepository.save(orderProduct)).willReturn(orderProduct);

        // when -  action or the behaviour that we are going test
        orderProductService.saveOrderProduct(orderProduct.getProductId(), orderProduct.getOrderId());

        // then - verify the output
        verify(orderProductRepository, times(1)).save(orderProduct);
    }

    @DisplayName("JUnit test for deleteOrderProduct method")
    @Test
    public void givenOrderProductId_whenDeleteOrderProduct_thenRepositoryDeleteeWasInvoked(){
        // given - precondition or setup
        given(orderProductRepository.findAll()).willReturn(List.of(orderProduct));
        willDoNothing().given(orderProductRepository).deleteById(orderProduct.getOrderProductId());

        // when -  action or the behaviour that we are going test
        orderProductService.deleteOrderProduct(orderProduct.getProductId(), orderProduct.getOrderId());

        // then - verify the output
        verify(orderProductRepository, times(1)).deleteById(orderProduct.getOrderProductId());
    }

    @DisplayName("JUnit test for getOrderProducts method")
    @Test
    public void givenOrderProductList_whenGetOrderProducts_thenReturnOrderProductList(){
        // given - precondition or setup
        given(orderProductRepository.findAll()).willReturn(List.of(orderProduct));

        // when -  action or the behaviour that we are going test
        List<POSOrderProduct> orderProductList = orderProductService.getOrderProducts();

        // then - verify the output
        assertThat(orderProductList).isNotNull();
        assertThat(orderProductList.size()).isEqualTo(1);
    }
}