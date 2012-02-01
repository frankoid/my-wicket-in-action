/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.brightinteractive.abaddon.example.model.Widget;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Bright Interactive
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/brightinteractive/abaddon/example/spring-context.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class WidgetDaoIT
{
    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private WidgetDao widgetDao;

    @Test
    public void testSave()
    {
        Widget widget;
        long id;

        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
        try
        {
            widget = new Widget();
            widget.setName("Cooker Knob #42342");
            widgetDao.makePersistent(widget);
            id = widget.getId().longValue();
            assertTrue(id > 0);

            Widget widgetRead = widgetDao.findById(id);
            assertEquals(widget, widgetRead);

            widgetDao.makeTransient(widget);
        }
        finally
        {
            TransactionSynchronizationManager.unbindResource(sessionFactory);
            SessionFactoryUtils.releaseSession(session, sessionFactory);
        }
    }
}
