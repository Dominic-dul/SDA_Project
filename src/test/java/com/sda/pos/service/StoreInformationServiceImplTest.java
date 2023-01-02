package com.sda.pos.service;

import com.sda.pos.model.POSStoreInformation;
import com.sda.pos.repository.StoreInformationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreInformationServiceImplTest {
    @Mock
    private StoreInformationRepository storeInformationRepository;

    @InjectMocks
    private StoreInformationServiceImpl storeInformationService;

    private POSStoreInformation storeInformation;

    @BeforeEach
    public void setup(){
        storeInformation = new POSStoreInformation("testName", "testDescription", "testWorkHours", "testAddress", "testContactInfo");
    }

    @DisplayName("JUnit test for createStoreInformation method")
    @Test
    public void givenStoreInformationObject_whenSaveStoreInformation_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(storeInformationRepository.save(storeInformation)).willReturn(storeInformation);

        // when -  action or the behaviour that we are going test
        storeInformationService.createStoreInformation(storeInformation.getName(), storeInformation.getDescription(), storeInformation.getWorkHours(), storeInformation.getAddress(), storeInformation.getContactInfo());

        // then - verify the output
        verify(storeInformationRepository, times(1)).save(storeInformation);
    }

    @DisplayName("JUnit test for updateStoreInformation method")
    @Test
    public void givenStoreInformationObject_whenUpdateStoreInformation_thenRepositoryDeleteAndExistsAndSaveWereInvoked(){
        // given - precondition or setup
        given(storeInformationRepository.findById(storeInformation.getStoreInformationId())).willReturn(Optional.ofNullable(storeInformation));
        given(storeInformationRepository.existsById(storeInformation.getStoreInformationId())).willReturn(true);

        // when -  action or the behaviour that we are going test
        storeInformationService.updateStoreInformation(storeInformation.getStoreInformationId(), storeInformation.getName(), storeInformation.getDescription(), storeInformation.getWorkHours(), storeInformation.getAddress(), storeInformation.getContactInfo());

        // then - verify the output
        verify(storeInformationRepository, times(1)).existsById(storeInformation.getStoreInformationId());
        verify(storeInformationRepository, times(1)).findById(storeInformation.getStoreInformationId());
        verify(storeInformationRepository, times(1)).save(storeInformation);
    }

    @DisplayName("JUnit test for updateStoreInformation method which throws exception")
    @Test
    public void givenStoreInformationDetails_whenUpdateStoreInformation_thenThrowsException(){
        // given - precondition or setup
        given(storeInformationRepository.existsById(storeInformation.getStoreInformationId())).willReturn(false);
        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () ->
                storeInformationService.updateStoreInformation(storeInformation.getStoreInformationId(), storeInformation.getName(), storeInformation.getDescription(), storeInformation.getWorkHours(), storeInformation.getAddress(), storeInformation.getContactInfo()));
        verify(storeInformationRepository, never()).findById(storeInformation.getStoreInformationId());
        verify(storeInformationRepository, never()).save(storeInformation);
    }
}
