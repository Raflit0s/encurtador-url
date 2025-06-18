package com.rafaelsime.encurtadorurl.repository;

import com.rafaelsime.encurtadorurl.entities.LongUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<LongUrl, String> {
}
