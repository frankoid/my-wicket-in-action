/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.dao;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.brightinteractive.abaddon.example.model.Widget;
import com.brightinteractive.abaddon.example.test.AddonExampleIT;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Bright Interactive
 */
@Transactional
public class WidgetDaoIT extends AddonExampleIT
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
