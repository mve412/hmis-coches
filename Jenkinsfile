pipeline {
    agent any

    tools {
        // Nombre dado a la instalación de Maven en "Tools configuration"
        maven "maven default"
    }

    stages {
        stage('Git fetch') { 
            steps {
                // Get some code from a GitHub repository
                git url: 'https://mve412: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@github.com/mve412/hmis-coches.git', branch: 'main'
            }
        }
        stage('Compile, Test, Package') { 
            steps {
                // When necessary, use '-f path-to/pom.xml' to give the path to pom.xml
                // Run goal 'package'. It includes compile, test and package.
                sh "mvn  -f pom.xml clean package" 
            }
            post { 
                // Record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts '**/target/*.jar'
                    jacoco( 
                        execPattern: '**/target/jacoco.exec',
                        classPattern: '**/target/classes',
                        sourcePattern: '**/src/',
                        exclusionPattern: '**/test/'
                    )
                    publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
                }
            }
        }
      
	/*
        stage("Quality Gate") {
		steps {
			timeout(time: 1, unit: 'HOURS') {
				// Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
				// true = set pipeline to UNSTABLE, false = don't
				waitForQualityGate abortPipeline: true
			}
		}
	}
	*/
        stage ('Documentation') {
            steps {
	            sh "mvn -f pom.xml javadoc:javadoc javadoc:aggregate" 
            }
            post {
                success {
                    step $class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: false 
                    publishHTML(target: [reportName: 'Maven Site', reportDir: 'target/site', reportFiles: 'index.html', keepAll: false]) 
                }
            }
        }
    }
}
