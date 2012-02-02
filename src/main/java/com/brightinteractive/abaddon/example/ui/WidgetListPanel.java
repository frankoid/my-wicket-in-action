/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.ui;

import java.util.List;

import com.brightinteractive.abaddon.example.model.Widget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Panel that displays a list of widgets.
 *
 * @author Bright Interactive
 */
public class WidgetListPanel extends Panel
{
    public WidgetListPanel(String id, List<Widget> widgets)
    {
        super(id);

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
