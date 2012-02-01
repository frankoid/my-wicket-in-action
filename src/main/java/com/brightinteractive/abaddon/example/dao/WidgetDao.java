/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.abaddon.example.dao;

import org.springframework.stereotype.Component;

import com.brightinteractive.abaddon.example.model.Widget;
import com.brightinteractive.common.hibernate.GenericHibernateDao;

/**
 * @author Bright Interactive
 */
@Component
public class WidgetDao extends GenericHibernateDao<Widget, Long>
{
}
