package com.example.learning.haritrading.model;

import lombok.*;

import javax.persistence.*;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BILL_DETAILS")
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slNo;

    @Column(unique = true)
    private int billNo;
    @Column
    public Long customerId;

    @Column
    private int billValue;
    @Column
    private int receipt;
    @Column
    private int balance;
}
