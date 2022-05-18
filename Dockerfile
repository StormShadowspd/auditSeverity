#docker
FROM public.ecr.aws/docker/library/openjdk:11-oracle
LABEL maintainer="audit-severity-main.net"
ADD target/severity-0.0.1-SNAPSHOT.jar audit-severity-main.jar
ENTRYPOINT ["java","-jar","audit-severity-main.jar"]


