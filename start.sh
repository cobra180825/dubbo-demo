docker start mysql redis
docker-compose -f zookeeper.yml up -d
docker run --net=host -d --name dubbo-demo-consumer dubbo-demo-consumer
docker run --net=host -d --name dubbo-demo-provider dubbo-demo-provider
