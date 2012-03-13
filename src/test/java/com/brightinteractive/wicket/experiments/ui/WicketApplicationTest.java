package com.brightinteractive.wicket.experiments.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Bright Interactive
 */
public class WicketApplicationTest
{
	private WicketApplication wicketApplication;

	@Before
	public void setUp()
	{
		wicketApplication = new WicketApplication();
	}

	@Test
	public void testHomePageIsShowAssetBankUserPage()
	{
		WicketApplication app = getWicketApplication();
		assertEquals(ShowAssetBankUserPage.class, app.getHomePage());
	}

	private WicketApplication getWicketApplication()
	{
		return wicketApplication;
	}
}
