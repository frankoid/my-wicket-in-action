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
    private String fileName = "yourfile.txt";
    private String contentType = "text/plain";
	private String fileContents;

    public String getContentType()
    {
        return contentType;
    }

    @SuppressWarnings("unused")
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public String getFileName()
    {
        return fileName;
    }

    @SuppressWarnings("unused")
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

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
