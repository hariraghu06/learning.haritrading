package com.example.learning.haritrading.repository;

import com.example.learning.haritrading.model.BillDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends CrudRepository<BillDetails, Long> {

    Optional<BillDetails> findByBillNo(int l);

    @Query(value = "SELECT u FROM BillDetails u WHERE u.billNo =2")
    public List<BillDetails> findBillNo();

    Optional<BillDetails> findByBillNoAndBalance(Integer billno, Integer balance);

}
