pipeline 
{

    agent any
   
    stages 
    {

        stage('Checkout') 
        {
            steps 
            {
                echo 'Checking out source code from git...'
                checkout scm
            }
        }

        stage('Build') 
        {
            steps
            {
                bat 'mvn clean compile'
            }
        }

       
        //=======automatically run Chrome + Firefox + Edge====
        stage('Chrome Test') {
            steps {
				bat 'echo Running chrome'
                bat 'mvn test -Dbrowser=chrome'
            }
        }

        stage('Firefox Test') {
            steps {
				bat 'echo Running firefox'
                bat 'mvn test -Dbrowser=firefox'
            }
        }

        stage('Edge Test') {
            steps {
				bat 'echo Running edge'
                bat 'mvn test -Dbrowser=edge'
            }
        }
        
    }

    post 		//The post section runs after the pipeline finishes.
    { 
        always 
        {
            echo 'Pipeline execution completed.'
        }

        success 
        {
            echo 'Tests passed successfully.'
        }

        failure 
        {
            echo 'Tests failed.'
        }
    }
}