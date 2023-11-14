/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.12.7.1
*    Source File: PropertyValue.java
*    
*    Copyrights:
*      copyright (c) 2007- tatu saloranta, tatu.saloranta@iki.fi
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package com.fasterxml.jackson.databind.deser.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

/**
 * Base class for property values that need to be buffered during
 * deserialization.
 */
public abstract class PropertyValue
{
    public final PropertyValue next;

    /**
     * Value to assign when POJO has been instantiated.
     */
    public final Object value;
    
    protected PropertyValue(PropertyValue next, Object value)
    {
        this.next = next;
        this.value = value;
    }

    /**
     * Method called to assign stored value of this property to specified
     * bean instance
     */
    public abstract void assign(Object bean)
        throws IOException, JsonProcessingException;

    /*
    /**********************************************************
    /* Concrete property value classes
    /**********************************************************
     */

    /**
     * Property value that used when assigning value to property using
     * a setter method or direct field access.
     */
    final static class Regular
        extends PropertyValue
    {
        final SettableBeanProperty _property;
        
        public Regular(PropertyValue next, Object value,
                       SettableBeanProperty prop)
        {
            super(next, value);
            _property = prop;
        }

        @Override
        public void assign(Object bean)
            throws IOException, JsonProcessingException
        {
            _property.set(bean, value);
        }
    }
    
    /**
     * Property value type used when storing entries to be added
     * to a POJO using "any setter" (method that takes name and
     * value arguments, allowing setting multiple different
     * properties using single method).
     */
    final static class Any
        extends PropertyValue
    {
        final SettableAnyProperty _property;
        final String _propertyName;
        
        public Any(PropertyValue next, Object value,
                   SettableAnyProperty prop,
                   String propName)
        {
            super(next, value);
            _property = prop;
            _propertyName = propName;
        }

        @Override
        public void assign(Object bean)
            throws IOException, JsonProcessingException
        {
            _property.set(bean, _propertyName, value);
        }
    }

    /**
     * Property value type used when storing entries to be added
     * to a Map.
     */
    final static class Map
        extends PropertyValue
    {
        final Object _key;
        
        public Map(PropertyValue next, Object value, Object key)
        {
            super(next, value);
            _key = key;
        }

        @SuppressWarnings("unchecked") 
        @Override
        public void assign(Object bean)
            throws IOException, JsonProcessingException
        {
            ((java.util.Map<Object,Object>) bean).put(_key, value);
        }
    }
}
