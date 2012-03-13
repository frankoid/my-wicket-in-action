/*
 * Copyright 2012 Bright Interactive, All Rights Reserved.
 */

package com.brightinteractive.wicket.experiments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Bright Interactive
 */
@Entity
public class Widget
{
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public Widget()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Widget)) return false;

        Widget widget = (Widget) o;

        // If o is a Hibernate proxy then accessing its fields directly may return null, so we use getters instead.
        if (id != null ? !id.equals(widget.getId()) : widget.getId() != null) return false;
        return !(name != null ? !name.equals(widget.getName()) : widget.getName() != null);
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Widget {" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
