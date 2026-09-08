pipeline {

    agent any

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from Git...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test -Dbrowser=${params.BROWSER}"
            }
        }
    }

    post {

        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'Tests passed successfully.'
        }

        failure {
            echo 'Tests failed.'
        }
    }
}