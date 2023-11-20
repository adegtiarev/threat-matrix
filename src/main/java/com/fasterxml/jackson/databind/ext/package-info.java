/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.15.2
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
Contains extended support for "external" packages: things that
may or may not be present in runtime environment, but that are
commonly enough used so that explicit support can be added.
<p>
Currently supported extensions include:
<ul>
 <li>Support for Java 1.5 core XML datatypes: the reason these are
considered "external" is that some platforms that claim to be 1.5 conformant
are only partially so (Google Android, GAE) and do not included these
 types.
  </li>
 <li>Joda time. This package has superior date/time handling functionality,
and is thus supported. However, to minimize forced dependencies this
support is added as extension so that Joda is not needed by Jackson
itself: but if it is present, its core types are supported to some
degree
  </li>
</ul>

*/

package com.fasterxml.jackson.databind.ext;
