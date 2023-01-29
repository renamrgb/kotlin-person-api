#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE DATABASE kotlin;
	CREATE USER docker WITH PASSWORD 'docker';
	GRANT ALL ON DATABASE kotlin TO docker;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "kotlin" <<-EOSQL
  grant usage on schema public to docker;
  grant all privileges on schema public to docker;
EOSQL