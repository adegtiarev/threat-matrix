/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.6
*    Source File: NamedType.java
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
package com.fasterxml.jackson.databind.jsontype;

/**
 * Simple container class for types with optional logical name, used
 * as external identifier
 * 
 * @author tatu
 */
public final class NamedType
{
    protected final Class<?> _class;
    protected final int _hashCode;

    protected String _name;
    
    public NamedType(Class<?> c) { this(c, null); }
    
    public NamedType(Class<?> c, String name)
    {
        _class = c;
        _hashCode = c.getName().hashCode();
        setName(name);
    }

    public Class<?> getType() { return _class; }
    public String getName() { return _name; }
    public void setName(String name) {
        _name = (name == null || name.length() == 0) ? null : name;
    }

    public boolean hasName() { return _name != null; }
    
    /**
     * Equality is defined based on class only, not on name
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;
        return _class == ((NamedType) o)._class;
    }

    @Override
    public int hashCode() { return _hashCode; }

    @Override
    public String toString() {
    	return "[NamedType, class "+_class.getName()+", name: "+(_name == null ? "null" :("'"+_name+"'"))+"]";
    }
}
