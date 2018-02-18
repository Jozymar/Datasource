docker build -t jozimar/banco ./postgres
docker build -t jozimar/core-datasource ./core-datasource
docker build -t jozimar/web-datasource ./web-datasource
docker build -t jozimar/jsf-datasource ./jsf-datasource

docker run -d --name banco jozimar/banco
docker run -d --name core-datasource --link banco:host-postgres jozimar/core-datasource
docker run -d -p 8080:8080 --name web-datasource --link core-datasource:host-core jozimar/web-datasource
docker run -d -p 8081:8080 --name jsf-datasource --link core-datasource:host-core jozimar/jsf-datasource


