/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.wicketinaction.ch1;

import org.devrx.wicketinaction.BasePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

/**
 * @author Francis Devereux
 */
public class EchoPage extends BasePage
{
    private Label label;
    private TextField<String> field;

    public EchoPage()
    {
        Form form = new Form("form");
        field = new TextField<String>("field", new Model<String>(""));
        form.add(field);
        form.add(new Button("button")
        {
            @Override
            public void onSubmit()
            {
                String value = field.getModelObject();
                label.setDefaultModelObject(value);
                field.setModelObject("");
            }
        });
        add(form);
        add(label = new Label("message", new Model<String>("")));
    }
}
