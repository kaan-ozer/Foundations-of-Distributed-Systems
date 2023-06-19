# Create Web Server Docker Image

Copy files `Dockerfile` and `exam03.war` to the target machine and execute `$> docker build .` (don't forget the point after `build`).

# Start the Web Server 

`$> docker run -p 8080:8080 --rm  <IMAGE_ID>`

# Test the Web Server

Assuming that the Web server is running on 10.10.10.20, open URL `http://10.10.10.20:8080/exam03/api/events` in a Web browser or Postman. You must see an empty JSON collection (`[]`) as result (the database is empty).
