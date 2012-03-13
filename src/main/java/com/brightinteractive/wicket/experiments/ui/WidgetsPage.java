/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.ui;

import java.util.List;

import com.brightinteractive.wicket.experiments.model.Widget;
import com.brightinteractive.wicket.experiments.service.WidgetManager;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Page that lists all the widgets.
 *
 * @author Bright Interactive
 */
public class WidgetsPage extends WebPage
{
    @SpringBean
    private WidgetManager widgetManager;

    public WidgetsPage()
    {
        List<Widget> widgets = widgetManager.getAll();

        add(new WidgetListPanel("widgetList", widgets));
    }
}
