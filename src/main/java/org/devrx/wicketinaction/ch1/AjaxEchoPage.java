/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.wicketinaction.ch1;

import org.devrx.wicketinaction.BasePage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxFallbackButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

/**
 * @author Francis Devereux
 */
public class AjaxEchoPage extends BasePage
{
    private Label label;
    private TextField<String> field;

    public AjaxEchoPage()
    {
        Form form = new Form("form");
        field = new TextField<String>("field", new Model<String>(""));
        field.setOutputMarkupId(true);
        form.add(field);
        form.add(new AjaxFallbackButton("button", form)
        {
            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                String value = field.getModelObject();
                label.setDefaultModelObject(value);
                field.setModelObject("");
                target.add(field, label);
            }
        });
        add(form);
        add(label = new Label("message", new Model<String>("")));
        label.setOutputMarkupId(true);
    }
}
