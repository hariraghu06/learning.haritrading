package com.example.learning.haritrading.controller;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.UUID;

@RestController
@Slf4j
public class TokenController {
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
}
