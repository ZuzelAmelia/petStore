pipeline {
    agent any
    environment {
        CI = 'true'
    }
    stages {
        stage('Compile and Execute') {
            steps {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean test'
                }
            }
        stage('Create Reports') {
            steps {
                sh './gradlew aggregate'
            }
        }
    }
}