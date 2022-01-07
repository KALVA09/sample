pipeline {
  agent any
  stages {

    stage('Stage 1') {
      steps {
        script {
          echo 'git pull https://github.com/KALVA09/sample.git'
        }
      }
    }

    stage('Parallel stages') {
      parallel {

        stage('Stage 2') {
          steps {
            script {
              sh 'stages-parallel.groovy'
            }
          }
        }
        stage('Stage 3') {
          steps {
            script {
              sh 'git push origin master https://github.com/KALVA09/sample.git'
            }
          }
        }

      }
    }

  }
}
