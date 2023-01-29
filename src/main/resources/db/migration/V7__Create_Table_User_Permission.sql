CREATE TABLE user_permission (
  id_permission BIGINT NOT NULL,
  id_user BIGINT NOT NULL
);

ALTER TABLE user_permission ADD CONSTRAINT fk_useper_on_permission FOREIGN KEY (id_permission) REFERENCES permission (id);

ALTER TABLE user_permission ADD CONSTRAINT fk_useper_on_user FOREIGN KEY (id_user) REFERENCES users (id);