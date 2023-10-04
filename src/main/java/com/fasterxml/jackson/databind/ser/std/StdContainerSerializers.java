/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.2
*    Source File: StdContainerSerializers.java
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

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;

/**
 * Dummy container class to group standard container serializers: serializers
 * that can serialize things like {@link java.util.List}s,
 * {@link java.util.Map}s and such.
 */
public class StdContainerSerializers
{
    protected StdContainerSerializers() { }
    
    public static ContainerSerializer<?> indexedListSerializer(JavaType elemType,
            boolean staticTyping, TypeSerializer vts, BeanProperty property,
            JsonSerializer<Object> valueSerializer)
    {
        return new IndexedListSerializer(elemType, staticTyping, vts, null, valueSerializer);
    }

    public static ContainerSerializer<?> collectionSerializer(JavaType elemType,
            boolean staticTyping, TypeSerializer vts, BeanProperty property,
            JsonSerializer<Object> valueSerializer)
    {
        return new CollectionSerializer(elemType, staticTyping, vts, null, valueSerializer);
    }

    public static ContainerSerializer<?> iteratorSerializer(JavaType elemType,
            boolean staticTyping, TypeSerializer vts)
    {
        return new IteratorSerializer(elemType, staticTyping, vts, null);
    }

    public static ContainerSerializer<?> iterableSerializer(JavaType elemType,
            boolean staticTyping, TypeSerializer vts)
    {
        return new IterableSerializer(elemType, staticTyping, vts, null);
    }

    public static JsonSerializer<?> enumSetSerializer(JavaType enumType)
    {
        return new EnumSetSerializer(enumType, null);
    }
}
