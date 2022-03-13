package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="contracts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "check_box")
    private Boolean checkBox;
}
