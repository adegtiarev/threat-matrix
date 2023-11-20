/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Release: https://github.com/FasterXML/jackson-databind/releases/tag/jackson-databind-2.0.6
*    Source File: ViewMatcher.java
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

/**
 * Helper class used for checking whether a property is visible
 * in the active view
 */
public abstract class ViewMatcher
{
    public abstract boolean isVisibleForView(Class<?> activeView);

    public static ViewMatcher construct(Class<?>[] views)
    {
        if (views == null) {
            return Empty.instance;
        }
        switch (views.length) {
        case 0:
            return Empty.instance;
        case 1:
            return new Single(views[0]);
        }
        return new Multi(views);
    } 
    
    /*
    /**********************************************************
    /* Concrete sub-classes
    /**********************************************************
     */

    private final static class Empty extends ViewMatcher {
        final static Empty instance = new Empty();
        public boolean isVisibleForView(Class<?> activeView) {
            return false;
        }
    }

    private final static class Single extends ViewMatcher {
        private final Class<?> _view;
        public Single(Class<?> v) { _view = v; }
        public boolean isVisibleForView(Class<?> activeView) {
            return (activeView == _view) || _view.isAssignableFrom(activeView);
        }
    }

    private final static class Multi extends ViewMatcher {
        private final Class<?>[] _views;

        public Multi(Class<?>[] v) { _views = v; }

        public boolean isVisibleForView(Class<?> activeView)
        {
            for (int i = 0, len = _views.length; i < len; ++i) {
                Class<?> view = _views[i];
                if ((activeView == view) || view.isAssignableFrom(activeView)) {
                    return true;
                }
            }
            return false;
        }
    }
}
