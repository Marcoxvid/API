# API
Simple example of API testing with Java, RestAssured and Cucumber

#Project Structure

API/                                    # Root project
│
├── pom.xml                             # Maven configuration file
│
├── src/                                 
│   ├── main                            #
│   └── test/java/                      # Test code
│           ├── pageobjects/        # Step definitions
            │   ├── BasePage.java   #Base class for step definitions
│   │
│           ├── stepdefinitions/        # Step definitions
│           │   ├── GetRequestStepDefinitions.java
│           │   ├── PostRequestStepDefinitions.java
│           │   ├── PutRequestStepDefinitions.java
│   │
│           └── runners/                # Cucumber runner classes
│               ├── TestRunner.java
│   │
└── src/test/resources/                 # Test resources
    ├── features/                       # Feature files
    │   ├── GetRequest.feature           # Test scenarios for GET requests
    │   ├── PostRequest.feature          # Test scenarios for POST requests
    │   └── PutRequest.feature           # Test scenarios for PUT requests

# Execute on CI Pipeline - Jenkins
pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'  // check version
    }
    stages {
        stage('Checkout') {
            steps {
                git '[https://github.com/seu-repositorio.git](https://github.com/Marcoxvid/API.git)'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Generate Report') {
            steps {
                publishHTML(target: [
                    reportName: 'Cucumber HTML Report',
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'index.html',
                    alwaysLinkToLastBuild: true,
                    keepAll: true
                ])
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            cleanWs()  
        }
    }
}
