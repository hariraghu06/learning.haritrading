package com.example.learning.haritrading.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slNo;

    @Column(unique = true)
    private Long customerId;
    private String customerName;
    private String areaName;
    private String salesMan;
    @OneToMany
    public List<BillDetails> billDetails;
}
