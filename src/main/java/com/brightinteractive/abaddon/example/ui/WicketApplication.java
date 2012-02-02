package com.brightinteractive.abaddon.example.ui;

/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * @author Bright Interactive
 */
@Component
public class WicketApplication
    extends WebApplication
    implements ApplicationContextAware
{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void init()
    {
        super.init();

        mountPage("/widgets", WidgetsPage.class);

        getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
    }

    @Override
	public Class<? extends Page> getHomePage()
	{
		return ShowAssetBankUserPage.class;
	}
}
