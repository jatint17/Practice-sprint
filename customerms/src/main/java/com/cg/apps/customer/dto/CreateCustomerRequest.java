package com.cg.apps.customer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCustomerRequest
{
    @NotBlank
    @Size(min = 2)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
