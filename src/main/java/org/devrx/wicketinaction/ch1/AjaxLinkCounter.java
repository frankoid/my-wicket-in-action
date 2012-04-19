/*
 * Copyright 2012 Francis Devereux, All Rights Reserved.
 */

package org.devrx.wicketinaction.ch1;

import org.devrx.wicketinaction.BasePage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class AjaxLinkCounter extends BasePage
{
    @SuppressWarnings("unused") // read by Wicket
    private int counter = 0;
    private Label label;

    public AjaxLinkCounter()
    {
        add(new AjaxFallbackLink("link")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                counter++;
                if (target != null)
                {
                    target.add(label);
                }
            }
        });
        label = new Label("label", new PropertyModel(this, "counter"));
        label.setOutputMarkupId(true);
        add(label);
    }
}
