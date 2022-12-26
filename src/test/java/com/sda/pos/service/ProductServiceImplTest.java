package com.sda.pos.service;

import com.sda.pos.model.POSProduct;
import com.sda.pos.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private POSProduct product;

    @BeforeEach
    public void setup(){
        product = new POSProduct(1L, "testName", "test Description", 999,new BigDecimal("10.995") , "testId");
    }

    @DisplayName("JUnit test for saveProduct method")
    @Test
    public void givenProductObject_whenSaveProduct_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(productRepository.save(product)).willReturn(product);

        // when -  action or the behaviour that we are going test
        productService.saveProduct(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getStoreUserId()
        );

        // then - verify the output
        verify(productRepository, times(1)).save(product);
    }

    @DisplayName("JUnit test for getProducts method")
    @Test
    public void givenProductList_whenGetProducts_thenReturnProductList(){
        // given - precondition or setup
        given(productRepository.findAll()).willReturn(List.of(product));

        // when -  action or the behaviour that we are going test
        List<POSProduct> productList = productService.getProducts();

        // then - verify the output
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(1);
    }

    @DisplayName("JUnit test for updateProduct method")
    @Test
    public void givenProductObject_whenUpdateProduct_thenRepositoryExistsAndSaveWereInvoked(){
        // given - precondition or setup

        given(productRepository.existsById(product.getProductId())).willReturn(true);

        // when -  action or the behaviour that we are going test
        productService.updateProduct(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getStoreUserId()
        );

        // then - verify the output
        verify(productRepository, times(1)).save(product);
        verify(productRepository, times(1)).existsById(product.getProductId());
    }

    @DisplayName("JUnit test for getProductByProductId method")
    @Test
    public void givenProductId_whenGetProductByProductId_thenReturnProductObject(){
        // given
        given(productRepository.findById(product.getProductId())).willReturn(Optional.ofNullable(product));

        // when
        POSProduct newProduct = productService.getProductByProductId(product.getProductId());

        // then
        assertThat(newProduct).isNotNull();
    }
    @DisplayName("JUnit test for deleteProductByProductId method")
    @Test
    public void givenProductId_whenDeleteProductByProductId_thenRepositoryDeleteWasInvoked (){
        // given
        given(productRepository.existsById(product.getProductId())).willReturn(true);

        // when
            productService.deleteProductByProductId(product.getProductId());

        // then - verify the output
        verify(productRepository, times(1)).existsById(product.getProductId());
        verify(productRepository, times(1)).deleteById(product.getProductId());
    }

    @DisplayName("JUnit test for updateProduct method which throws exception")
    @Test
    public void givenProductDetails_whenUpdateProduct_thenThrowsException(){
        // given - precondition or setup
        given(productRepository.existsById(product.getProductId())).willReturn(false);
        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                productService.updateProduct(
                        product.getProductId(),
                        product.getName(),
                        product.getDescription(),
                        product.getQuantity(),
                        product.getPrice(),
                        product.getStoreUserId()
                ));

        verify(productRepository, never()).findById(product.getProductId());
        verify(productRepository, never()).save(product);
    }

    @DisplayName("JUnit test for getProductByProductId method which throws exception")
    @Test
    public void givenProductId_whenGetProductByUserId_thenThrowsException(){
        // given - precondition or setup
        given(productRepository.findById(product.getProductId())).willReturn(Optional.empty());
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                productService.getProductByProductId(product.getProductId()));
    }
    @DisplayName("JUnit test for deleteProductByProductId method which throws exception")
    @Test
    public void givenProductId_whenDeleteProductByProductId_thenThrowsException (){
        // given - precondition or setup
        given(productRepository.findById(product.getProductId())).willReturn(Optional.empty());
        // when -  action or the behaviour that we are going test

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                productService.deleteProductByProductId(product.getProductId()));
    }
}