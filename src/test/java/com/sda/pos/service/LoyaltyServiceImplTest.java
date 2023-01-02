package com.sda.pos.service;

import com.sda.pos.model.POSLoyalty;
import com.sda.pos.repository.LoyaltyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoyaltyServiceImplTest {
    @Mock
    private LoyaltyRepository loyaltyRepository;

    @InjectMocks
    private LoyaltyServiceImpl loyaltyService;

    private POSLoyalty loyalty;

    @BeforeEach
    public void setup(){
        Timestamp date = Timestamp.from(Instant.now());
        loyalty = new POSLoyalty(1L, 1L, date, date);
    }

    @DisplayName("JUnit test for createLoyalty method")
    @Test
    public void givenLoyaltyObject_whenSaveLoyalty_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(loyaltyRepository.save(loyalty)).willReturn(loyalty);

        // when -  action or the behaviour that we are going test
        loyaltyService.saveLoyalty(loyalty.getLoyaltyInformationId(), loyalty.getUserId(), loyalty.getStartDate(), loyalty.getExpirationDate());

        // then - verify the output
        verify(loyaltyRepository, times(1)).save(loyalty);
    }
}
