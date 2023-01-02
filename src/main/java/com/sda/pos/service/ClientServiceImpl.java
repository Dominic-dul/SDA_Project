package com.sda.pos.service;

import com.sda.pos.model.POSClient;
import com.sda.pos.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(String name, String description, String workHours, String address, String contactInfo) {
        POSClient newClient = new POSClient(name, description, workHours, address, contactInfo);
        clientRepository.save(newClient);
    }
}
