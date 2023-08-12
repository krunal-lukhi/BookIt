package fwk.constants;

/**
 * @author Krunal Lukhi
 * @since 11/08/23
 */
public class FwkConstants {
    public static final String LOCAL_HOST = "127.0.0.1";

    public final class MongoConnectionConstants {
        public static final String MONGO_URL = "mongo.url";
        public static final String MONGO_HOST = "mongo.host";
        public static final String MONGO_PORT = "mongo.port";
        public static final String MONGO_DB = "mongo.db";
        public static final String MONGO_RESOURCE_TYPE = "mongo.resource.type";
        public static final String DEFAULT_USERNAME = "admin";
        public static final String DEFAULT_PASSWORD = "admin";
        public static final String CONNECTION_PER_HOST = "mongo.connections.per.host";
        public static final String MAX_CONNECTION_IDLE_TIME = "mongo.connection.max.idle.time";
        public static final String THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER = "mongo.threads.allowed.block.connection.multiplier";
    }
}
