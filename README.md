# Task Manager Java

A console-based task management application built with pure Java 25, Gson, and JSON Schema validation. No frameworks —
just clean Java.

## What it does

Task Manager lets you manage a personal task list from the terminal. Tasks are persisted to a local JSON file and
validated against a JSON Schema every time the app starts.

**Features:**

- Add tasks with a title and description
- List all tasks with their current status
- Complete a task by ID
- Reopen a completed task back to pending
- Delete a task by ID
- JSON persistence — tasks survive app restarts
- JSON Schema validation on startup — corrupted files are detected before any data is loaded

## How to run it

### Prerequisites

- Java 25 (OpenJDK)
- Maven

### Steps

**1. Clone the repository**

```bash
git clone https://github.com/your-username/taskmanager-java-vanilla.git
cd taskmanager-java-vanilla
```

**2. Open in IntelliJ IDEA**

Open the project folder in IntelliJ IDEA. Maven will automatically detect the `pom.xml` and download the dependencies.

**3. Run the app**

Locate `Main.java` and click the green Run button. The app creates `data/tasks.json` automatically on first run.

## Project structure

```
taskmanager-java-vanilla/
├── data/
│   └── tasks-schema.json       # JSON Schema draft-07 for validation
├── src/main/java/com/federicog/taskmanager/
│   ├── Main.java               # Entry point
│   ├── model/
│   │   ├── Task.java           # Task POJO
│   │   └── TaskStatus.java     # Enum: PENDING / COMPLETED
│   ├── exception/
│   │   └── TaskNotFoundException.java
│   ├── service/
│   │   └── TaskService.java    # Business logic
│   ├── util/
│   │   ├── Config.java         # File path constants
│   │   ├── JsonUtil.java       # Read/write tasks.json with Gson
│   │   └── SchemaValidator.java
│   ├── controller/
│   │   └── TaskController.java # MVC coordinator
│   └── view/
│       └── TaskView.java       # Console output only
└── pom.xml
```

## Architecture

This project follows the **MVC pattern**:

```
User input
    ↓
TaskController   — reads Scanner, coordinates layers
    ↓                    ↓
TaskService      TaskView
Business logic   Console output only
    ↓
JsonUtil
Read/write tasks.json
```

Each layer has a single responsibility and does not reach into other layers directly.

## Concepts applied

This project was built as a portfolio exercise based on the DevTalles course *"Java: Explora el lenguaje desde cero"*.

## Dependencies

```xml
<!-- Gson — JSON serialization/deserialization -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.13.2</version>
</dependency>

        <!-- everit-json-schema — JSON Schema draft-07 validation -->
<dependency>
<groupId>com.github.erosb</groupId>
<artifactId>everit-json-schema</artifactId>
<version>1.14.6</version>
</dependency>
```