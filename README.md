cdi-resteasy-hibernate-angularjs-tomcat-sample
==============================================

Sample application with full CRUD for Airport codes to showcase following technologies: 
- Java 7
- CDI 
- RestEasy (JAX-RS) 
- JPA / Hibernate
- AngularJS 1.0 (needs update to Angular2.0)
- Bootstrap 
- Maven (build) 

Setup
-----
- Use your favorite IDE to deploy and run the application. 
- Use maven command to deploy to Tomcat. NOTE: maven settings.xml (in ~/.m2/repository/) need to be configured with your local/remote server. 
```bash
$ mvn tomcat7:deploy
```

Access
------
- via browser using url: 
```
http://valvcshad001vm.val.vlss.local:8080/sample 
```
![Alt text](/sample.png?raw=true "Sample page")

- via REST client using url: 
```html
GET http://valvcshad001vm.val.vlss.local:8080/sample/api/airports
GET http://valvcshad001vm.val.vlss.local:8080/sample/api/airports/123 (using id)
GET http://valvcshad001vm.val.vlss.local:8080/sample/api/airports/NYC (using code)
GET http://valvcshad001vm.val.vlss.local:8080/sample/api/airports/search/Wash (using text) 
POST http://valvcshad001vm.val.vlss.local:8080/sample/api/airports
PUT http://valvcshad001vm.val.vlss.local:8080/sample/api/airports
DELETE http://valvcshad001vm.val.vlss.local:8080/sample/api/airports/123 (using id)
```

Required Server Config for "mvn tomcat7:redeploy"
------------------------------------------------
- ADD the following to $TOMCAT_HOME/conf/tomcat-users.xml
<role rolename="manager-script"/>
<role rolename="manager"/>
<user username="test" password="test" roles="manager,manager-script"/>

- Sample ~/.m2/repository/settings.xml
<settings>
   <servers>
     <server>
        <id>tomcat-manager</id>
        <username>test</username>
        <password>test</password>
     </server>
   </servers>
</settings>
