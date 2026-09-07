pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/kanikaprashar10/selenium-ci-cd-framework.git'
            }
        }

        stage('Cross Browser Testing') {

            parallel {

                stage('Chrome') {
                    steps {
                        bat 'mvn test -Dbrowser=chrome'
                    }
                }

                stage('Firefox') {
                    steps {
                        bat 'mvn test -Dbrowser=firefox'
                    }
                }

                stage('Edge') {
                    steps {
                        bat 'mvn test -Dbrowser=edge'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}