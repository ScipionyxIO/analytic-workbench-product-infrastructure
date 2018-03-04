CREATE DATABASE mm_platmeta;
CREATE DATABASE mm_connect;
CREATE DATABASE mm_deals;
CREATE DATABASE mm_calcs;

CREATE ROLE mm_deals_user NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE ROLE mm_connect_user NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE ROLE mm_platmeta_user NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE ROLE mm_gateway_user NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE ROLE mm_calcs_user NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE ROLE platform NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;

ALTER USER mm_platmeta_user WITH encrypted password 'mm_platmeta_pass';
ALTER USER mm_gateway_user WITH encrypted password 'mm_gateway_pass';
ALTER USER mm_connect_user WITH encrypted password 'mm_connect_pass';
ALTER USER mm_deals_user WITH encrypted password 'mm_deals_pass';
ALTER USER mm_calcs_user WITH encrypted password 'mm_calcs_pass';
ALTER USER platform WITH encrypted password 'platform';

GRANT ALL PRIVILEGES ON DATABASE mm_platmeta TO mm_platmeta_user;
GRANT ALL PRIVILEGES ON DATABASE mm_platmeta TO mm_gateway_user;

GRANT ALL PRIVILEGES ON DATABASE mm_connect TO mm_connect_user;
GRANT ALL PRIVILEGES ON DATABASE mm_calcs TO mm_calcs_user;

GRANT ALL PRIVILEGES ON DATABASE mm_deals TO mm_deals_user;
GRANT ALL PRIVILEGES ON DATABASE mm_deals TO platform;

GRANT platform TO mm_deals_user;

CREATE GROUP mm_read_only;
CREATE GROUP mm_read_write;