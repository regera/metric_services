FROM tomcat:jdk8-openjdk
EXPOSE 8080
RUN apt update -y && \
    apt install maven -y && \
    apt install git -y && \
    apt install curl -y && \
    git clone https://github.com/regera/metric_services.git $CATALINA_BASE/webapps
RUN cd /$CATALINA_BASE/webapps && \
    pwd && \
    mvn clean package tomcat7:run && \
    cp ./target/metric_services.war /$CATALINA_BASE/webapps/. && \
    ls -al