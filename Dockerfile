FROM openjdk:12-jdk-alpine

ARG PROGRAM_HOME=/opt/program

COPY build/libs/prototype-java-socket.jar $PROGRAM_HOME/server.jar
COPY build/output/libs $PROGRAM_HOME/libs
COPY docker-entrypoint.sh /docker-entrypoint.sh

RUN \
    apk --update add --no-cache --virtual .build-deps \
    shadow && \
    groupadd prg && \
    useradd -m -d /home/prg -g prg prg && \
    chown -R prg:prg $PROGRAM_HOME && \
    chown root:root /docker-entrypoint.sh && \
    chmod 755 /docker-entrypoint.sh

USER prg
WORKDIR /opt/program

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["java", "-jar", "server.jar"]