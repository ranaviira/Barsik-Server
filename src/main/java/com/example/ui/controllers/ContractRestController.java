package com.example.ui.controllers;

import com.example.ui.entity.Contract;
import com.example.ui.service.ContractService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("server")
public class ContractRestController {

    private final ContractService contractService;

    public ContractRestController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> getContractsList() {
        return contractService.getAllContractsWithCheckBox();
    }
}
