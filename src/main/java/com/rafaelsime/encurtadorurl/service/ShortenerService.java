package com.rafaelsime.encurtadorurl.service;

import com.rafaelsime.encurtadorurl.dto.LongUrlDTO;
import com.rafaelsime.encurtadorurl.dto.ShortenedUrlDTO;
import com.rafaelsime.encurtadorurl.entities.LongUrl;
import com.rafaelsime.encurtadorurl.repository.UrlRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ShortenerService {

    @Autowired
    UrlRepository repository;

    public ShortenedUrlDTO urlShortener(LongUrlDTO url) {

        RandomStringGenerator randomString = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit).build();

        String id;
        do {
            id = randomString.generate(5, 10);
        } while (repository.existsById(id));

        LongUrl entity = new LongUrl(id, url.getLongUrl(), Instant.now());

        entity = repository.save(entity);

        return new ShortenedUrlDTO(id);
    }

    public LongUrlDTO findById(String id) {
        LongUrl entity = repository.findById(id).orElseThrow(() -> new RuntimeException("link não encontrado"));
        return new LongUrlDTO(entity);
    }
}
