# 🚀 Graph Acyclic Checker

💻 **Java Implementation of Directed Graph Acyclicity Checking**
📘 Coursework for *5SENG003W Algorithms – University of Westminster*

---

## 📌 Overview

This project implements an algorithm to determine whether a **directed graph is acyclic (contains no cycles)**.

It uses the **Sink Elimination Algorithm**, along with additional logic for:

* 🔍 Cycle detection
* 📂 File-based graph parsing
* ⚡ Benchmark performance testing

---

## 🧠 Key Concepts

* Directed Graphs
* Cycle Detection
* Sink Elimination Algorithm
* Data Structures (Adjacency List)
* Algorithm Performance Analysis (Big-O)

---

## ⚙️ Features

✔ Read graph data from text files
✔ Detect whether a graph is acyclic
✔ Step-by-step sink removal output
✔ Identify and print cycles (if present)
✔ Run on multiple benchmark datasets
✔ Measure execution performance

---

## 📁 Project Structure

```
GraphAcyclicChecker/
│
├── src/com/avishka/
│   ├── Main.java
│   ├── Graph.java
│   ├── GraphParser.java
│   ├── SinkElimination.java
│   └── CycleDetector.java
│
├── benchmark/
│   ├── acyclic/
│   └── cyclic/
│
├── README.md
└── .gitignore
```

---

## 📥 Input Format

Graph input files contain edge pairs:

```
1 2
3 1
2 5
```

➡️ Meaning:

* 1 → 2
* 3 → 1
* 2 → 5

---

## ▶️ How to Run

### 1️⃣ Compile

```bash
javac src/com/avishka/*.java
```

### 2️⃣ Run

```bash
java com.avishka.Main
```

---

## 🧪 Benchmark Testing

The project includes a **benchmark dataset**:

```
benchmark/
 ├── acyclic/   → Graphs with NO cycles
 └── cyclic/    → Graphs WITH cycles
```

✔ Used for:

* Validating correctness
* Performance evaluation
* Coursework report analysis

---

## 📊 Algorithm Used

### 🔹 Sink Elimination Algorithm

1. Find a sink (node with no outgoing edges)
2. Remove it
3. Repeat
4. If graph becomes empty → ✅ Acyclic
5. If no sink exists → ❌ Cycle detected

---

## 📈 Performance

* Time Complexity: **O(V + E)**
* Efficient for large graphs using adjacency list

---

## 🎓 Coursework Details

* Module: **5SENG003W Algorithms**
* University: **University of Westminster**
* Academic Year: **2025/26**

---

## 👨‍💻 Author

**Avishka Madushan**
💡 IT Student | Software Developer 🇱🇰

---

## 🏷️ Tags

`java` `algorithms` `graph-theory` `cycle-detection` `data-structures`

---
