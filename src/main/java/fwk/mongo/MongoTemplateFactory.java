package fwk.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public interface MongoTemplateFactory {
    MongoTemplate getMongoTemplate();
}
