# Music-Store
Online Music store is a web application, which was built to sell different kinds of music cds online.


JDK/ JRE version - 1.8.60

run the MusicStoreSchema.sql on MySQL work bench

MySQL user is root and password is 1111 or change the username and passwords in context.xml file of webservice project.

Extract and copy the jar files from jarfiles.zip to Apache Tomcat's lib folder (ignore if any files exists).

For both (Web Service and WebSite) projects, make sure the log4j-1.2.17.jar is referenced correctly, otherwise Add Extenral JARs and refer this jar file from tomcat's lib folder

On the Eclipse workspace menu - Window -> Java Persistence->JPA->Errors/Warnings' next 'Type' and change 'Entity has no primary key' to 'Warnning'. (to ignore primary key error visitevent.java model)

Build and export war files for both projects to Tomcat's webapps folder.

Configure 8443 as https port in Tomcat's server.xml file (inside conf folder)

<Connector
           protocol="org.apache.coyote.http11.Http11Protocol"
           port="8443" maxThreads="200"
           scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="C:\Keystore\myssl.keystore" keystorePass="111111"
           clientAuth="false" sslProtocol="TLS"/>

WebService url: http://localhost:8443/MusicStore

WebSite Url http://localhost:8443/MusicStoreSite
