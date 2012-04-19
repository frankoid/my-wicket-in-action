/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package org.devrx.wicketinaction.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import org.junit.runner.RunWith;

/**
 * Base class for integration tests.
 *
 * @author Bright Interactive
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:org/devrx/wicketinaction/spring-context.xml" })
@TransactionConfiguration(transactionManager = "txManager")
public abstract class BaseIT
{
}
