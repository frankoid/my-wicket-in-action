package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

/**
 * @author Bright Interactive
 */
public class FileDownloadPage extends WicketExperimentsPage
{
	public FileDownloadPage()
	{
		add(new FileDownloadForm("fileDownloadForm"));
	}
}
