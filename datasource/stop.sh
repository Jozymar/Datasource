sudo docker stop web-datasource
sudo docker stop jsf-datasource
sudo docker stop core-datasource
sudo docker stop banco
sudo docker rm web-datasource
sudo docker rm jsf-datasource
sudo docker rm core-datasource
sudo docker rm banco
sudo docker rmi -f jozimar/web-datasource
sudo docker rmi -f jozimar/jsf-datasource
sudo docker rmi -f jozimar/core-datasource
sudo docker rmi -f jozimar/banco

