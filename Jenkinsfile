pipeline {
    agent any
    tools{
         maven 'M2_HOME'
     }
    stages {
         stage('Checkout') {
               steps {
                // Check out your source code from your version control system (e.g., Git)
                checkout scm
            }
         }
        stage('Git') {
            steps {
                echo 'Getting project from Git'
                git branch :'Habib'  ,
                url : 'https://github.com/AbirAyari1/KaddemGroupProject.git'
            }
        }
        stage ('MVN clean'){
            steps{
                sh 'mvn clean';
           }    
        }
    }
}
