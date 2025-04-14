# Spring Boot + Apache Kafka - The Quickstart Practical Guide- Udemy course

Course link: https://www.udemy.com/course/spring-boot-and-apache-kafka/?referralCode=545DF9E4BA28DAAA2832

# Blog posts on JavaGuides
Spring Boot Kafka Producer Consumer Example Tutorial - https://www.javaguides.net/2022/05/spring-boot-kafka-producer-consumer-example-tutorial.html

Spring Boot Kafka JsonSerializer and JsonDeserializer Example - https://www.javaguides.net/2022/05/spring-boot-kafka-jsonserializer-and-Jsondeserializer-example.html


# Running zookeper in local.
cd kafka_2.13-3.1.0
~/Downloads/kafka_2.13-3.1.0$ bash bin/zookeeper-server-start.sh config/zookeeper.properties

# start kafka server 

/Downloads/kafka_2.13-3.1.0$ bash bin/kafka-server-start.sh config/server.properties 

# Steps1:

####add kafka dependency in pom
<dependency>
<groupId>org.springframework.kafka</groupId>
<artifactId>spring-kafka</artifactId>
</dependency>

# Steps2:
create topic [KafkaTopicConfig.java](springboot-kafka-tutorial/src/main/java/net/javaguides/springboot/config/KafkaTopicConfig.java)

# Steps3: provide topic configuration and name
[application.properties](springboot-kafka-tutorial/src/main/resources/application.properties)

# Step4 : create producer and consumer.
[KafkaProducer.java](springboot-kafka-tutorial/src/main/java/net/javaguides/springboot/kafka/KafkaProducer.java)
[KafkaConsumer.java](springboot-kafka-tutorial/src/main/java/net/javaguides/springboot/kafka/KafkaConsumer.java)