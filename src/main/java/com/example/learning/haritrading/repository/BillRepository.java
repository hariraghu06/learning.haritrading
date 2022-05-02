package com.example.learning.haritrading.repository;

import com.example.learning.haritrading.model.BillDetails;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface BillRepository extends CrudRepository<BillDetails,Long> {

    Optional<BillDetails> findByBillNo(long l);
}
