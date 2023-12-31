# java-jpa

# Docker
Install Docker with this site https://docs.docker.com/engine/install/ubuntu/

```
docker pull postgres
```

# PostgreSQL

```CREATE USER javajpa WITH PASSWORD 'javajpa';```
```CREATE DATABASE javajpa;```
```GRANT ALL PRIVILEGES ON DATABASE javajpa TO javajpa;```

# Create connection to schema
https://www.code4it.dev/blog/run-postgresql-with-docker/

```
docker run --name postgres -e POSTGRES_USER=javajpa -e POSTGRES_PASSWORD=javajpa -e POSTGRES_DB=javajpa -p 5455:5432 -d postgres
```
-p 5455:5432 is the port mapping. Postgres natively exposes the port 5432, and we have to map that port (that lives within Docker) to a local port. In this case, the local 5455 port maps to Docker’s 5432 port.