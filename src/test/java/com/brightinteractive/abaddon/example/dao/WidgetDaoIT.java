/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author Bright Interactive
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/brightinteractive/abaddon/example/spring-context.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class WidgetDaoIT
{
    @Test
    public void testSomething()
    {
        assertEquals("yes", "yes");
    }
}
