package com.urlshortener.dto;

public class UrlResponse {

    private String message;
    private String shortUrl;
    private String expiryDate;
    private Long clickCount;
    private Boolean isDuplicate;

    public UrlResponse() {}

    public UrlResponse(String message, String shortUrl,
                       String expiryDate, Long clickCount, Boolean isDuplicate) {
        this.message = message;
        this.shortUrl = shortUrl;
        this.expiryDate = expiryDate;
        this.clickCount = clickCount;
        this.isDuplicate = isDuplicate;
    }

    // getters & setters

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getShortUrl() { return shortUrl; }
    public void setShortUrl(String shortUrl) { this.shortUrl = shortUrl; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public Long getClickCount() { return clickCount; }
    public void setClickCount(Long clickCount) { this.clickCount = clickCount; }

    public Boolean getIsDuplicate() { return isDuplicate; }
    public void setIsDuplicate(Boolean isDuplicate) { this.isDuplicate = isDuplicate; }
}