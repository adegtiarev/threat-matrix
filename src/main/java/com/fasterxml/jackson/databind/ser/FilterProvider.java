/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.2.2
*    Source File: FilterProvider.java
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
package com.fasterxml.jackson.databind.ser;

/**
 * Interface for objects that providers instances of {@link BeanPropertyFilter}
 * that match given ids. A provider is configured to be used during serialization,
 * to find filter to used based on id specified by {@link com.fasterxml.jackson.annotation.JsonFilter}
 * annotation on bean class.
 */
public abstract class FilterProvider
{
    /**
     * Lookup method used to find {@link BeanPropertyFilter} that has specified id.
     * Note that id is typically a {@link java.lang.String}, but is not necessarily
     * limited to that; that is, while standard components use String, custom
     * implementation can choose other kinds of keys.
     * 
     * @return Filter registered with specified id, if one defined; null if
     *   none found.
     */
    public abstract BeanPropertyFilter findFilter(Object filterId);
}
