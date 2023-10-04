/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.4.0-rc1
*    Source File: NoClass.java
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

/**
 * Marker class used with annotations to indicate "no class". This is
 * a silly but necessary work-around -- annotations can not take nulls
 * as either default or explicit values. Hence for class values we must
 * explicitly use a bogus placeholder to denote equivalent of
 * "no class" (for which 'null' is usually the natural choice).
 */
public final class NoClass
{
    private NoClass() { }
}

