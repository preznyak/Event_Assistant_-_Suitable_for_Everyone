DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities (
    email VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (email) REFERENCES users(email)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (email,authority);