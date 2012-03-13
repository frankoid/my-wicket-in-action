/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.ui;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.brightinteractive.wicket.experiments.model.Widget;
import com.brightinteractive.wicket.experiments.service.WidgetManager;
import com.brightinteractive.wicket.experiments.test.AddonExampleWicketIT;
import org.junit.Test;

/**
 * @author Bright Interactive
 */
@Transactional
public class WidgetsPageIT extends AddonExampleWicketIT
{
    @Resource
    private WidgetManager widgetManager;

    @Test
    public void testRenderWidgetsPage()
    {
        // Make sure that there is at least 1 widget in the DB, so that the test doesn't pass if an empty list of
        // widgets is being rendered regardless of what's in the DB.
        createWidget();

        List<Widget> allWidgets = widgetManager.getAll();

        tester.startPage(WidgetsPage.class);
        tester.assertRenderedPage(WidgetsPage.class);
        tester.assertComponent("widgetList", WidgetListPanel.class);
        tester.assertListView("widgetList:widgetRows", allWidgets);
    }

    @Test
    public void testMoreThanOneTest()
    {
        // the mere presence of this test causes an exception without the @DirtiesContext annotation on
        // AddonExampleWicketIT
    }

    private void createWidget()
    {
        Widget widget = new Widget();
        widget.setName("TestWidget");
        widgetManager.save(widget);
    }
}
