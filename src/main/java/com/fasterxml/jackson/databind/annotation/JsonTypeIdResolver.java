/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.2
*    Source File: JsonTypeIdResolver.java
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
package com.fasterxml.jackson.databind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/**
 * Annotation that can be used to plug a custom type identifier handler
 * ({@link TypeIdResolver})
 * to be used by
 * {@link com.fasterxml.jackson.databind.jsontype.TypeSerializer}s
 * and {@link com.fasterxml.jackson.databind.jsontype.TypeDeserializer}s
 * for converting between java types and type id included in JSON content.
 * In simplest cases this can be a simple class with static mapping between
 * type names and matching classes.
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonTypeIdResolver
{
    /**
     * Defines implementation class of {@link TypeIdResolver} to use for
     * converting between external type id (type name) and actual
     * type of object.
     */
    public Class<? extends TypeIdResolver> value();
}
