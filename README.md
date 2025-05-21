# Spring Boot Greeting REST API

Welcome to the Greeting App – a simple Spring Boot project that exposes a REST API to return greeting messages.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [API Endpoint](#api-endpoint)
- [How to Run](#how-to-run)
- [Next Steps](#next-steps)

## Overview

This Spring Boot application demonstrates a minimal REST controller setup that returns a personalized greeting based on the input.

## Technologies Used

- Java 17+
- Spring Boot
- Spring Web (REST API)
- Lombok
- Maven

## Features

- Simple REST endpoint  
- Dynamic greeting using path variables or query parameters  
- Starter template for learning REST with Spring Boot

## API Endpoint

- `GET /greeting` – Returns default greeting  
- `GET /greeting?name=User` – Returns personalized greeting

**Example Response:**
```json
{
  "message": "Hello, User!"
}
