package io.threatrix.threatmatrix;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.neo4j.Neo4jHealthIndicator;

import java.lang.reflect.Array;
import java.util.Collections;


import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CombineSpringAndJackson {

    /**
     * The Cypher statement used to verify Neo4j is up.
     */
    static final String CYPHER = "match (n) return count(n) as nodes";

    private final SessionFactory sessionFactory;

    /**
     * Create a new {@link Neo4jHealthIndicator} using the specified
     * {@link SessionFactory}.
     * @param sessionFactory the SessionFactory
     */
    public CombineSpringAndJackson(SessionFactory sessionFactory) {
        super("Neo4J health check failed");
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Session session = this.sessionFactory.openSession();
        extractResult(session, builder);
    }

    /**
     * Provide health details using the specified {@link Session} and {@link Health.Builder
     * Builder}.
     * @param session the session to use to execute a cypher statement
     * @param builder the builder to add details to
     * @throws Exception if getting health details failed
     */
    protected void extractResult(Session session, Health.Builder builder)
            throws Exception {
        Result result = session.query(CYPHER, Collections.emptyMap());
        builder.up().withDetail("nodes",
                result.queryResults().iterator().next().get("nodes"));
    }

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
