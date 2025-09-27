### Getting Started

1. Clone the repo
2. Open the console terminal and go to folder OutsideInMonitor
3. Rename the file src\main\resources\application.properties.example to application.properties
4. Fill in the required information
5. .\gradlew build
6. .\gradlew run

### Design Choices

1. Using an external scheduler such as cron vs an inbuilt background daemon
 - saving the last run time
 - con of losing state on service reset, simpler
2. No external db, no external state
3. Single-Simple configuration spec

### Work Backlog

(Roughly in order of priority)
- Write Unit Tests
- Implement remaining use cases of single run, non-verbose, no-notify ...
- Reference Documentation and User Guides

### Additional Links
These additional references should also help you:

TBD


