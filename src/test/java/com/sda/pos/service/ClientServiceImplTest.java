package com.sda.pos.service;

import com.sda.pos.model.POSClient;
import com.sda.pos.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private POSClient client;

    @BeforeEach
    public void setup(){
        client = new POSClient("testName", "testDescription", "testWorkHours", "testAddress", "testContactInfo");
    }

    @DisplayName("JUnit test for createClient method")
    @Test
    public void givenClientObject_whenSaveClient_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(clientRepository.save(client)).willReturn(client);

        // when -  action or the behaviour that we are going test
        clientService.createClient(client.getName(), client.getDescription(), client.getWorkHours(), client.getAddress(), client.getContactInfo());

        // then - verify the output
        verify(clientRepository, times(1)).save(client);
    }
}
