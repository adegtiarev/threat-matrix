/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.2
*    Source File: JsonTypeResolver.java
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

import java.lang.annotation.*;

import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

/**
 * Annotation that can be used to explicitly define custom resolver
 * used for handling serialization and deserialization of type information,
 * needed for handling of polymorphic types (or sometimes just for linking
 * abstract types to concrete types)
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@com.fasterxml.jackson.annotation.JacksonAnnotation
public @interface JsonTypeResolver
{
    /**
     * Defines implementation class of {@link TypeResolverBuilder} which is used to construct
     * actual {@link com.fasterxml.jackson.databind.jsontype.TypeDeserializer} and {@link com.fasterxml.jackson.databind.jsontype.TypeDeserializer}
     * instances that handle reading and writing addition type information needed to support polymorphic
     * deserialization.
     */
    public Class<? extends TypeResolverBuilder<?>> value();
}
