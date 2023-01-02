package com.sda.pos.controller;

import com.sda.pos.model.POSClient;
import com.sda.pos.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Clients")
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @Operation(summary = "Add a client")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody POSClient client){
        clientService.createClient(client.getName(), client.getDescription(), client.getWorkHours(), client.getAddress(), client.getContactInfo());
    }
}
