## Mysql 
1. Run dockewr command with latest image and set your password for root user 

```bash
 docker run --name mysql  -e MYSQL_ROOT_PASSWORD=password -p 3308:3306 -d mysql:latest
 ```

2. connect to the image 

```bash
docker exec -it mysql bash
```
3. connect to mysql database and create the user and grant the privileges

```bash
 mysql -h 127.0.0.1 -P 3308 --protocol=tcp -u root -p  
 ```
```sql
CREATE USER 'appuser'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'appuser'@'%';
FLUSH PRIVILEGES;
 ```


4. schema

```sql
CREATE TABLE `Product` (
                           `id` varchar(36) PRIMARY KEY,
                           `name` varchar(255),
                           `description` varchar(255),
                           `price` integer,
                           `type` integer
);

CREATE TABLE `ProductType` (
                               `id` varchar(36) PRIMARY KEY,
                               `name` varchar(255)
);

CREATE TABLE `Ingredients` (
                               `id` varchar(36)  PRIMARY KEY,
                               `name` varchar(255),
                               `calories` integer
);

CREATE TABLE `IngredientsProducts` (
                                       `ingredientsId` varchar(36)  ,
                                       `productsId` varchar(36) ,
                                       `ingredientAmount` integer
);

ALTER TABLE `Product` ADD FOREIGN KEY (`type`) REFERENCES `ProductType` (`id`);

ALTER TABLE `IngredientsProducts` ADD FOREIGN KEY (`ingredientsId`) REFERENCES `Ingredients` (`id`);

ALTER TABLE `IngredientsProducts` ADD FOREIGN KEY (`productsId`) REFERENCES `Product` (`id`);

ALTER TABLE `IngredientsProducts` ADD PRIMARY KEY (`productsId`, `ingredientsId`);

```