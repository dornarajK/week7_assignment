pipeline {

    agent any

    environment {
        DB_HOST = 'localhost'
        DB_PORT = '3306'
        DB_NAME = 'temperature_converter'
        DB_USER = 'root'
        DB_PASSWORD = credentials('MariaDBPassword')
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/dornarajK/week7_assignment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t dornarajk/temperature-converter-javafx:latest .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([
                        usernamePassword(
                                credentialsId: 'DockerHub',
                                usernameVariable: 'DOCKER_USERNAME',
                                passwordVariable: 'DOCKER_PASSWORD'
                        )
                ]) {
                    bat 'echo %DOCKER_PASSWORD%| docker login -u %DOCKER_USERNAME% --password-stdin'
                }
            }
        }

        stage('Docker Push') {
            steps {
                bat 'docker push dornarajk/temperature-converter-javafx:latest'
            }
        }
    }
}