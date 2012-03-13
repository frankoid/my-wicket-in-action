/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.service;

import javax.annotation.Resource;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.brightinteractive.wicket.experiments.model.Widget;
import com.brightinteractive.wicket.experiments.test.AddonExampleIT;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>Integration tests for WidgetManager.</p>
 *
 * <p>These tests make sure that things used by the manager, e.g. the DAO, Hibernate and the database are all working
 * together properly.</p>
 *
 * @author Bright Interactive
 */
public class WidgetManagerIT extends AddonExampleIT
{
    private static final DefaultTransactionDefinition REQUIRED = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);

    @Resource
    private WidgetManager widgetManager;

    @Resource
    private PlatformTransactionManager transactionManager;

    @Test
    @Transactional
    public void testCreateNew()
    {
        Widget widget = new Widget();
        widget.setName("Door handle.");

        Widget savedWidget = widgetManager.save(widget);
        assertEquals(widget, savedWidget);

        long id = savedWidget.getId().longValue();
        assertTrue(id > 0);

        Widget readWidget = widgetManager.get(id);
        assertEquals(widget, readWidget);
    }

    @Test
    public void testCreateNewAndLoadInDifferentTransaction()
    {
        Widget widget = new Widget();
        widget.setName("Door handle.");

        TransactionStatus transactionStatus = transactionManager.getTransaction(REQUIRED);
        Widget savedWidget = widgetManager.save(widget);
        assertEquals(widget, savedWidget);
        transactionManager.commit(transactionStatus);

        long id = savedWidget.getId().longValue();
        assertTrue(id > 0);

        transactionStatus = transactionManager.getTransaction(REQUIRED);
        Widget readWidget = widgetManager.get(id);
        assertEquals(widget, readWidget);
        // readWidget should NOT be the same object as widget. If it is then it has probably been retrieved from a
        // Hibernate session, and so may have not actually been loaded from the database (which would defeat the whole
        // point of this test).
        assertNotSame(widget, readWidget);

        // don't leave test data in the database
        widgetManager.delete(readWidget);
        transactionManager.commit(transactionStatus);
    }

    @Test
    @Transactional
    public void testUpdateExisting()
    {
        Widget widget = new Widget();
        widget.setName("Door handle.");

        Widget savedWidget = widgetManager.save(widget);
        assertEquals(widget, savedWidget);

        long id = savedWidget.getId().longValue();
        assertTrue(id > 0);

        Widget readWidget = widgetManager.get(id);
        assertEquals(widget, readWidget);
        readWidget.setName("Car door handle");
        widgetManager.save(readWidget);

        readWidget = widgetManager.get(id);
        assertEquals("Car door handle", readWidget.getName());
    }

    @Test
    public void testSaveAndLoadNonASCIIString()
    {
        // Use different transactions to make sure that the object is actually being round-tripped to the database
        // (as opposed to just sitting in a Hibernate Session).
        TransactionStatus transactionStatus = transactionManager.getTransaction(REQUIRED);
        Widget widget = new Widget();
        String helloInArabic = "\u0645\u0643\u064a\u0644\u0639 \u0645\u0627\u0644\u0651\u0633\u0644\u0627";
        widget.setName(helloInArabic);

        Widget savedWidget = widgetManager.save(widget);
        assertEquals(widget, savedWidget);
        transactionManager.commit(transactionStatus);

        long id = savedWidget.getId().longValue();

        transactionStatus = transactionManager.getTransaction(REQUIRED);
        Widget readWidget = widgetManager.get(id);
        assertEquals(helloInArabic, readWidget.getName());
        // readWidget should NOT be the same object as widget. If it is then it has probably been retrieved from a
        // Hibernate session, and so may have not actually been loaded from the database (which would defeat the whole
        // point of this test).
        assertNotSame(widget, readWidget);
        
        // don't leave test data in the database
        widgetManager.delete(readWidget);
        transactionManager.commit(transactionStatus);
    }

    @Test
    @Transactional
    public void testDelete()
    {
        Widget widget = new Widget();
        widget.setName("Espresso machine handle");

        Widget savedWidget = widgetManager.save(widget);
        assertEquals(widget, savedWidget);

        long id = savedWidget.getId().longValue();
        assertTrue(id > 0);

        try
        {
            widgetManager.delete(widget);
            widgetManager.get(id);
            fail("Shouldn't get here - widgetManager.get(id) should have thrown an exception because we attempted to get a deleted Widget");
        }
        catch (RuntimeException e)
        {
            // ignore - we expect an exception to be thrown
        }
    }
}
