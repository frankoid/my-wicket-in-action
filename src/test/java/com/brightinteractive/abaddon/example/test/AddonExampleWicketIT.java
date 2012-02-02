/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.test;

import javax.annotation.Resource;

import com.brightinteractive.abaddon.example.ui.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

/**
 * <p>Base class for integration tests of Wicket pages.</p>
 *
 * <p>See <a
 * href="http://blog.comsysto.com/2010/06/04/test-driven-development-with-apache-wicket-and-spring-framework/">this blog
 * entry</a> for background.</p>
 *
 * @author Bright Interactive
 */
public abstract class AddonExampleWicketIT extends AddonExampleIT
{
    protected WicketTester tester;

    @Resource
    private WicketApplication wicketApplication;

    @Before
    public void createWicketTester()
    {
        tester = new WicketTester(wicketApplication);
    }
}
