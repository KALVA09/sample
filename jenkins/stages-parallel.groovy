pipeline {
  agent any
  stages {

    stage('Stage 1') {
      steps {
        script {
          echo 'git pull'
	  sh 'git pull origin master'
        }
      }
    }

    stage('Parallel stages') {
      parallel {

        stage('Stage 2') {
          steps {
            script {
              sh 'jenkins/when-directive.groovy cat stage1 >> stage5 '
            }
          }
        }
        stage('Stage 3') {
          steps {
            script {
              sh 'git push orign master'
            }
          }
        }

      }
    }

  }
}
