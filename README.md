# BombRecognition Spring Boot Project

## Overview
This project is a **Bomb Recognition system** for processing and classifying documents using Spring Boot.  
It classifies text chunks into different topics like Bomb, Weapon, etc.  
Swagger UI is integrated for API documentation and testing.

---

## Features
- Upload PDF or text files and process document
- Automatic text chunk classification
- Topic-based classification using keywords
- Dashboard API to see total documents, chunks, and topic distribution
- Clean architecture: DTOs, Service, Repository
- Swagger UI for testing APIs

---

## Technologies
- Java 17 / 11
- Spring Boot
- Hibernate / JPA
- MySQL (or H2 for testing)
- ModelMapper
- Swagger (springdoc-openapi)
- PDFBox for PDF parsing

---

## Endpoints
### Topic APIs
- `POST /api/topics` – Add new topics  
- `GET /api/topics` – Get all topics  

### Document APIs
- `POST /api/documents` – Upload PDF/text document  
- `GET /api/documents/{id}/results` – Get classification results  

### Dashboard API
- `GET /api/dashboard` – Get total documents, chunks, and topic distribution  

---

## Swagger UI
Run the project and open Swagger:  

##Screen shot
<img width="1919" height="1079" alt="Screenshot 2026-03-25 101953" src="https://github.com/user-attachments/assets/878bcfd6-f30c-4f7d-af10-6ae735abade7" />
<img width="1919" height="1079" alt="Screenshot 2026-03-25 101934" src="https://github.com/user-attachments/assets/b93d99e1-8add-4689-aea7-36b77b3f16ff" />
<img width="1919" height="1079" alt="Screenshot 2026-03-25 101910" src="https://github.com/user-attachments/assets/153cf18f-561e-4d55-bc64-96412413bc02" />
<img width="1919" height="977" alt="Screenshot 2026-03-25 101855" src="https://github.com/user-attachments/assets/ce4dac7c-5383-43c6-807a-7e8aa167ab1a" />
