CREATE TABLE IF NOT EXISTS TRANSACTIONS (
  transaction_id BIGSERIAL PRIMARY KEY,
  car_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  created_date TIMESTAMP DEFAULT NOW() NOT NULL,
  transaction_type SMALLINT NOT NULL,
  created_time VARCHAR (255),
  amount NUMERIC (25, 4) NOT NULL,
  description VARCHAR (255),
  FOREIGN KEY (car_id) REFERENCES cars (car_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);