/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.test;

import javax.annotation.Resource;

import org.springframework.test.annotation.DirtiesContext;

import com.brightinteractive.abaddon.example.ui.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

/**
 * <p>Base class for integration tests of Wicket pages.</p>
 *
 * <p>See <a
 * href="http://blog.comsysto.com/2010/06/04/test-driven-development-with-apache-wicket-and-spring-framework/">this blog
 * entry</a> for background.</p>
 *
 * @author Bright Interactive
 */

// DirtiesContext annotation is necessary because the WicketTester constructor modifies the passed application (e.g. by
// calling setName), and in doing so it modifies a Spring-managed bean. The spring test framework usually caches the
// context, so without this annotation then the following exception occurs if there is more than one @Test method in a
// subclass of this class:
// java.lang.IllegalStateException: Application name can only be set once.
// 	at org.apache.wicket.Application.setName(Application.java:849)
// 	at org.apache.wicket.util.tester.BaseWicketTester.<init>(BaseWicketTester.java:297)
// 	at org.apache.wicket.util.tester.BaseWicketTester.<init>(BaseWicketTester.java:247)
// 	at org.apache.wicket.util.tester.WicketTester.<init>(WicketTester.java:196)
// 	at com.brightinteractive.abaddon.example.test.AddonExampleWicketIT.createWicketTester(AddonExampleWicketIT.java:32)
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
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
