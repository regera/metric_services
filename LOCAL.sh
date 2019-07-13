clear
set -x

mvn clean
mvn install

cp /Users/toddfaucheux/zips/java/metric_services/target/metric_services.war /usr/local/Cellar/tomcat/9.0.21/libexec/webapps/.
