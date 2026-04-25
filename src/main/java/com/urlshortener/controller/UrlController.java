package com.urlshortener.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortener.dto.UrlRequest;
import com.urlshortener.dto.UrlResponse;
import com.urlshortener.service.UrlService;

@RestController
@CrossOrigin
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public UrlResponse shorten(@RequestBody UrlRequest request) {
        return service.shortenUrl(request.getUrl());
    }

    @GetMapping("/r/{code}")
    public String redirect(@PathVariable String code) {
        return service.getOriginalUrl(code);
    }

    @GetMapping("/analytics/{code}")
    public UrlResponse analytics(@PathVariable String code) {
        return service.getAnalytics(code);
    }
}