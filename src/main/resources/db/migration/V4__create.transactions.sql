CREATE TABLE IF NOT EXISTS TRANSACTIONS (
  transaction_id BIGSERIAL PRIMARY KEY,
  car_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  transaction_type SMALLINT NOT NULL,
  created_time VARCHAR (255),
  last_update_time VARCHAR (255),
  amount NUMERIC (25, 4) NOT NULL,
  description VARCHAR (255),

  FOREIGN KEY (car_id) REFERENCES cars (car_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);