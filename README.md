# Using Redis 
# Set the host and port value at src/main/resources/application.properties file

# Start the Redis server , if local use 
$redis-server

# Test if Redis started successfully or not 
$ redis-cli -h localhost

# Compile and run the code
$ ./gradlew bootRun

# Testing redis service
# To Set
curl -X POST -F 'value=Deepesh Rajpal' -F 'key=name' http://localhost:9090/redis/set

# To Get
curl -X POST -F 'key=name' http://localhost:9090/redis/get

# TEST API
curl -X POST -F 'amount=2' -F 'key=name' http://localhost:9090/load/check