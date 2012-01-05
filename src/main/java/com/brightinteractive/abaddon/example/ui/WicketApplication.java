package com.brightinteractive.abaddon.example.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author Bright Interactive
 */
public class WicketApplication extends WebApplication
{
	@Override
	public Class<? extends Page> getHomePage()
	{
		return ShowAssetBankUserPage.class;
	}
}
