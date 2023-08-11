package fwk.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import fwk.constants.FwkConstants;
import fwk.lifecycle.AbstractAppSmartLifeCycle;
import fwk.property.PropertyStore;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public class MongoTemplateFactoryImpl extends AbstractAppSmartLifeCycle implements MongoTemplateFactory, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private PropertyStore propertyStore;

    public MongoTemplateFactoryImpl(PropertyStore propertyStore) {
        super(Layer.PERSISTENCE);
        this.propertyStore = propertyStore;
    }

    public static MongoClient getMongoClient(PropertyStore propertyStore) {
        try {
            String mongoUrl = propertyStore.fetchProperty(FwkConstants.MongoConnectionConstants.MONGO_URL);
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(mongoUrl)).build();
            return new RetryTemplate().execute((RetryCallback<MongoClient, Throwable>) context -> MongoClients.create(mongoClientSettings));
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
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
