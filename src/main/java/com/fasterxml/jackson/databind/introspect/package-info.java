/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.13.4.1
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
 * Functionality needed for Bean introspection, required for detecting
 * accessors and mutators for Beans, as well as locating and handling
 * method annotations.
 *<p>
 * Beyond collecting annotations, additional "method annotation inheritance"
 * is also supported: whereas regular JDK classes do not add annotations
 * from overridden methods in any situation. But code in this package does.
 * Similarly class-annotations are inherited properly from interfaces, in
 * addition to abstract and concrete classes.
 */
package com.fasterxml.jackson.databind.introspect;
