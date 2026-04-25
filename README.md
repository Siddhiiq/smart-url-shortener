# 🚀 Smart URL Validation & Shortening System

## 📌 Overview
A backend-driven URL shortener with validation, security filtering, duplicate detection, expiry, and analytics tracking.

## 🔥 Features
- URL Validation & Cleaning
- Unsafe Content Detection (adult/xxx filtering)
- Duplicate URL Detection
- Short Code Generation
- Redirect to Original URL
- Click Tracking
- Expiry System
- REST APIs + UI

## 🧱 Tech Stack
- Java
- Spring Boot
- PostgreSQL
- REST APIs
- HTML/CSS/JS (UI)

## 🌐 API Endpoints
- POST `/shorten`
- GET `/r/{code}`
- GET `/analytics/{code}`

## 🖥️ UI
- Input URL → Shorten
- Redirect using code
- Shows expiry & click count

## 🧠 Learning Outcome
Applied real-world data validation, cleaning, filtering, and backend architecture design.

## ▶️ Run Project
```bash
mvn spring-boot:run
