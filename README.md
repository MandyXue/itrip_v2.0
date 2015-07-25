# itrip-refactor
refactor using springmvc+jpa

## Introduction
* Nowadays, modern people place too much emphasis on their work, so when going on a trip, they prefer to relax rather than go to some famous and crowded places. But the existing tourism information systems focus more on the booking system, the ticket fees or the touring plan of famous tourist resorts. So we want to develop a tourism information system, which tends to recommend other alternative beautiful places of interest to our users.

* Our project is named as ‘i-Trip’, offering two user status, registered user and unregistered user.  We provide functions including target area choosing, picture exhibition and uploading, food exhibition and uploading, thumbs-up and other preference choice. What’s more, for registered users, we make sure that they can check their personal preference of tourism and upload their pictures of specified tourism.

## Configurations and Deployments
### 1. Add the six tables from the sql files to a new schema called itrip
In this part we use local mysql workbench to configure our database.

### 2. Clone this project to your file and wait for the dependencies to generate(better use vpn). After that, link the database to our itrip database:
* Open the database tab-bar
* Press the add button
* Choose 'Data Source -> MySQL'
* Host: 
```
localhost
```
* Port:
```
3306
```
* Database:
```
itrip
```(the same as your database name)
* Url:
```
jdbc:mysql://localhost:3306/itrip
```(This is usually generated automatically)
* User and Password is just as your database

### 3. Generate the java persistence unit from the tool buttons on the left. 
* Use the default name of entities is enough.
* Just choose all the tables from mysql database.

### 4. Make sure to configure the persistense.xml correnctly:
* First, add ```?characterEncoding=utf-8``` to your database as follows:
```
<property name="eclipselink.jdbc.url" value="jdbc:mysql://localhost:3306/itrip?characterEncoding=utf-8"/>
```

* Second, configure your database, for example:
```
<property name="eclipselink.jdbc.user" value="root"/>
```
```
<property name="eclipselink.jdbc.password" value="password"/>
```

### 5. Add three constructors of UploadEntity, UserFoodEntity and UserSpotEntity:
```Java
public UploadEntity(String username,  String spotfood, String pictures, String description) {
	this.username = username;
	this.dvalid = 0;
	this.spotfood = spotfood;
	this.pictures = pictures;
	this.pvalid = 0;
	this.description = description;
}

public UploadEntity() {
}
```
```
public UserFoodEntity(String username, String foodname, Date date) {
    this.username = username;
    this.foodname = foodname;
    this.date = date;
}

public UserFoodEntity() {
}
```
```Java
public UserSpotEntity(String username, String spotname, Date date, String type) {
	this.username = username;
	this.spotname = spotname;
	this.date = date;
	this.type = type;
}
public UserSpotEntity() {
}
```