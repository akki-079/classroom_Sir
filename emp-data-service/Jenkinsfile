pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git "https://github.com/sbtalk71/TestWebApp.git"
            }
        }
        stage("compile"){
            steps{
            sh "mvn clean compile"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn package"
            }
        }
        
        stage("docker_build"){
            steps{
            sh "sudo docker build -t sbtalk71/myapp:$BUILD_NUMBER ."
            }
        }
        stage("Push"){
        steps {
        withDockerRegistry([ credentialsId: "dockerCreds", url: "" ]) {
          sh 'docker push sbtalk71/myapp:$BUILD_NUMBER'
        }
      }
    }
    }
   
}