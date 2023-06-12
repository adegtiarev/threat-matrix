/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.13.4.1
*    Source File: ContextualKeyDeserializer.java
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
 * Add-on interface that {@link KeyDeserializer}s can implement to get a callback
 * that can be used to create contextual instances of key deserializer to use for
 * handling Map keys of supported type. This can be useful
 * for key deserializers that can be configured by annotations, or should otherwise
 * have differing behavior depending on what kind of Map property keys are being deserialized.
 */
public interface ContextualKeyDeserializer
{
    /**
     * Method called to see if a different (or differently configured) key deserializer
     * is needed to deserialize keys of specified Map property.
     * Note that instance that this method is called on is typically shared one and
     * as a result method should <b>NOT</b> modify this instance but rather construct
     * and return a new instance. This instance should only be returned as-is, in case
     * it is already suitable for use.
     * 
     * @param ctxt Deserialization context to access configuration, additional 
     *    deserializers that may be needed by this deserializer
     * @param property Method, field or constructor parameter that declared Map for which
     *   contextual instance will be used. Will not be available when deserializing root-level
     *   Map value; otherwise should not be null.
     * 
     * @return Key deserializer to use for deserializing keys specified Map property,
     *   may be this instance or a new instance.
     */
    public KeyDeserializer createContextual(DeserializationContext ctxt,
            BeanProperty property)
        throws JsonMappingException;
}
