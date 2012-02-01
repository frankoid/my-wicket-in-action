/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.dao;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class WidgetDaoIT
{
    @Resource
    private WidgetDao widgetDao;

    @Test
    public void testSave()
    {
        Widget widget = new Widget();
        widget.setName("Cooker Knob #42342");
        widgetDao.makePersistent(widget);

        long id = widget.getId().longValue();
        assertTrue(id > 0);

        Widget widgetRead = widgetDao.findById(id);
        assertEquals(widget, widgetRead);
    }
}
