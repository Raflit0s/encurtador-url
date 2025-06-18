package com.rafaelsime.encurtadorurl.controller;

import com.rafaelsime.encurtadorurl.dto.LongUrlDTO;
import com.rafaelsime.encurtadorurl.dto.ShortenedUrlDTO;
import com.rafaelsime.encurtadorurl.service.ShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Controller
public class UrlController {

    @Autowired
    ShortenerService service;

    @PostMapping(value = "shorten-url")
    public ResponseEntity<String> urlShortener(@RequestBody LongUrlDTO fullUrl, HttpServletRequest url) {
        ShortenedUrlDTO urlShortener = service.urlShortener(fullUrl);
        String shortenedUrl = url.getRequestURL().toString().replace("shorten-url", urlShortener.getShortUrl());
        return ResponseEntity.ok(shortenedUrl);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        LongUrlDTO shortenedUrl = service.findById(id);

        HttpHeaders url = new HttpHeaders();
        url.setLocation(URI.create(shortenedUrl.getLongUrl()));
        return ResponseEntity.status(HttpStatus.FOUND).headers(url).build();
    }
}
