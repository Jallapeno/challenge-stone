<h1> Stone JavaScript/Typescript Developer Challenge made with <u>Java Spring</u></h1> 
<hr>
<h2> The Challenge </h2>
<hr>

Create an application that ensures the Docker containers managements. Your application have to be able to: 
 - list containers
 - list images
 - start, stop, delete existing containers
 - create new ones sending the image name.
<hr>
<h2> Running </h2>

### On Docker (Optional):
Run ``` docker build -t spring-boot-stone-chalenger-java-app:1.0 . ``` and ``` docker run -p 8080:8080 spring-boot-stone-chalenger-java-app:1.0 . ``` to run on the Docker.

<p> After start this project locally or on Docker, you can use next collections: </p>

<b>List all images</b>

curl --request GET \
--url http://localhost:8080/api/images \
--header 'User-Agent: insomnia/9.3.3'

<hr>

<b>List all containers</b>

curl --request GET \
--url http://localhost:8080/api/containers \
--header 'User-Agent: insomnia/9.3.3'

<hr>

<b>Stop container by id</b>

curl --request POST \
--url http://localhost:8080/api/containers/{{your_container_id}}/stop \
--header 'User-Agent: insomnia/9.3.3'

<hr>

<b>Start container by id</b>

curl --request POST \
--url http://localhost:8080/api/containers/{{your_container_id}}/start \
--header 'User-Agent: insomnia/9.3.3'

<hr>

<b>Create a new containers</b>

curl --request POST \
--url http://localhost:8080/api/containers/{{your_container_name}}/create \
--header 'User-Agent: insomnia/9.3.3'

<hr>

<b>Delete container by id</b>

curl --request DELETE \
--url http://localhost:8080/api/containers/{{your_container_id}} \
--header 'User-Agent: insomnia/9.3.3'