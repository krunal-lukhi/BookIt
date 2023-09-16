package fwk.mongo;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ConnectionPoolSettings;
import fwk.common.LoggingUtils;
import fwk.constants.FwkConstants;
import fwk.lifecycle.AbstractAppSmartLifeCycle;
import fwk.property.PropertyStore;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public class MongoTemplateFactoryImpl extends AbstractAppSmartLifeCycle implements MongoTemplateFactory, ApplicationContextAware {
    private static final Logger LOGGER = LoggingUtils.getLogger(MongoTemplateFactoryImpl.class);
    private ApplicationContext applicationContext;
    private PropertyStore propertyStore;

    public MongoTemplateFactoryImpl(PropertyStore propertyStore) {
        super(Layer.PERSISTENCE);
        this.propertyStore = propertyStore;
    }

    public MongoClient getMongoClient(PropertyStore propertyStore) {
        try {
            //todo
            String mongoUrl = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.MONGO_URL);
            MongoClientSettings mongoClientSettings = buildMongoClientSetting(mongoUrl);
            return new RetryTemplate().execute((RetryCallback<MongoClient, Throwable>) context -> MongoClients.create(mongoClientSettings));
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while creating mongo template. Exception");
            throw runtimeException;
        } catch (Throwable throwable) {
            LOGGER.error("Error while creating mongo template. Exception");
            throw new RuntimeException(throwable);
        }
    }

    private MongoClientSettings buildMongoClientSetting(String mongoUrl) {
        final String maxConnectionIdleTime = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.MAX_CONNECTION_IDLE_TIME);
        final String username = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.DEFAULT_USERNAME);
        final String password = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.DEFAULT_PASSWORD);
        final String database = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.MONGO_DB);
        final String maxConnection = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.CONNECTION_PER_HOST);
        final String blockedThread = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER);
        return MongoClientSettings.builder().applyConnectionString(new ConnectionString(mongoUrl))
                .applyToConnectionPoolSettings((Block<ConnectionPoolSettings.Builder>) ConnectionPoolSettings.builder()
                        .maxConnectionIdleTime(Long.valueOf(maxConnectionIdleTime), TimeUnit.SECONDS)
                        .maxSize(Integer.valueOf(maxConnection))
                        .maxWaitQueueSize(Integer.valueOf(blockedThread)).build())
                .credential(MongoCredential.createCredential(username, database, password.toCharArray())).build();
    }

    @Override
    public MongoTemplate getMongoTemplate() {
        //        need to implement this method\
        MongoClient mongoClient = getMongoClient(propertyStore);
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.MONGO_DB)));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onStop() throws Exception {

    }

}
