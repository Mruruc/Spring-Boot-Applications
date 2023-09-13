CREATE TABLE content (
                         id SERIAL PRIMARY KEY,
                         title varchar(250) NOT NULL,
                         description text,
                         status varchar(20) NOT NULL,
                         content_type varchar(20) NOT NULL,
                         date_created TIMESTAMP NOT NULL,
                         date_updated TIMESTAMP,
                         url varchar(250)
);

SELECT * FROM content;