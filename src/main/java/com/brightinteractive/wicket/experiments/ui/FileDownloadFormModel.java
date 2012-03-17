package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import java.io.Serializable;

/**
 * @author Bright Interactive
 */
public class FileDownloadFormModel implements Serializable
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
