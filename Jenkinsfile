pipeline 
{

    agent any

    stages 
    {

        stage('Checkout') 
        {
            steps 
            {
                echo 'Checking out source code...'
            }
        }

        stage('Build') 
        {
            steps
            {
                bat 'mvn clean compile'
            }
        }

        stage('Test') 
        {
            steps 
            {
                bat 'mvn test -Dbrowser=chrome'
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