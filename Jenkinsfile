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

        stage('Run Tests') {
            steps {
                bat "mvn clean test -Dbrowser=${params.BROWSER}"
            }
        }
    }
}