CREATE TABLE IF NOT EXISTS USERS (
  user_id BIGSERIAL PRIMARY KEY,
  username VARCHAR (255) NOT NULL,
  password VARCHAR (255) NOT NULL,
  created_date TIMESTAMP DEFAULT NOW() NOT NULL,
  user_state SMALLINT NOT NULL,
  user_type SMALLINT NOT NULL,
  CONSTRAINT uq_username UNIQUE (username)
);