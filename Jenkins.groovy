// The Groovy configuration for Jenkins CI job.
node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/maxwu/Genre-Clawer.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
    }
    stage('Build') {
        // Run the maven build
        steps{
            timeout(time: 4, unit: 'MINUTES') {
                if (isUnix()) {
                    sh "mvn -Dmaven.test.failure.ignore clean package"
                } else {
                    bat "mvn -Dmaven.test.failure.ignore clean package"
                }
            }
        }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        // To save disk space, comment the jar files archive instructions
        // archive 'target/*.jar'
    }
}