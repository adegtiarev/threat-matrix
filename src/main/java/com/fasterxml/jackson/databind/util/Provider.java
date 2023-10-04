/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.1.5
*    Source File: Provider.java
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

import java.util.*;

/**
* Simple helper class used for decoupling instantiation of
* optionally loaded handlers, like deserializers and deserializers
* for libraries that are only present on some platforms.
 * 
 * @author tatu
 *
 * @param <T> Type of objects provided
 */
public interface Provider<T>
{
    /**
     * Method used to request provider to provide entries it has
     */
    public Collection<T> provide();
}

