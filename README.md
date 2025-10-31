# adeste

Based on the licensing-service described in <https://github.com/ihuaylupo/manning-smia/tree/master/chapter4>

- A littler Maven based Spring Boot application, see xml.pom for details
    - A fake licensing service with basic use of
      - i18n 
      - Spring Boot Actuator for monitoring
- Minimal Docker support

## Basic CLI Usage with Docker

- Build the image: docker build -f <docker filename> -t license-service:5.10.1 .
- Create a container: docker create --name <container name> -p 8080:8080 license-service:5.10.1
- Start an existing container: docker start <container name>
- Or, to create and start a container: docker run ...
- Stop a running container: docker stop <container name>
