FROM ubuntu:22.04
WORKDIR /app
RUN apt update
RUN apt-get install -y wget
RUN apt-get install zip unzip
RUN apt install -y openjdk-18-jdk
RUN wget https://services.gradle.org/distributions/gradle-8.2-bin.zip -P /tmp
RUN unzip -d /opt/gradle /tmp/gradle-*.zip
RUN ln -s /opt/gradle/gradle-8.2/bin/gradle /usr/bin
CMD ["sh"]