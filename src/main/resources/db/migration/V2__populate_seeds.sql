-- V2__datos_iniciales.sql

-- 1. Cuentas de usuario iniciales (Contraseña para todas: Clave123+)
INSERT INTO usuarios (id, p_nombre, s_nombre, p_apellido, s_apellido, fec_nac, email, password, rol, foto_uri)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Admin', NULL, 'Sistema', NULL, NULL, 'admin@empresa.cl', '1f992a6f1f146cd7c23bf95b43180c5ebf8a970ce3bfeddbcbc8bd5a826a04fa', 'ADMIN', NULL),
    ('22222222-2222-2222-2222-222222222222', 'Carlos', NULL, 'Mendoza', NULL, NULL, 'supervisor@empresa.cl', '1f992a6f1f146cd7c23bf95b43180c5ebf8a970ce3bfeddbcbc8bd5a826a04fa', 'SUPERVISOR', NULL),
    ('33333333-3333-3333-3333-333333333333', 'Ana', NULL, 'López', NULL, NULL, 'ejecutivo1@empresa.cl', '1f992a6f1f146cd7c23bf95b43180c5ebf8a970ce3bfeddbcbc8bd5a826a04fa', 'EJECUTIVO', NULL),
    ('44444444-4444-4444-4444-444444444444', 'Mateo', NULL, 'Silva', NULL, NULL, 'ejecutivo2@empresa.cl', '1f992a6f1f146cd7c23bf95b43180c5ebf8a970ce3bfeddbcbc8bd5a826a04fa', 'EJECUTIVO', NULL),
    ('55555555-5555-5555-5555-555555555555', 'Sofía', NULL, 'Rojas', NULL, NULL, 'ejecutivo3@empresa.cl', '1f992a6f1f146cd7c23bf95b43180c5ebf8a970ce3bfeddbcbc8bd5a826a04fa', 'EJECUTIVO', NULL);

-- 2. Organizaciones iniciales (Garantizan integridad referencial con id = 1, 2, 3)
INSERT INTO organizaciones (id, nombre, tipo_organizacion, rubro, comuna, region, website, audiencia_objetivo, observacion)
VALUES
    (1, 'Gobierno Regional Metropolitano', 'Institución Pública', 'Administración Pública', 'Santiago', 'Región Metropolitana', 'https://www.gobiernosantiago.cl', 'Ciudadanía y empresas regionales', 'Organización base por defecto para contactos y eventos.'),
    (2, 'Cámara de Comercio Valparaíso', 'Gremio Empresarial', 'Comercio y Servicios', 'Viña del Mar', 'Valparaíso', 'https://www.ccvalparaiso.cl', 'Pymes y ejecutivos comerciales', 'Aliado estratégico para ferias y seminarios.'),
    (3, 'Universidad del Biobío', 'Institución Educativa', 'Educación Superior', 'Concepción', 'Biobío', 'https://www.ubiobio.cl', 'Estudiantes, académicos y empresas tecnológicas', 'Sede habitual de conferencias regionales.');

-- 3. Oportunidades iniciales
INSERT INTO oportunidades (id, organizacion_id, nombre, tipo_oportunidad, descripcion, fuente_informacion, fecha_deteccion, responsable_interno, prioridad, potencial_estimado, estado, fecha_ultima_actualizacion, observacion)
VALUES
    (1, 1, 'Licencia CRM Corporativo 2026', 'Licitación Pública', 'Implementación de licencias CRM y módulo móvil para el equipo comercial de zona central.', 'Mercado Público', '2026-10-01', 'Ana López', 'Alta', 'Alto', 'Contacto realizado', '2026-10-15', 'Cliente solicitó reunión técnica para revisar términos de soporte.'),
    (2, 2, 'Renovación Equipos de Cómputo', 'Venta Directa', 'Renovación de 50 laptops corporativas para gerencia y áreas operativas.', 'Contacto Directo', '2026-10-05', 'Mateo Silva', 'Media', 'Medio', 'Propuesta enviada', '2026-10-18', 'Propuesta comercial enviada a departamento de finanzas.'),
    (3, 3, 'Auditoría e Infraestructura Cloud', 'Consultoría', 'Evaluación de seguridad y optimización de costos en infraestructura AWS/Azure.', 'Recomendación', '2026-10-10', 'Sofía Rojas', 'Baja', 'Bajo', 'Evento identificado', '2026-10-10', 'Pendiente coordinar reunión exploratoria con el cliente.');

-- 4. Eventos iniciales
INSERT INTO eventos (id, organizacion_id, titulo, tipo_evento, fecha, hora, region, comuna, organizacion_nombre, publico_esperado, condiciones_participacion, ruta_foto_evidencia)
VALUES
    ('aaaa1111-1111-1111-1111-111111111111', 1, 'Feria Tecnológica e Innovación Regional', 'Feria', '2026-11-15', '09:00', 'Región Metropolitana', 'Santiago', 'Gobierno Regional Metropolitano', 500, 'Entrada liberada previo registro en el portal corporativo.', NULL),
    ('bbbb2222-2222-2222-2222-222222222222', 2, 'Seminario de Transformación Digital CRM', 'Seminario', '2026-11-20', '14:30', 'Valparaíso', 'Viña del Mar', 'Cámara de Comercio Valparaíso', 120, 'Exclusivo para ejecutivos y supervisores de área.', NULL),
    ('cccc3333-3333-3333-3333-333333333333', 3, 'Conferencia Anual de Ciberseguridad', 'Conferencia', '2026-12-05', '10:00', 'Biobío', 'Concepción', 'Universidad del Biobío', 300, 'Presentación de credencial institucional al ingreso.', NULL);