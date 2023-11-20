/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.6.7.5
*    Source File: Annotations.java
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
package com.fasterxml.jackson.databind.util;

import java.lang.annotation.Annotation;

/**
 * Interface that defines interface for accessing contents of a
 * collection of annotations. This is needed when introspecting
 * annotation-based features from different kinds of things, not
 * just objects that Java Reflection interface exposes.
 *<p>
 * Standard mutable implementation is {@link com.fasterxml.jackson.databind.introspect.AnnotationMap}
 */
public interface Annotations
{
    /**
     * Main access method used to find value for given annotation.
     */
    public <A extends Annotation> A get(Class<A> cls);

    /**
     * Returns number of annotation entries in this collection.
     */
    public int size();
}
