/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: ObjectIdInfo.java
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
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

/**
 * Container object that encapsulates information usually
 * derived from {@link JsonIdentityInfo} annotation or its
 * custom alternatives
 */
public class ObjectIdInfo
{
    protected final String _propertyName;
    protected final Class<? extends ObjectIdGenerator<?>> _generator;
    protected final Class<?> _scope;
    
    public ObjectIdInfo(String prop, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen)
    {
        _propertyName = prop;
        _generator = gen;
        _scope = scope;
    }

    public String getPropertyName() { return _propertyName; }
    public Class<?> getScope() { return _scope; }
    public Class<? extends ObjectIdGenerator<?>> getGeneratorType() { return _generator; }
}