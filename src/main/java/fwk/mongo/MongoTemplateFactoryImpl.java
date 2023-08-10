package fwk.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.internal.MongoClientImpl;
import fwk.lifecycle.AbstractAppSmartLifeCycle;
import fwk.property.PropertyStore;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.data.mongodb.core.MongoTemplate;

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

    @Override
    public MongoTemplate getMongoTemplate() {
//        need to implement this method
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onStop() throws Exception {

    }

}
