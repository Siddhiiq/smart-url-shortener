package com.urlshortener.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.urlshortener.dto.UrlResponse;
import com.urlshortener.entity.Urldata;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.util.ShortCodeGenerator;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    // 🔥 SHORTEN
    public UrlResponse shortenUrl(String url) {

        if (url == null || url.trim().isEmpty()) {
            return new UrlResponse("Invalid URL", null, null, null, false);
        }

        String cleanedUrl = url.trim().toLowerCase();

        if (!cleanedUrl.startsWith("http")) {
            return new UrlResponse("Invalid URL", null, null, null, false);
        }

        if (cleanedUrl.contains("adult") || cleanedUrl.contains("xxx")) {
            return new UrlResponse("Restricted URL", null, null, null, false);
        }

        Optional<Urldata> existing = repository.findByCleanedUrl(cleanedUrl);

        if (existing.isPresent()) {
            Urldata data = existing.get();
            return new UrlResponse(
                    "Already exists",
                    "http://localhost:8081/r/" + data.getShortCode(),
                    data.getExpiryDate().toString(),
                    data.getClickCount(),
                    true
            );
        }

        String code = ShortCodeGenerator.generateShortCode();

        Urldata data = new Urldata();
        data.setOriginalUrl(url);
        data.setCleanedUrl(cleanedUrl);
        data.setShortCode(code);
        data.setIsValid(true);
        data.setIsDuplicate(false);
        data.setIsSafe(true);
        data.setCreatedAt(LocalDateTime.now());
        data.setClickCount(0L);
        data.setExpiryDate(LocalDateTime.now().plusDays(7));

        repository.save(data);

        return new UrlResponse(
                "Success",
                "http://localhost:8081/r/" + code,
                data.getExpiryDate().toString(),
                0L,
                false
        );
    }

    // 🔁 REDIRECT (returns original URL)
    public String getOriginalUrl(String code) {

        Optional<Urldata> data = repository.findByShortCode(code);

        if (data.isEmpty()) return null;

        Urldata url = data.get();

        if (url.getExpiryDate().isBefore(LocalDateTime.now())) return null;

        url.setClickCount(url.getClickCount() + 1);
        repository.save(url);

        return url.getOriginalUrl();
    }

    // 📊 ANALYTICS
    public UrlResponse getAnalytics(String code) {
        Optional<Urldata> data = repository.findByShortCode(code);

        if (data.isEmpty()) {
            return new UrlResponse("Not Found", null, null, null, false);
        }

        Urldata url = data.get();

        return new UrlResponse(
                "Analytics",
                "http://localhost:8081/r/" + code,
                url.getExpiryDate().toString(),
                url.getClickCount(),
                false
        );
    }
}