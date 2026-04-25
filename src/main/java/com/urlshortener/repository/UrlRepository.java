package com.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urlshortener.entity.Urldata;

public interface UrlRepository extends JpaRepository<Urldata, Long> {

    Optional<Urldata> findByCleanedUrl(String cleanedUrl);

    Optional<Urldata> findByShortCode(String shortCode);
}