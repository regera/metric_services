clear
set -x

sshpass -p tomcat123 ssh tomcat@valvcshad001vm << EOF
rm -f /home/tomcat/apache-tomcat-8.0.33/webapps/sample.war 2>/dev/null
rm -rf /home/tomcat/apache-tomcat-8.0.33/webapps/sample 2>/dev/null
EOF

mvn clean
mvn install
if (($? == 0))
then
   mvn tomcat7:redeploy
   if (($? == 0))
   then

      # sleep 15

      echo
      echo "(using Id)..."
      echo
      curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm:8080/sample/api/airports/123
      echo
      echo "(using Code)..."
      echo
      curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm:8080/sample/api/airports/NYC
      echo
      echo"(using text)..."
      echo
      curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm:8080/sample/api/airports/search/Wash
      echo
      echo
   fi
fi
