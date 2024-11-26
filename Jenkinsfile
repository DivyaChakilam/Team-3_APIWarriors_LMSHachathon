pipeline {
  agent any
  triggers {
    pollSCM '*/5 * * * *'
  }
  tools {
    maven "maven3_9_9"
  }
  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        sh 'mvn clean'
        echo 'Build step completed'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
        sh 'mvn test'
      }
      post {
        success {
          allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [
              [path: 'allure-report']
            ]
          ])
        }
      }
    }
//     stage('Cucumber Reports') {
//       steps {
//         cucumber buildStatus: "UNSTABLE",
//           fileIncludePattern: "**/cucumber.json",
//           jsonReportDirectory: 'target'
//       }
//     }
  }
}
