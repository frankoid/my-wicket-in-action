package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import org.apache.wicket.markup.html.form.Form;
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

		add(new TextField<String>("fileContents").setRequired(true).setLabel(
			new Model<String>("String")));
	}

	@Override
	protected void onSubmit()
	{
		FileDownloadFormModel model = this.getModelObject();
		info("fileContents = " + model.getFileContents());

        IResourceStream resourceStream = createResourceStreamWithContents(model.getFileContents());
        getRequestCycle().scheduleRequestHandlerAfterCurrent(
            new ResourceStreamRequestHandler(resourceStream, "yourfile.txt")
                .setContentDisposition(ContentDisposition.ATTACHMENT)
//                .setCacheDuration(cacheDuration)
        );
	}

    private IResourceStream createResourceStreamWithContents(String contents)
    {
        return new StringResourceStream(contents, "text/plain");
    }
}
