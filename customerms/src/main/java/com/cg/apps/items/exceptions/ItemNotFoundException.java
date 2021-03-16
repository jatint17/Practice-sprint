package com.cg.apps.items.exceptions;

public class ItemNotFoundException extends RuntimeException
{
    public ItemNotFoundException(String msg)
    {
        super(msg);
    }
}
