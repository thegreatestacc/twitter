--liquibase formatted sql

--changeset Morra:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;