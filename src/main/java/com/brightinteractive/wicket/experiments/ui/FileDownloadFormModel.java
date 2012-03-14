package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

/**
 * @author Bright Interactive
 */
public class FileDownloadFormModel
{
	private String fileContents;

	/**
	 * Get the data to include in the file to be downloaded
	 */
	public String getFileContents()
	{
		return fileContents;
	}

	@SuppressWarnings("unused")
	public void setFileContents(String a_fileContents)
	{
		fileContents = a_fileContents;
	}
}
