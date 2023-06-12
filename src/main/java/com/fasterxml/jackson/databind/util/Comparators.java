/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.1.5
*    Source File: Comparators.java
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

import java.lang.reflect.Array;

/**
 * Helper class for constructing objects for comparing content values
 */
public class Comparators
{
    /**
     * Helper method used for constructing simple value comparator used for
     * comparing arrays for content equality.
     *<p>
     * Note: current implementation is not optimized for speed; if performance
     * ever becomes an issue, it is possible to construct much more efficient
     * typed instances (one for Object[] and sub-types; one per primitive type).
     */
    public static Object getArrayComparator(final Object defaultValue)
    {
        final int length = Array.getLength(defaultValue);
        return new Object() {
            @Override
            public boolean equals(Object other) {
                if (other == this) return true;
                if (other == null || other.getClass() != defaultValue.getClass()) {
                    return false;
                }
                if (Array.getLength(other) != length) return false;
                // so far so good: compare actual equality; but only shallow one
                for (int i = 0; i < length; ++i) {
                    Object value1 = Array.get(defaultValue, i);
                    Object value2 = Array.get(other, i);
                    if (value1 == value2) continue;
                    if (value1 != null) {
                        if (!value1.equals(value2)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        };
    }
}
