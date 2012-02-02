/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.ui;

import java.util.List;

import com.brightinteractive.abaddon.example.model.Widget;
import com.brightinteractive.abaddon.example.service.WidgetManager;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
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

        add(new ListView<Widget>("widgetRows", widgets)
        {
            @Override
            protected void populateItem(ListItem<Widget> item)
            {
                final Widget widget = item.getModelObject();
                item.add(new Label("id", "" + widget.getId()));
                item.add(new Label("name", widget.getName()));
            }
        });
    }
}
