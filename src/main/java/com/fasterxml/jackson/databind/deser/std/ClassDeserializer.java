/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.0-RC2
*    Source File: ClassDeserializer.java
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
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
public class ClassDeserializer
    extends StdScalarDeserializer<Class<?>>
{
    public ClassDeserializer() { super(Class.class); }

    @Override
    public Class<?> deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException
    {
        JsonToken curr = jp.getCurrentToken();
        // Currently will only accept if given simple class name
        if (curr == JsonToken.VALUE_STRING) {
            String className = jp.getText();
            // [JACKSON-597]: support primitive types (and void)
            if (className.indexOf('.') < 0) {
                if ("int".equals(className)) return Integer.TYPE;
                if ("long".equals(className)) return Long.TYPE;
                if ("float".equals(className)) return Float.TYPE;
                if ("double".equals(className)) return Double.TYPE;
                if ("boolean".equals(className)) return Boolean.TYPE;
                if ("byte".equals(className)) return Byte.TYPE;
                if ("char".equals(className)) return Character.TYPE;
                if ("short".equals(className)) return Short.TYPE;
                if ("void".equals(className)) return Void.TYPE;
            }
            try {
                return Class.forName(jp.getText());
            } catch (ClassNotFoundException e) {
                throw ctxt.instantiationException(_valueClass, e);
            }
        }
        throw ctxt.mappingException(_valueClass, curr);
    }
}
