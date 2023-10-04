/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.1.5
*    Source File: PropertyBasedObjectIdGenerator.java
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

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// Simple placeholder
public class PropertyBasedObjectIdGenerator
	extends ObjectIdGenerators.PropertyGenerator
{
    public PropertyBasedObjectIdGenerator(Class<?> scope) {
        super(scope);
    }
    
    @Override
    public Object generateId(Object forPojo) {
    	throw new UnsupportedOperationException();
    }

    @Override
    public ObjectIdGenerator<Object> forScope(Class<?> scope) {
        return (scope == _scope) ? this : new PropertyBasedObjectIdGenerator(scope);
    }

    @Override
    public ObjectIdGenerator<Object> newForSerialization(Object context) {
        return this;
    }

    @Override
    public com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey key(Object key) {
        // should we use general type for all; or type of property itself?
        return new IdKey(getClass(), _scope, key);
    }

}
