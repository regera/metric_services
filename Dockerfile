FROM tomcat:jdk8-openjdk
EXPOSE 8080
COPY ./tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
CMD ["catalina.sh", "run"]
RUN apt update -y && \
    apt install maven -y && \
    apt install git -y && \
    apt install curl -y && \
    git clone https://github.com/regera/metric_services.git $CATALINA_BASE/webapps
RUN cd /$CATALINA_BASE/webapps && \
    mvn clean tomcat7:deploy