/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.2
*    Source File: KeyDeserializers.java
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
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.*;

/**
 * Interface that defines API for simple extensions that can provide additional deserializers
 * for deserializer Map keys of various types, from JSON property names.
 * Access is by a single callback method; instance is to either return
 * a configured {@link KeyDeserializer} for specified type, or null to indicate that it
 * does not support handling of the type. In latter case, further calls can be made
 * for other providers; in former case returned key deserializer is used for handling of
 * key instances of specified type.
 */
public interface KeyDeserializers
{
    public KeyDeserializer findKeyDeserializer(JavaType type,
            DeserializationConfig config, BeanDescription beanDesc)
        throws JsonMappingException;
}
