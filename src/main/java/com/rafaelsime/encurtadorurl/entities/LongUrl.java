package com.rafaelsime.encurtadorurl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Document
@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class LongUrl {

    private String id;
    private String longUrl;

    @Indexed(expireAfter = "60s")
    private Instant expiresAt;
}
