/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.3.5
*    Source File: TimeZoneSerializer.java
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
import java.util.TimeZone;

import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class TimeZoneSerializer
    extends StdScalarSerializer<TimeZone>
{
    public final static TimeZoneSerializer instance = new TimeZoneSerializer();
    
    public TimeZoneSerializer() { super(TimeZone.class); }

    @Override
    public void serialize(TimeZone value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException
    {
        jgen.writeString(value.getID());
    }

    @Override
    public void serializeWithType(TimeZone value, JsonGenerator jgen, SerializerProvider provider,
            TypeSerializer typeSer)
        throws IOException, JsonGenerationException
    {
        // Better ensure we don't use specific sub-classes:
        typeSer.writeTypePrefixForScalar(value, jgen, TimeZone.class);
        serialize(value, jgen, provider);
        typeSer.writeTypeSuffixForScalar(value, jgen);
    }
}
