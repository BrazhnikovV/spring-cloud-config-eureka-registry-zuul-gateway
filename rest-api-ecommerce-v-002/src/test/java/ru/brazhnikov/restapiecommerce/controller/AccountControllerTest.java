package ru.brazhnikov.restapiecommerce.controller;

import org.junit.Assert;
import org.junit.Test;
import ru.brazhnikov.restapiecommerce.entities.Account;

import static org.junit.Assert.*;

public class AccountControllerTest {

    @Test
    public void list() {
    }

    @Test
    public void create() {
        Account account = new Account();
        Assert.assertNotNull( account );
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void setAccountService() {
    }
}
