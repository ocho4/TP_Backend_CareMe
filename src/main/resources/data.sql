-- 1. TIPOS DE USUARIO
INSERT INTO tipos_usuario (id_tipo, nombre_tipo, descripcion)
VALUES (1, 'Familiar', 'Usuario que busca cuidados para un paciente'),
       (2, 'Cuidador', 'Profesional que brinda servicios de salud'),
       (3, 'Administrador', 'Personal de gestión de CareMe')
    ON CONFLICT (id_tipo) DO NOTHING;

-- 2. USUARIOS (Password '123456' en BCrypt)
-- Nota: Usamos el ID manual para asegurar la vinculación en el script
INSERT INTO usuarios (id_usuario, id_tipo, email, password_hash, nombres, apellidos, rol, proveedor_auth)
VALUES (1, 3, 'matias.admin@careme.com', '$2a$10$8.UnVuG9HHgffUDAlk8q6OuVGkqCYAdVqKcl9/fGNq6J6vK.iX4Z6', 'Matías', 'Sistemas', 'admin', 'local'),
       (2, 1, 'familiar.test@email.com', '$2a$10$8.UnVuG9HHgffUDAlk8q6OuVGkqCYAdVqKcl9/fGNq6J6vK.iX4Z6', 'Juan', 'Pérez', 'familiar', 'local'),
       (3, 2, 'cuidador.test@email.com', '$2a$10$8.UnVuG9HHgffUDAlk8q6OuVGkqCYAdVqKcl9/fGNq6J6vK.iX4Z6', 'Elena', 'Rodríguez', 'cuidador', 'local')
    ON CONFLICT (id_usuario) DO NOTHING;

-- 3. PERFILES ESPECÍFICOS
INSERT INTO familiares (id_familiar, id_usuario, direccion, distrito)
VALUES (1, 2, 'Av. Primavera 123', 'Surco')
    ON CONFLICT (id_familiar) DO NOTHING;

INSERT INTO cuidadores (id_cuidador, id_usuario, especialidad, tarifa_base, activo, observado)
VALUES (1, 3, 'Geriatría y Post-operatorio', 45.0, true, false)
    ON CONFLICT (id_cuidador) DO NOTHING;

-- 4. CONDICIONES MÉDICAS
INSERT INTO condiciones_medicas (id_condicion, nombre_condicion)
VALUES (1, 'Alzheimer'), (2, 'Diabetes Tipo 2'), (3, 'Hipertensión')
    ON CONFLICT (id_condicion) DO NOTHING;