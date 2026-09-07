pipeline {

    agent any

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser for Selenium tests'
        )
    }

    stages {

        stage('Checkout') {

            steps {

                echo 'Checking out source code...'

                checkout scm
            }
        }

        stage('Build') {

            steps {

                echo 'Building Maven project...'

                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {

            steps {

                echo "Running tests on ${params.BROWSER}"

                bat "mvn test -Dbrowser=${params.BROWSER}"
            }
        }
    }

    post {

        always {

            echo 'Pipeline execution completed.'
        }

        success {

            echo "Tests passed on ${params.BROWSER}"
        }

        failure {

            echo "Tests failed on ${params.BROWSER}"
        }
    }
}