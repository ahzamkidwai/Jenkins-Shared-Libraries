def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(
    credentialsId: 'DockerHubCred',
    usernameVariable: 'DOCKER_HUB_USER',
    passwordVariable: 'DOCKER_HUB_PASS'
  )]) {
    sh "docker login -u $DOCKER_HUB_USER -p $DOCKER_HUB_PASS"
    sh "docker image tag ${Project}:${ImageTag} $DOCKER_HUB_USER/${Project}:${ImageTag}"
    sh "docker push $DOCKER_HUB_USER/${Project}:${ImageTag}"
  }
}
