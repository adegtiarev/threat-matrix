/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.4
*    Source File: TypeSerializerBase.java
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
package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class TypeSerializerBase extends TypeSerializer
{
    protected final TypeIdResolver _idResolver;

    protected final BeanProperty _property;
    
    protected TypeSerializerBase(TypeIdResolver idRes, BeanProperty property)
    {
        _idResolver = idRes;
        _property = property;
    }

    @Override
    public abstract JsonTypeInfo.As getTypeInclusion();

    @Override
    public String getPropertyName() { return null; }
    
    @Override
    public TypeIdResolver getTypeIdResolver() { return _idResolver; }

    /*
    /**********************************************************
    /* Helper methods for subclasses
    /**********************************************************
     */

    protected String idFromValue(Object value) {
        return _idResolver.idFromValue(value);
    }

    protected String idFromValueAndType(Object value, Class<?> type) {
        return _idResolver.idFromValueAndType(value, type);
    }
}
