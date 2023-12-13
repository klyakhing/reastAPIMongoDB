# reastAPIMongoDB
Please use correct MongoDB connection\applications.properties:
spring.data.mongodb.uri=mongodb+srv://login:password@cluster0.t7kjst8.mongodb.net/Cluster0/?retryWrites=true&w=majority

PostController is using
sample_training.posts that could be loaded from MongoDB Atlas.

SalesController is using
sample_supplies.sales that could be loaded from MongoDB Atlas.

One controller is active and other is commented out.


Test API

http://localhost:8080/swagger-ui/index.html#/
