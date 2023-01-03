package com.sda.pos.service;

import com.sda.pos.enums.DiscountType;
import com.sda.pos.model.POSDiscount;
import com.sda.pos.repository.DiscountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DiscountServiceImplTest {
    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountServiceImpl discountService;

    private POSDiscount discount;

    @BeforeEach
    public void setup(){
        discount = new POSDiscount(1L, 1L,20.0,2.0, DiscountType.NORMAL);
    }

    @DisplayName("JUnit test for getDiscounts method")
    @Test
    public void givenDiscountsList_whenGetDiscounts_thenReturnDiscountsList(){
        // given - precondition or setup
        given(discountRepository.findAll()).willReturn(List.of(discount));

        // when -  action or the behaviour that we are going test
        List<POSDiscount> discountList = discountService.getDiscounts();

        // then - verify the output
        assertThat(discountList).isNotNull();
        assertThat(discountList.size()).isEqualTo(1);
    }

    @DisplayName("JUnit test for saveDiscount method")
    @Test
    public void givenDiscountObject_whenSaveDiscount_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(discountRepository.save(discount)).willReturn(discount);

        // when -  action or the behaviour that we are going test
        discountService.saveDiscount(
                discount.getDiscountId(),
                discount.getProductId(),
                discount.getDiscountPercent(),
                discount.getDiscountFlat(),
                discount.getDiscountType()
        );

        // then - verify the output
        verify(discountRepository, times(1)).save(discount);
    }

    @DisplayName("JUnit test for updateDiscount method")
    @Test
    public void givenDiscountObject_whenUpdateDiscount_thenRepositoryExistsAndSaveWereInvoked(){
        // given - precondition or setup

        given(discountRepository.existsById(discount.getProductId())).willReturn(true);

        // when -  action or the behaviour that we are going test
        discountService.updateDiscount(
                discount.getDiscountId(),
                discount.getProductId(),
                discount.getDiscountPercent(),
                discount.getDiscountFlat(),
                discount.getDiscountType()
        );

        // then - verify the output
        verify(discountRepository, times(1)).save(discount);
        verify(discountRepository, times(1)).existsById(discount.getProductId());
    }
}
