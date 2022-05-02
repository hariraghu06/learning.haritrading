package com.example.learning.haritrading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillInput {
    @JsonProperty("bill_number")
    private long billNo ;

    @JsonProperty
    private long billValue;

    @JsonProperty
    private long receipt;
}
