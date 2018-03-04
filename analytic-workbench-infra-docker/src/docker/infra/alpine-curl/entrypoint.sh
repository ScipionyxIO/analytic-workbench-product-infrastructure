#!/bin/sh

echo Waiting for Postgres
/wait-for.sh ${COUCHDB}:${COUCHDB_PORT}
echo Postgres Available

echo Creating Database

curl -X PUT http://${COUCHDB}:${COUCHDB_PORT}/${DATABASE_NAME} 

echo PUT Design Document #1

curl -X PUT http://${COUCHDB}:${COUCHDB_PORT}/${DATABASE_NAME}/_design/contract --data-binary @schema_design_contract.json

echo PUT Design Document #2

curl -X PUT http://${COUCHDB}:${COUCHDB_PORT}/${DATABASE_NAME}/_design/alfresco --data-binary @schema_design_alfresco.json

echo PUT Design Document #3

curl -X PUT http://${COUCHDB}:${COUCHDB_PORT}/${DATABASE_NAME}/_design/contract_history --data-binary @schema_design_contract_history.json

echo PUT Design Document #4

curl -X PUT http://${COUCHDB}:${COUCHDB_PORT}/${DATABASE_NAME}/_design/customer --data-binary @schema_design_customer.json