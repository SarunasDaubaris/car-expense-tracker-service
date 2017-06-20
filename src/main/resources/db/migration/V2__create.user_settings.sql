CREATE TABLE IF NOT EXISTS USER_SETTINGS (
  user_setting_id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  setting_key VARCHAR (255) NOT NULL,
  setting_value VARCHAR (255) NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (user_id)
);