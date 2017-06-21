CREATE TABLE IF NOT EXISTS CARS (
  car_id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  fuel_type SMALLINT NOT NULL,
  licence_plate VARCHAR (255) NOT NULL,
  make VARCHAR (255) NOT NULL,
  model VARCHAR (255) NOT NULL,
  manufacture_year INTEGER,

  FOREIGN KEY (user_id) REFERENCES users (user_id)
);