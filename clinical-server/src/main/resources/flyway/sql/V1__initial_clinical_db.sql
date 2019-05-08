
CREATE TABLE submission (

    id BIGSERIAL PRIMARY KEY,
    program VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP

);

CREATE TABLE donor_staging (

   id BIGSERIAL PRIMARY KEY,
   submission_id BIGINT NOT NULL REFERENCES submission(id),
   program VARCHAR(255) NOT NULL,
   submitter_id VARCHAR(128) NOT NULL,
   gender VARCHAR(32),
   ethnicity VARCHAR(128),
   vital_status VARCHAR(32),
   cause_of_death VARCHAR(255),
   survival_time INT,
   last_update TIMESTAMP

);

CREATE TABLE donor (

    id BIGSERIAL PRIMARY KEY,
    program VARCHAR(255) NOT NULL,
    submitter_id VARCHAR(128) NOT NULL,
    gender VARCHAR(32),
    ethnicity VARCHAR(128),
    vital_status VARCHAR(32),
    cause_of_death VARCHAR(255),
    survival_time INTEGER

);
