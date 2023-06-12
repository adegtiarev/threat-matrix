/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: StdScalarDeserializer.java
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
package com.fasterxml.jackson.databind.deser.std;

import java.io.IOException;

import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

/**
 * Base class for deserializers that handle types that are serialized
 * as JSON scalars (non-structured, i.e. non-Object, non-Array, values).
 */
public abstract class StdScalarDeserializer<T> extends StdDeserializer<T>
{
    protected StdScalarDeserializer(Class<?> vc) {
        super(vc);
    }

    protected StdScalarDeserializer(JavaType valueType) {
        super(valueType);
    }
    
    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt,
            TypeDeserializer typeDeserializer)
        throws IOException, JsonProcessingException
    {
        return typeDeserializer.deserializeTypedFromScalar(jp, ctxt);
    }
}
