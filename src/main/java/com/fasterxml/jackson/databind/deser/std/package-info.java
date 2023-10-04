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
 * Contains public standard implementations of abstraction that
 * Jackson uses. This means that they are not merely implementation
 * details, but part of semi-public interface where project
 * tries to maintain backwards compatibility at higher level
 * than for 'impl' types (although less so than with fully
 * public interfaces).
 *<p>
 * Note that since this package was only added relatively late
 * in development cycle, not all classes that belong here are
 * included. Plan is to move more classes over time.
 */
package com.fasterxml.jackson.databind.deser.std;
