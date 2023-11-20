/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.1.0
*    Source File: ReadOnlyClassToSerializerMap.java
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
package com.fasterxml.jackson.databind.ser.impl;

import java.util.*;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache.TypeKey;

/**
 * Optimized lookup table for accessing two types of serializers; typed
 * and non-typed. Only accessed from a single thread, so no synchronization
 * needed for accessors.
 */
public final class ReadOnlyClassToSerializerMap
{
    /**
     * Actual mappings from type key to serializers
     */
    protected final JsonSerializerMap _map;

    /**
     * We'll reuse key class to avoid unnecessary instantiations; since
     * this is not shared between threads, we can just reuse single
     * instance.
     */
    protected final TypeKey _cacheKey = new TypeKey(getClass(), false);
    
    private ReadOnlyClassToSerializerMap(JsonSerializerMap map)
    {
        _map = map;
    }

    public ReadOnlyClassToSerializerMap instance()
    {
        return new ReadOnlyClassToSerializerMap(_map);
    }

    /**
     * Factory method for creating the "blueprint" lookup map. Such map
     * can not be used as is but just shared: to get an actual usable
     * instance, {@link #instance} has to be called first.
     */
    public static ReadOnlyClassToSerializerMap from(HashMap<TypeKey, JsonSerializer<Object>> src)
    {
        return new ReadOnlyClassToSerializerMap(new JsonSerializerMap(src));
    }

    public JsonSerializer<Object> typedValueSerializer(JavaType type)
    { 
        _cacheKey.resetTyped(type);
        return _map.find(_cacheKey);
    }

    public JsonSerializer<Object> typedValueSerializer(Class<?> cls)
    { 
        _cacheKey.resetTyped(cls);
        return _map.find(_cacheKey);
    }
    
    public JsonSerializer<Object> untypedValueSerializer(Class<?> cls)
    { 
        _cacheKey.resetUntyped(cls);
        return _map.find(_cacheKey);
    }

    public JsonSerializer<Object> untypedValueSerializer(JavaType type)
    { 
        _cacheKey.resetUntyped(type);
        return _map.find(_cacheKey);
    }
}
