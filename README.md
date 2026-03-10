# Hash Table Fundamentals and Practical Implementations

## Project Description
This repository demonstrates several **real-world applications of hash tables** implemented using Java. The project contains implementations of **ten practical system design scenarios** that rely on hash-based data structures such as `HashMap` and array-based hashing techniques.

Each problem highlights how constant-time lookup structures can be used to build scalable systems in domains such as social media platforms, e-commerce systems, caching services, analytics dashboards, and financial transaction monitoring.

The implementations are written in Java and executed with **sample inputs embedded directly in the program** to illustrate the behavior of each system.

---

## Technologies and Concepts Used
The following technologies and programming concepts are utilized throughout the project:

- Java Programming Language
- HashMap and Hash-based data structures
- Constant time lookup (O(1))
- Collision handling strategies
- Frequency counting techniques
- Basic caching mechanisms
- System design simulation using data structures

---

## Implemented Problems

### 1. Username Availability System
A simulation of a social media registration service that checks whether a username already exists.

Features:
- Instant username lookup using HashMap
- Tracking frequency of attempted usernames
- Suggesting alternative usernames when conflicts occur

---

### 2. Flash Sale Inventory Manager
A simplified model of an e-commerce flash sale system.

Features:
- Real-time stock tracking
- Prevention of overselling during high traffic
- Instant inventory lookup using hash-based storage

---

### 3. DNS Resolver Cache
A basic DNS caching mechanism that stores domain-to-IP mappings.

Features:
- Cache hit and cache miss simulation
- TTL-based entry expiration
- Faster repeated lookups using stored entries

---

### 4. Document Similarity Checker
A plagiarism detection prototype that analyzes text similarity.

Features:
- Text broken into n-grams
- Hash tables used for storing and comparing patterns
- Identification of similar documents based on overlapping n-grams

---

### 5. Website Traffic Analytics
A lightweight analytics system that processes page visit events.

Features:
- Counting page visits
- Tracking unique visitors
- Monitoring traffic sources

---

### 6. API Rate Limiter
A simple rate-limiting mechanism for API gateways.

Features:
- Tracks request counts per client
- Prevents excessive API calls
- Demonstrates request throttling logic

---

### 7. Search Query Autocomplete
A basic autocomplete system inspired by search engines.

Features:
- Stores search queries with frequency values
- Generates suggestions for user input prefixes
- Demonstrates query popularity tracking

---

### 8. Smart Parking Allocation System
A parking lot management system using open addressing.

Features:
- Hash-based parking slot assignment
- Linear probing collision resolution
- Vehicle entry management

---

### 9. Transaction Pair Detection (Two-Sum)
A financial transaction monitoring utility.

Features:
- Identifies transaction pairs matching a target amount
- Uses constant-time complement lookup

---

### 10. Multi-Level Cache Simulation
A simplified caching hierarchy similar to large-scale streaming services.

Features:
- L1 memory cache
- L2 secondary cache
- Demonstration of cache hits and misses

---

## Project Structure

```
Hash-Table-Fundamentals-and-Implementation
│
├── src
│   └── HashTableSystems.java
│
└── README.md
```
## How to Run the Program

### Step 1: Compile the program

```
javac HashTableSystems.java
```

### Step 2: Run the program

```
java HashTableSystems
```

The program will execute all ten scenarios sequentially and display sample outputs in the console.

---

## Key Learning Outcomes
This project demonstrates how hash tables can be applied in the design of scalable systems.

Concepts illustrated include:

- Efficient data lookup
- Real-time event tracking
- Collision handling strategies
- Cache design
- System-level problem modeling

---

## Author
Mohit Verma
