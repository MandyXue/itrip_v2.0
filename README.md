# itrip-refactor
refactor using springmvc+jpa

## Introduction
* Nowadays, modern people place too much emphasis on their work, so when going on a trip, they prefer to relax rather than go to some famous and crowded places. But the existing tourism information systems focus more on the booking system, the ticket fees or the touring plan of famous tourist resorts. So we want to develop a tourism information system, which tends to recommend other alternative beautiful places of interest to our users.

* Our project is named as ‘i-Trip’, offering two user status, registered user and unregistered user.  We provide functions including target area choosing, picture exhibition and uploading, food exhibition and uploading, thumbs-up and other preference choice. What’s more, for registered users, we make sure that they can check their personal preference of tourism and upload their pictures of specified tourism.

## Implemented Functions
### Part I: Database Management
To successfully support our project, we design our database as the E-R diagram showing. Two relationship sets named user-trip and user-food and a single entity named upload, responsible for different functions.

#### 1.	Entity Sets for itrip database:
*	The spot entity,with attributes spots_name,spots_cn_name, province, description, thumb-package, thumb-couple, thumb-family.
*	The user entity, with attributes username, password, email.
*	The food entity, with attributes food_name, food_n_name, province, description.
*	The upload entity, with attributes pvalid, dvalid, description, pictures, spotted, username.

#### 2.	Relationship Sets for itrip database:
*	User-trip,a many to many relationship set between spot and user

User-trip relationship set consists of two entity named spot and user. Spot stores the information  about the spot detail information including several aspects shown in the picture. User contains 3 attributes mainly being invoked when login validation and register. User and spot are many to many connection when user login or register.

*	User-food, a many to many relationship set between food and user
User-food relationship set consists of two entity as well and we define them as food and user(user entity is included in two relationship sets). Food stores the information about the food detail information including 4 aspects as attributes and to be connected with user with many to many restraints when login and register. 

* Also, to make our functions more easy-available. We  provide a single entity upload to help allow the users to upload their individual pictures and  description of a spot so that more interaction are among the users.

### Part II: Framework and basic pages

unfinished.....
