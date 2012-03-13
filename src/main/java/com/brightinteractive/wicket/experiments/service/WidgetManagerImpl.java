/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.brightinteractive.wicket.experiments.model.Widget;
import com.brightinteractive.common.dao.GenericDao;
import com.brightinteractive.common.service.GenericManagerImpl;

/**
 * @author Bright Interactive
 */
@Component
public class WidgetManagerImpl
    extends GenericManagerImpl<Widget, Long>
    implements WidgetManager
{
    @Resource
    @Override
    public void setDao(GenericDao<Widget, Long> dao)
    {
        super.setDao(dao);
    }
}
