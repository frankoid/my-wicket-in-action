package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.handler.resource.ResourceStreamRequestHandler;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

/**
 * @author Bright Interactive
 */
public class FileDownloadForm extends Form<FileDownloadFormModel>
{
	public FileDownloadForm(String id)
	{
		super(id, new CompoundPropertyModel<FileDownloadFormModel>(new FileDownloadFormModel()));

        add(new TextField<String>("fileName").setRequired(true).setLabel(
            new Model<String>("File name")));
        add(new TextField<String>("contentType").setRequired(true).setLabel(
            new Model<String>("Content type")));
		add(new TextArea<String>("fileContents").setRequired(true).setLabel(
			new Model<String>("String")));
	}

	@Override
	protected void onSubmit()
	{
		FileDownloadFormModel model = this.getModelObject();
		info("fileContents = " + model.getFileContents());

        IResourceStream resourceStream = createResourceStream();
        getRequestCycle().scheduleRequestHandlerAfterCurrent(
            new ResourceStreamRequestHandler(resourceStream, getModelObject().getFileName())
                .setContentDisposition(ContentDisposition.ATTACHMENT)
//                .setCacheDuration(cacheDuration)
        );
	}

    private IResourceStream createResourceStream()
    {
        return new StringResourceStream(getModelObject().getFileContents(),
                                        getModelObject().getContentType());
    }
}
