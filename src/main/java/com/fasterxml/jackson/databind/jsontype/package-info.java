/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.8.11.4
*    Source File: package-info.java
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
/**
 * Package that contains interfaces that define how to implement
 * functionality for dynamically resolving type during deserialization.
 * This is needed for complete handling of polymorphic types, where
 * actual type can not be determined statically (declared type is
 * a supertype of actual polymorphic serialized types).
 */
package com.fasterxml.jackson.databind.jsontype;
