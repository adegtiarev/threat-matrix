/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.1.5
*    Source File: NullNode.java
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
package com.fasterxml.jackson.databind.node;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 * This singleton value class is used to contain explicit JSON null
 * value.
 */
public final class NullNode
    extends ValueNode
{
    // // Just need a fly-weight singleton

    public final static NullNode instance = new NullNode();

    private NullNode() { }

    public static NullNode getInstance() { return instance; }

    @Override public JsonToken asToken() { return JsonToken.VALUE_NULL; }

    @Override
    public boolean isNull() { return true; }

    @Override
    public String asText() {
        return "null";
    }

    // as with MissingNode, not considered number node; hence defaults are returned if provided
    
    /*
    public int asInt(int defaultValue);
    public long asLong(long defaultValue);
    public double asDouble(double defaultValue);
    public boolean asBoolean(boolean defaultValue);
    */
    
    @Override
    public final void serialize(JsonGenerator jg, SerializerProvider provider)
        throws IOException, JsonProcessingException
    {
        jg.writeNull();
    }

    @Override
    public boolean equals(Object o)
    {
        return (o == this);
    }
}
