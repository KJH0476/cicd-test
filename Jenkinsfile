pipeline {
    // Jenkins 에이전트 지정(모든 에이전트에서 실행)
    agent any

    stages {
        stage('준비') {
            steps {
                sh "echo '빌드 준비!'"
                git branch: 'main',
                credentialsId: 'gitHub-cicd-test',
                url: 'https://github.com/KJH0476/cicd-test.git'
            }
        }
        stage('테스트') {
            steps {
                // Gradle을 이용한 테스트 실행
                sh './gradlew clean test'
                echo '테스트 성공!'
            }
        }
        stage('빌드') {
            steps {
                // 클린 후 빌드 실행
                sh './gradlew clean build'
                echo '빌드 성공!'
            }
        }
        stage('배포') {
            steps {
                script {
                    sshPublisher(
                        continueOnError: false,
                        failOnError: true, // 배포 과정에서 오류 발생 시 빌드 중단
                        publishers: [
                            sshPublisherDesc(
                                configName: 'app-ssh-server', // 사전에 설정한 SSH 서버 이름
                                verbose: true, // 실행 과정을 로그로 상세 출력
                                transfers: [
                                    sshTransfer(
                                        sourceFiles: 'build/libs/*.jar', // 빌드 산출물 지정
                                        remoteDirectory: './cicd-test-app', // 원격 서버 파일 저장 디렉터리
                                        // 배포 스크립트 실행
                                        execCommand: 'sh /home/ubuntu/deploy.sh'
                                    )
                                ]
                            )
                        ]
                    )
                }
                echo '배포 성공!'
            }
        }
    }
    // 파이프라인 종료 후 항상 현재 브랜치 정보를 출력
    post {
        always {
            echo '파이프라인 종료. 현재 브랜치: ${env.BRANCH_NAME}'
        }
    }
}