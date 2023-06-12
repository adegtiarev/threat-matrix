/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.4.5.1
*    Source File: NonTypedScalarSerializerBase.java
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

import java.io.IOException;

import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/**
 * Intermediate base class for limited number of scalar types
 * that should never include type information. These are "native"
 * types that are default mappings for corresponding JSON scalar
 * types: {@link java.lang.String}, {@link java.lang.Integer},
 * {@link java.lang.Double} and {@link java.lang.Boolean}.
 */
public abstract class NonTypedScalarSerializerBase<T>
    extends StdScalarSerializer<T>
{
    protected NonTypedScalarSerializerBase(Class<T> t) {
        super(t);
    }

    @Override
    public final void serializeWithType(T value, JsonGenerator jgen, SerializerProvider provider,
            TypeSerializer typeSer)
        throws IOException, JsonGenerationException
    {
        // no type info, just regular serialization
        serialize(value, jgen, provider);            
    }
}
