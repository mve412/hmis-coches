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
                git url: 'https://github.com/mve412/hmis-coches.git', branch: 'main'
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
        stage ('Analysis') {
            steps {
	            // Warnings next generation plugin required
	            sh "mvn -f pom.xml site"
            }
            post {
                success {
                    dependencyCheckPublisher pattern: '**/target/site/en/dependency-check-report.xml'
                    recordIssues enabledForFailure: true, tool: checkStyle()
                    recordIssues enabledForFailure: true, tool: pmdParser()
                    recordIssues enabledForFailure: true, tool: cpd()
                    // recordIssues enabledForFailure: true, tool: findBugs()
                    recordIssues enabledForFailure: true, tool: spotBugs()
                }
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'sonar_server_mve412', installationName: 'servidor_sonarqube_mve412') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=hmis-coches-mve412'
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
