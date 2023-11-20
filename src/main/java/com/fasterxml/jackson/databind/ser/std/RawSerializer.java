/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.6
*    Source File: RawSerializer.java
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
package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.io.IOException;

import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/**
 * This is a simple dummy serializer that will just output raw values by calling
 * toString() on value to serialize.
 */
@JacksonStdImpl
public class RawSerializer<T>
    extends StdSerializer<T>
{
    /**
     * Constructor takes in expected type of values; but since caller
     * typically can not really provide actual type parameter, we will
     * just take wild card and coerce type.
     */
    public RawSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Override
    public void serialize(T value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException
    {
        jgen.writeRawValue(value.toString());
    }

    @Override
    public void serializeWithType(T value, JsonGenerator jgen, SerializerProvider provider,
            TypeSerializer typeSer)
        throws IOException, JsonProcessingException
    {
        typeSer.writeTypePrefixForScalar(value, jgen);
        serialize(value, jgen, provider);
        typeSer.writeTypeSuffixForScalar(value, jgen);
    }
    
    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
        // type not really known, but since it is a JSON string:
        return createSchemaNode("string", true);
    }
}
