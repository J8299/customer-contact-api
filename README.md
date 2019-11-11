# customer-contact-api
A spring boot application for demonstrating REST APIs

### Create A Database via Docker
 - Download [Docker](https://www.docker.com/products/docker-desktop)
 - Sign-up for a free account
 - Install & start Docker Desktop
 - From a Windows Machine
    - Open CMD via the start menu
    - Change directory using `cd` to this cloned repository 
    - Type this one command: 
        `docker-compose up`
  - From Linux Command Line or a MacOS Terminal
    - Change directory using `cd` to this cloned repository 
     - Type this one command: 
        `docker-compose up`
 
### Create A Database via Postgres Website
 - Download [Postgres](https://www.postgresql.org/download) version 10 for computers that can not run virtual machines
 - Install download version 10 Postgres
 - Open CMD via the start menu
 - Type these commands:
    `cd \Program Files\PostgreSQL\10\bin`
    `pg_ctl.exe start -D  "C:\Program Files\PostgreSQL\10\data"`

### Run the job using IntelliJ community
Run the main class with [IntelliJ](https://www.jetbrains.com/idea/download/)
 - Maven & Java8 come setup

### Run from the command line (much harder) - Windows
Install [maven](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/), 
install [java](https://java.com/en/download/help/download_options.xml)
 - Change directory using `cd` to this cloned repository 
 - Type these commands: 
    `cd src\main\java\com\company\customer\contactapi`
    `mvn clean run package spring-boot:run`
 
### The API starts on http://www.localhost.com:8080/contact-api

#### The endpoints are:

HTTP Method | Route | Description | Requires Body Payload
------------|-------|-------------|----------------------
GET | /contacts | Returns all customer contacts| No
POST | /contacts | Create a new contact | Yes
PUT | /contacts/{id} | Overwrite an existing contact | Yes
GET |/contacts/{id} | Get a unique customer contact by database id | No
DELETE | /contacts/{id} | Remove a contact by contact id | No

#### A viable JSON payload for a POST or PUT sample is below

```json
{
  "id": "100",
  "name": {
    "first": "Jon",
    "middle": "T",
    "last": "Jones"
  },
  "address": {
    "street": "103 Main Street",
    "city": "Richmond",
    "state": "Virginia",
    "zip": "23229"
    },
  "phone": [
    {
      "number": "804-555-5555",
      "type": "mobile"
    }, 
    {
      "number": "804-555-0000",
      "type": "work"
    }, 
    {
      "number": "804-555-5555",
      "type": "home"
    }
  ],
  "email": "noreply@email.com"
}
```
