package com.example.learning.haritrading.model;

import lombok.*;

import javax.persistence.*;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BILL_DETAILS" )
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long slNo;

    @Column(unique = true)
    private Long billNo;
    @Column
    private Long billValue;
    @Column
    private Long Receipt;
    @Column
    private Long balance;
}
