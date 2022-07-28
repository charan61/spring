pipeline {
    agent any
    stages {
        stage('git repo clone & clean') {
            steps {
               bat "rmdir  /s /q spring"
                bat "git clone https://github.com/charan61/spring.git"
                bat "mvn clean -f spring"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f spring"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f spring"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f spring"
            }
        }
    }
}
