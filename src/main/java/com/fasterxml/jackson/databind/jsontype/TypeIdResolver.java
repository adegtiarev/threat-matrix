/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.4
*    Source File: TypeIdResolver.java
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
package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;

/**
 * Interface that defines standard API for converting types
 * to type identifiers and vice versa. Used by type resolvers
 * ({@link com.fasterxml.jackson.databind.jsontype.TypeSerializer},
 * {@link com.fasterxml.jackson.databind.jsontype.TypeDeserializer}) for converting
 * between type and matching id; id is stored in JSON and needed for
 * creating instances of proper subtypes when deserializing values.
 */
public interface TypeIdResolver
{
    /*
    /**********************************************************
    /* Initialization/configuration methods
    /**********************************************************
     */

    /**
     * Method that will be called once before any type resolution calls;
     * used to initialize instance with configuration. This is necessary
     * since instances may be created via reflection, without ability to
     * call specific constructor to pass in configuration settings.
     * 
     * @param baseType Base type for which this id resolver instance is
     *   used
     */
    public void init(JavaType baseType);

    /*
    /**********************************************************
    /* Conversions between types and type ids
    /**********************************************************
     */
    
    /**
     * Method called to serialize type of the type of given value
     * as a String to include in serialized JSON content.
     */
    public String idFromValue(Object value);

    /**
     * Alternative method used for determining type from combination of
     * value and type, using suggested type (that serializer provides)
     * and possibly value of that type. Most common implementation will
     * use suggested type as is.
     */
    public String idFromValueAndType(Object value, Class<?> suggestedType);

    /**
     * Method that can be called to figure out type id to use for instances
     * of base type (declared type of property). This is usually only used
     * for fallback handling, for cases where real type information is not
     * available for some reason.
     */
    public String idFromBaseType();
    
    /**
     * Method called to resolve type from given type identifier.
     */
    public JavaType typeFromId(String id);

    /*
    /**********************************************************
    /* Accessors for metadata
    /**********************************************************
     */

     /**
      * Accessor for mechanism that this resolver uses for determining
      * type id from type. Mostly informational; not required to be called
      * or used.
      */
     public JsonTypeInfo.Id getMechanism();
}
