# HelloApp

Hello App starts with Hello World, progresses to displaying a user name, then names from command-line args and standard input. It then manages names in a collection with list/remove options, refactors into methods and classes, adds persistence across runs, and finally displays names in banner format.

## Project Overview

Hello App is an educational project that teaches Java fundamentals through progressive use cases. The application evolves from a simple console message to a modular, persistent, and extensible system for managing names.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher

### Building the Project

```bash
mvn clean install
```

### Running the Application

```bash
mvn exec:java -Dexec.mainClass="HelloApp"
```

Or compile and run:

```bash
mvn compile
java -cp target/classes HelloApp
```

## Project Structure

```
hello-app/
├── pom.xml
├── README.md
├── .gitignore
├── docs/
│   └── HelloAppUC.md
└── src/
    ├── main/
    │   └── java/
    │       └── HelloApp.java
    └── test/
        └── java/
```

## Development Workflow

This project uses feature branches for each use case. See [HelloAppUC.md](docs/HelloAppUC.md) for detailed use case documentation.

### Branch Strategy
- `main` - Production-ready code
- `dev` - Development branch for integrating features
- `feature/*` - Individual feature branches for each use case
