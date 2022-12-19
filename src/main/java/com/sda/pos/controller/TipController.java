package com.sda.pos.controller;

import com.sda.pos.model.POSTip;
import com.sda.pos.service.TipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Tag(name = "Tips")
@RequestMapping("/orders/tip")
public class TipController {

    private final TipService tipService;

    public TipController(TipService tipService) {
        this.tipService = tipService;
    }

    @Operation(summary = "Create a new tip")
    @PostMapping
    public void createTip(BigDecimal tipAmount, Long orderId){
        tipService.saveTip(tipAmount, orderId);
    }

    @Operation(summary = "Get all tips")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSTip> getTips(){
        return tipService.getTips();
    }
}
