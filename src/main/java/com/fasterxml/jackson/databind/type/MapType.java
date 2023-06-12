/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: MapType.java
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
package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

/**
 * Type that represents "true" Java Map types.
 */
public final class MapType extends MapLikeType
{
    /*
    /**********************************************************
    /* Life-cycle
    /**********************************************************
     */

    private MapType(Class<?> mapType, JavaType keyT, JavaType valueT,
            Object valueHandler, Object typeHandler) {
        super(mapType, keyT, valueT, valueHandler, typeHandler);
    }
    
    public static MapType construct(Class<?> rawType, JavaType keyT, JavaType valueT) {
        // nominally component types will be just Object.class
        return new MapType(rawType, keyT, valueT, null, null);
    }

    @Override
    protected JavaType _narrow(Class<?> subclass) {
        return new MapType(subclass, _keyType, _valueType,
                _valueHandler, _typeHandler);
    }

    @Override
    public JavaType narrowContentsBy(Class<?> contentClass)
    {
        // Can do a quick check first:
        if (contentClass == _valueType.getRawClass()) {
            return this;
        }
        return new MapType(_class, _keyType, _valueType.narrowBy(contentClass),
                _valueHandler, _typeHandler);
    }

    @Override
    public JavaType widenContentsBy(Class<?> contentClass)
    {
        if (contentClass == _valueType.getRawClass()) {
            return this;
        }
        return new MapType(_class, _keyType, _valueType.widenBy(contentClass),
                _valueHandler, _typeHandler);
    }
    
    @Override
    public JavaType narrowKey(Class<?> keySubclass)
    {
        // Can do a quick check first:
        if (keySubclass == _keyType.getRawClass()) {
            return this;
        }
        return new MapType(_class, _keyType.narrowBy(keySubclass), _valueType,
                _valueHandler, _typeHandler);
    }

    @Override
    public JavaType widenKey(Class<?> keySubclass)
    {
        // Can do a quick check first:
        if (keySubclass == _keyType.getRawClass()) {
            return this;
        }
        return new MapType(_class, _keyType.widenBy(keySubclass), _valueType,
                _valueHandler, _typeHandler);
    }
    
    @Override
    public MapType withTypeHandler(Object h) {
        return new MapType(_class, _keyType, _valueType, _valueHandler, h);
    }

    @Override
    public MapType withContentTypeHandler(Object h)
    {
        return new MapType(_class, _keyType, _valueType.withTypeHandler(h),
                _valueHandler, _typeHandler);
    }
    
    @Override
    public MapType withValueHandler(Object h) {
        return new MapType(_class, _keyType, _valueType, h, _typeHandler);
    }

    @Override
    public MapType withContentValueHandler(Object h) {
        return new MapType(_class, _keyType, _valueType.withValueHandler(h),
                _valueHandler, _typeHandler);
    }

    /*
    /**********************************************************
    /* Extended API
    /**********************************************************
     */
    
    @Override
    public MapType withKeyTypeHandler(Object h)
    {
        return new MapType(_class, _keyType.withTypeHandler(h), _valueType,
                _valueHandler, _typeHandler);
    }

    @Override
    public MapType withKeyValueHandler(Object h) {
        return new MapType(_class, _keyType.withValueHandler(h), _valueType,
                _valueHandler, _typeHandler);
    }
    
    /*
    /**********************************************************
    /* Standard methods
    /**********************************************************
     */

    @Override
    public String toString()
    {
        return "[map type; class "+_class.getName()+", "+_keyType+" -> "+_valueType+"]";
    }
}
