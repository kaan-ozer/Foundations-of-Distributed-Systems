FROM tomcat:8.5.65-jdk11-corretto

# Add the WAR file to the webapps directory
ADD *.war /usr/local/tomcat/webapps/

# Copy the CorsFilter.java to the appropriate directory
COPY CorsFilter.java /usr/local/tomcat/webapps/YourAppName/WEB-INF/classes/

# Compile the CorsFilter.java and place it in the WEB-INF/classes directory
RUN javac -cp /usr/local/tomcat/lib/servlet-api.jar /usr/local/tomcat/webapps/YourAppName/WEB-INF/classes/CorsFilter.java

EXPOSE 8080

CMD ["catalina.sh", "run"]
