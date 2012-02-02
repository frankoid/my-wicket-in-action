package com.brightinteractive.abaddon.example.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import org.springframework.stereotype.Component;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * @author Bright Interactive
 */
@Component
public class WicketApplication extends WebApplication
{
    @Override
    protected void init()
    {
        super.init();

        mountPage("/widgets", WidgetsPage.class);

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

    @Override
	public Class<? extends Page> getHomePage()
	{
		return ShowAssetBankUserPage.class;
	}
}
