/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.2
*    Source File: Annotated.java
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
package com.fasterxml.jackson.databind.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;

/**
 * Shared base class used for anything on which annotations (included
 * within a {@link AnnotationMap}).
 */
public abstract class Annotated
{
    protected Annotated() { }
    
    public abstract <A extends Annotation> A getAnnotation(Class<A> acls);

    public final <A extends Annotation> boolean hasAnnotation(Class<A> acls)
    {
        return getAnnotation(acls) != null;
    }

    /**
     * Fluent factory method that will construct a new instance that uses specified
     * instance annotations instead of currently configured ones.
     */
    public abstract Annotated withAnnotations(AnnotationMap fallback);

    /**
     * Fluent factory method that will construct a new instance that uses
     * annotations from specified {@link Annotated} as fallback annotations
     */
    public final Annotated withFallBackAnnotationsFrom(Annotated annotated) {
        return withAnnotations(AnnotationMap.merge(getAllAnnotations(), annotated.getAllAnnotations()));
    }
    
    /**
     * Method that can be used to find actual JDK element that this instance
     * represents. It is non-null, except for method/constructor parameters
     * which do not have a JDK counterpart.
     */
    public abstract AnnotatedElement getAnnotated();

    protected abstract int getModifiers();

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public abstract String getName();

    /**
     * Full generic type of the annotated element; definition
     * of what exactly this means depends on sub-class.
     */
    public JavaType getType(TypeBindings context) {
        return context.resolveType(getGenericType());
    }

    /**
     * Full generic type of the annotated element; definition
     * of what exactly this means depends on sub-class.
     */
    public abstract Type getGenericType();

    /**
     * "Raw" type (type-erased class) of the annotated element; definition
     * of what exactly this means depends on sub-class.
     */
    public abstract Class<?> getRawType();

    protected abstract AnnotationMap getAllAnnotations();
}

