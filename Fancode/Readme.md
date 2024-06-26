FanCode Task Automation
This project automates the scenario where all the users of the city FanCode should have more than half of their todos tasks completed. It uses REST Assured library for API testing.

Setup Instructions
Prerequisites
Java Development Kit (JDK)
Maven
Steps
Clone the Repository:
Clone this repository to your local machine using the following command:
bash
Copy code
git clone <repository_url>
Navigate to Project Directory:
Navigate to the project directory:
bash
Copy code
cd FanCodeTaskAutomation
Compile and Package the Project:
Run the following Maven command to compile the project and package it into a JAR file:
go
Copy code
mvn clean package
Run the Tests:
Execute the following command to run the tests:
bash
Copy code
mvn test
This command will trigger the execution of the test cases defined in FanCodeTaskAutomation.java. The test results will be displayed in the console.
Project Structure
css
Copy code
FanCodeTaskAutomation
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── fancode
│   │               └── automation
│   │                   └── App.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── fancode
│       │           └── automation
│       │               └── FanCodeTaskAutomation.java
│       └── resources
├── pom.xml
└── README.md
Dependencies
REST Assured
TestNG (if used)
Assumptions
The FanCode city can be identified by latitude between -40 to 5 and longitude between 5 to 100 in the /users API.
The task completion percentage is calculated based on the todos tasks retrieved from the /todos API.
Author
[Rajat jain]#   F a n c o d e  
 