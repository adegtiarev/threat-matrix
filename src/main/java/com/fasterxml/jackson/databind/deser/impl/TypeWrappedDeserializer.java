/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: TypeWrappedDeserializer.java
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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

/**
 * Simple deserializer that will call configured type deserializer, passing
 * in configured data deserializer, and exposing it all as a simple
 * deserializer.
 * This is necessary when there is no "parent" deserializer which could handle
 * details of calling a {@link TypeDeserializer}, most commonly used with
 * root values.
 */
public final class TypeWrappedDeserializer
    extends JsonDeserializer<Object>
{
    final TypeDeserializer _typeDeserializer;
    final JsonDeserializer<Object> _deserializer;

    public TypeWrappedDeserializer(TypeDeserializer typeDeser, JsonDeserializer<Object> deser)
    {
        super();
        _typeDeserializer = typeDeser;
        _deserializer = deser;
    }

    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
    {
        return _deserializer.deserializeWithType(jp, ctxt, _typeDeserializer);
    }

    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt,
        TypeDeserializer typeDeserializer)
            throws IOException, JsonProcessingException
    {
        // should never happen? (if it can, could call on that object)
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }
}