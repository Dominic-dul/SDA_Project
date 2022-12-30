package com.sda.pos.service;

import com.sda.pos.model.POSLoyaltyInformation;
import com.sda.pos.repository.LoyaltyInformationRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoyaltyInformationImplTest {
    @Mock
    private LoyaltyInformationRepository loyaltyInformationRepository;

    @InjectMocks
    private LoyaltyInformationServiceImpl loyaltyInformationService;

    private POSLoyaltyInformation loyaltyInformation;

    @BeforeEach
    public void setup(){
        loyaltyInformation = new POSLoyaltyInformation("testInformation", "testRequirements");
    }

    @DisplayName("JUnit test for createLoyaltyInformation method")
    @Test
    public void givenLoyaltyInformationObject_whenSaveLoyaltyInformation_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(loyaltyInformationRepository.save(loyaltyInformation)).willReturn(loyaltyInformation);

        // when -  action or the behaviour that we are going test
        loyaltyInformationService.saveLoyaltyInformation(loyaltyInformation.getInformation(), loyaltyInformation.getRequirements());

        // then - verify the output
        verify(loyaltyInformationRepository, times(1)).save(loyaltyInformation);
    }

    @DisplayName("JUnit test for getLoyaltiesInformation method")
    @Test
    public void givenLoyaltyInformationList_whenGetLoyaltiesInformation_thenReturnLoyaltyInformationList(){
        // given - precondition or setup
        given(loyaltyInformationRepository.findAll()).willReturn(List.of(loyaltyInformation));

        // when -  action or the behaviour that we are going test
        List<POSLoyaltyInformation> loyaltyInformationList = loyaltyInformationService.getLoyaltiesInformation();

        // then - verify the output
        assertThat(loyaltyInformationList).isNotNull();
        assertThat(loyaltyInformationList.size()).isEqualTo(1);
    }

}
