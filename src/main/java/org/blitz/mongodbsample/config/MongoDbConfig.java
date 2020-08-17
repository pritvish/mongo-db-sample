package org.blitz.mongodbsample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "org.blitz.mongodbsample.repository")
@Configuration
public class MongoDbConfig {
}
