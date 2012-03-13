/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.dao;

import org.springframework.stereotype.Component;

import com.brightinteractive.wicket.experiments.model.Widget;
import com.brightinteractive.common.hibernate.GenericHibernateDao;

/**
 * @author Bright Interactive
 */
@Component
public class WidgetDao extends GenericHibernateDao<Widget, Long>
{
}
