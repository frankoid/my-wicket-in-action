/*
 * Copyright 2012 Francis Devereux, All Rights Reserved.
 */

package org.devrx.wicketinaction.ch1;

import org.devrx.wicketinaction.BasePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class LinkCounter extends BasePage
{
    @SuppressWarnings("unused") // read by Wicket
    private int counter = 0;

    public LinkCounter()
    {
        add(new Link("link")
        {
            @Override
            public void onClick()
            {
                counter++;
            }
        });
        add(new Label("label",
                      new PropertyModel(this, "counter")));

    }
}
