pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8.6'
        jdk 'JDK-11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Obteniendo código fuente del repositorio...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Unit Tests') {
            steps {
                echo 'Ejecutando pruebas unitarias con JUnit...'
                sh 'mvn test -Dtest=CalculatorTest'
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'index.html',
                        reportName: 'JUnit Test Report'
                    ])
                }
            }
        }
        
        stage('Integration Tests') {
            steps {
                echo 'Ejecutando pruebas de integración con TestNG...'
                sh 'mvn test -Dtest=CalculatorIntegrationTest'
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Empaquetando la aplicación...'
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Quality Gate') {
            steps {
                echo 'Verificando calidad del código...'
                sh 'mvn surefire-report:report'
            }
            post {
                always {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site',
                        reportFiles: 'surefire-report.html',
                        reportName: 'Test Coverage Report'
                    ])
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completado. Limpiando workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline ejecutado exitosamente! ✅'
        }
        failure {
            echo 'Pipeline falló! ❌'
        }
    }
}
