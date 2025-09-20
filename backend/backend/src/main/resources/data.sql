INSERT INTO account_holder (id, name, description, created_at, updated_at)
VALUES
  (1, 'Laura', 'Cliente de prueba', NOW(), NOW()),
  (2, 'Jose', 'Administrador inicial', NOW(), NOW()),
  (3, 'Carlos', 'Otro ejemplo', NOW(), NOW());

INSERT INTO account_holder_tags (account_holder_id, tags)
VALUES
  (1, 'gym'),
  (1, 'mma'),
  (2, 'admin'),
  (3, 'test');
