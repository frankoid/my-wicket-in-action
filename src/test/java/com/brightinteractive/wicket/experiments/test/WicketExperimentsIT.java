/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import org.junit.runner.RunWith;

/**
 * Base class for Asset Bank Addon Example integration tests.
 *
 * @author Bright Interactive
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/brightinteractive/wicket/experiments/spring-context.xml" })
@TransactionConfiguration(transactionManager = "txManager")
public abstract class WicketExperimentsIT
{
}
