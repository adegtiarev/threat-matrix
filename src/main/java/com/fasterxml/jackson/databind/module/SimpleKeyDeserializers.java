/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.0
*    Source File: SimpleKeyDeserializers.java
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
package com.fasterxml.jackson.databind.module;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;

/**
 * Simple implementation {@link KeyDeserializers} which allows registration of
 * deserializers based on raw (type erased class).
 * It can work well for basic bean and scalar type deserializers, but is not
 * a good fit for handling generic types (like {@link Map}s and {@link Collection}s
 * or array types).
 *<p>
 * Unlike {@link SimpleSerializers}, this class does not currently support generic mappings;
 * all mappings must be to exact declared deserialization type.
 */
public class SimpleKeyDeserializers implements KeyDeserializers
{
    protected HashMap<ClassKey,KeyDeserializer> _classMappings = null;

    /*
    /**********************************************************
    /* Life-cycle, construction and configuring
    /**********************************************************
     */
    
    public SimpleKeyDeserializers() { }

    public SimpleKeyDeserializers addDeserializer(Class<?> forClass, KeyDeserializer deser)
    {
        if (_classMappings == null) {
            _classMappings = new HashMap<ClassKey,KeyDeserializer>();
        }
        _classMappings.put(new ClassKey(forClass), deser);
        return this;
    }

    /*
    /**********************************************************
    /* Serializers implementation
    /**********************************************************
     */

    @Override
    public KeyDeserializer findKeyDeserializer(JavaType type,
            DeserializationConfig config, BeanDescription beanDesc)
    {
        if (_classMappings == null) {
            return null;
        }
        return _classMappings.get(new ClassKey(type.getRawClass()));
    }
}
