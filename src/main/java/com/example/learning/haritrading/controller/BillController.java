package com.example.learning.haritrading.controller;

import com.example.learning.haritrading.model.BillDetails;
import com.example.learning.haritrading.model.BillInput;
import com.example.learning.haritrading.repository.BillRepository;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@Slf4j
public class BillController {

    @Autowired
    BillRepository billRepository;


    @GetMapping("/token")
    public String generateToken() {
        log.info("testgit");
        return Jwts.builder().setSubject("hello" + UUID.randomUUID()).compact();
    }

    @GetMapping("/decode")
    public String decoder() {
        String token = "eyJhbGciOiJub25lIn0.eyJzdWIiOiJoZWxsb2U5NmQxYWQ1LTY5NDgtNDVhNC05MWQ2LTJkYmZkYzA4MGRlOSJ9.";
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        return header + payload;
    }

    @PostMapping("/newBill")
    public String updateNewBill(@RequestBody BillInput billInput) {
        String message;
        BillDetails newBill = new BillDetails();
        newBill.setReceipt(0L);
        newBill.setBillNo(billInput.getBillNo());
        newBill.setBillValue(billInput.getBillValue());
        newBill.setBalance(billInput.getBillValue());
        try {
            billRepository.save(newBill);
            message = "Save successful";
        } catch (Exception e) {
            message = "Bill Number : " + billInput.getBillNo() + " Already Exits ";
        }
        return message;
    }


    @PutMapping("/oldBill")
    public String updateOldBill(@RequestBody BillInput billInput) {
        String message ;
        long billNo = billInput.getBillNo();
        long receipt = billInput.getReceipt();
        try {
            BillDetails  bill  = billRepository.findByBillNo(billNo).get();
            log.info("bill input is : {}", bill);

            long billBalance = bill.getBalance();
            long updatedReceipt = bill.getReceipt() - receipt;
            long updatedBalance = billBalance - receipt;
            bill.setBalance(updatedBalance);
            bill.setReceipt(updatedReceipt);
            billRepository.save(bill);
            message="Bill number: " +billNo +" Updated Successfully" + bill;
        }
        catch (Exception e ){
            message= e + "  Something Wrong ";

        }
        return  message;
    }
}
