/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.0-RC1
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
Contains basic mapper (conversion) functionality that
allows for converting between regular streaming json content and
Java objects (beans or Tree Model: support for both is via
{@link com.fasterxml.jackson.databind.ObjectMapper} class, as well
as convenience methods included in
{@link com.fasterxml.jackson.core.JsonParser}
<p>
Object mapper will convert Json content to ant from
basic Java wrapper types (Integer, Boolean, Double),
Collection types (List, Map), Java Beans,
Strings and nulls.
<p>
Tree mapper builds dynamically typed tree of {@link com.fasterxml.jackson.core.JsonNode}s
from JSON content (and writes such trees as JSON),
similar to how DOM model works with XML.
Main benefits over Object mapping are:
<ul>
 <li>No null checks are needed (dummy
nodes are created as necessary to represent "missing" Object fields
and Array elements)
  </li>
 <li>No type casts are usually needed: all public access methods are defined
in basic <code>JsonNode</code> class, and when "incompatible" method (such as Array
element access on, say, Boolean node) is used, returned node is
virtual "missing" node.
  </li>
</ul>
Because of its dynamic nature, Tree mapping is often convenient
for basic path access and tree navigation, where structure of
the resulting tree is known in advance.
*/

package com.fasterxml.jackson.databind;
