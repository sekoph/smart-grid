# Spring Boot Backend Application

## Prerequisites
Ensure you have the following installed:

- **Java 17+** (Check version using `java -version`)
- **Maven** (Check version using `mvn -version`)
- **Apache Kafka** (for message streaming)

## Setup 

### 1. Clone the Repository
```sh
git clone git@github.com:sekoph/smart-grid.git
```
## setup backend
```sh
cd smart-grid

```
### 2. Configure Environment Variables
Create an `.env` file or configure `application.properties` / `application.yml` as needed:


### 3. Install Dependencies
```sh
mvn clean install
```

### 4. Run the Application
```sh
mvn spring-boot:run
```

The server should start at `http://localhost:8080`



## Running Kafka Locally (Optional)

Or manually:
```sh
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```
## setup frontend
```sh
cd client
```
# Install dependencies
npm install  # or yarn install


```env
REACT_APP_API_URL=http://localhost:8000
```

## Running the Project
To start the development server:

```sh
npm run dev  # or yarn dev
```

## License
[MIT](LICENSE)

