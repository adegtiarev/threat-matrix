/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: NullProvider.java
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;

/**
 * To support [JACKSON-420] we need bit more indirection; this is used to produce
 * artificial failure for primitives that don't accept JSON null as value.
 */
public final class NullProvider
{
    private final Object _nullValue;

    private final boolean _isPrimitive;
    
    private final Class<?> _rawType;
    
    public NullProvider(JavaType type, Object nullValue)
    {
        _nullValue = nullValue;
        // [JACKSON-420]
        _isPrimitive = type.isPrimitive();
        _rawType = type.getRawClass();
    }

    public Object nullValue(DeserializationContext ctxt) throws JsonProcessingException
    {
        if (_isPrimitive && ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            throw ctxt.mappingException("Can not map JSON null into type "+_rawType.getName()
                    +" (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
        }
        return _nullValue;
    }
}