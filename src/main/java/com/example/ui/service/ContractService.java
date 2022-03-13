package com.example.ui.service;

import com.example.ui.entity.Contract;
import com.example.ui.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
    private List<Contract> contractsList;
    private void getContractsFromDataBase() {
        contractsList = contractRepository.findAll();
    }

    /**
     * Метод начначает поля с checkBox,
     * True если дата последнего обновления договора меньше текущей даты на 60 дней
     */
    private void setAllCheckBox() {
        for (Contract list : contractsList) {
            LocalDate localDateUpdate = list.getUpdateDate();
            LocalDate localDateNow = LocalDate.now().minusDays(60);
            list.setCheckBox(localDateUpdate.isAfter(localDateNow));
        }
    }
    public List<Contract> getAllContractsWithCheckBox() {
        getContractsFromDataBase();
        setAllCheckBox();
        return contractsList;
    }
}
