package fwk.mongo;

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
