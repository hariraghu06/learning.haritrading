package com.example.learning.haritrading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillInput {
    @JsonProperty("bill_number")
    private int billNo ;

    @JsonProperty
    private int billValue;

    @JsonProperty
    private int receipt;
}
