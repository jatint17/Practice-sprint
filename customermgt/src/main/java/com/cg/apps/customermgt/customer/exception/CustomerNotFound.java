package com.cg.apps.customermgt.customer.exception;

public class CustomerNotFound extends RuntimeException
{
    public CustomerNotFound(String msg)
    {
        super(msg);
    }
}
