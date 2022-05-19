package com.example.learning.haritrading.controller;

import com.example.learning.haritrading.model.BillDetails;
import com.example.learning.haritrading.repository.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
@Slf4j
public class BillController {

    @Autowired
    BillRepository billRepository;

    @GetMapping("/getAllBills")
    public Iterable<BillDetails> getAllBills() {
        Iterable<BillDetails> billDetails = billRepository.findAll();
        return billDetails;
    }

    @GetMapping("/getBill/{billno}")
    public Optional<BillDetails> getBillNo(@PathVariable Integer billno) {
        Optional<BillDetails> billDetails = billRepository.findByBillNo(billno);
        return billDetails;
    }

    @PostMapping("/newBill")
    public String updateNewBill(@RequestBody BillDetails billInput) {
        String message;
        try {
            billRepository.save(billInput);
            message = "Save successful";
        } catch (Exception e) {
            message = "Bill Number : " + billInput.getBillNo() + " Already Exits ";
        }
        return message;
    }

    @PutMapping("/oldBill")
    public String updateOldBill(@RequestBody BillDetails billInput) {
        String message;
        int billNo = billInput.getBillNo();
        int receipt = billInput.getReceipt();
        try {
            BillDetails bill = billRepository.findByBillNo(billNo).get();
            int billBalance = bill.getBalance();
            int updatedReceipt = -(bill.getReceipt() - receipt);
            int updatedBalance = billBalance - receipt;
            if (updatedBalance > 0) {
                bill.setBalance(updatedBalance);
                bill.setReceipt(updatedReceipt);
                billRepository.save(bill);
                message = "Bill number: " + billNo + " Updated Successfully" + bill;
            } else message = "Bill Balance Cannot be less than 0";
        } catch (Exception e) {
            message = e + "  Something Wrong ";
        }
        return message;
    }
}
