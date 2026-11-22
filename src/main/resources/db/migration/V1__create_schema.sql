-- V1__crear_tablas_iniciales.sql

CREATE TABLE usuarios (
                          id VARCHAR(36) PRIMARY KEY,
                          p_nombre VARCHAR(255),
                          s_nombre VARCHAR(255),
                          p_apellido VARCHAR(255),
                          s_apellido VARCHAR(255),
                          fec_nac BIGINT,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255),
                          rol VARCHAR(50) NOT NULL,
                          foto_uri VARCHAR(1000)
);

CREATE TABLE organizaciones (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                nombre VARCHAR(255) NOT NULL,
                                tipo_organizacion VARCHAR(255),
                                rubro VARCHAR(255),
                                comuna VARCHAR(255),
                                region VARCHAR(255),
                                website VARCHAR(255),
                                audiencia_objetivo VARCHAR(255),
                                observacion TEXT
);

CREATE TABLE contactos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           organizacion_id BIGINT NOT NULL,
                           nombre VARCHAR(255) NOT NULL,
                           cargo VARCHAR(255),
                           area VARCHAR(255),
                           correo VARCHAR(255),
                           telefono VARCHAR(50),
                           medio_preferente VARCHAR(100),
                           estado VARCHAR(100),
                           fecha_ultimo_contacto VARCHAR(50),
                           observacion TEXT,
                           CONSTRAINT fk_contacto_organizacion FOREIGN KEY (organizacion_id)
                               REFERENCES organizaciones(id) ON DELETE CASCADE
);
CREATE INDEX idx_contactos_organizacion ON contactos(organizacion_id);

CREATE TABLE oportunidades (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               organizacion_id BIGINT,
                               nombre VARCHAR(255) NOT NULL,
                               tipo_oportunidad VARCHAR(255),
                               descripcion VARCHAR(500),
                               fuente_informacion VARCHAR(255),
                               fecha_deteccion VARCHAR(50),
                               responsable_interno VARCHAR(255),
                               prioridad VARCHAR(50),
                               potencial_estimado VARCHAR(100),
                               estado VARCHAR(100),
                               fecha_ultima_actualizacion VARCHAR(50),
                               observacion TEXT,
                               CONSTRAINT fk_oportunidad_organizacion FOREIGN KEY (organizacion_id)
                                   REFERENCES organizaciones(id) ON DELETE SET NULL
);
CREATE INDEX idx_oportunidades_organizacion ON oportunidades(organizacion_id);

CREATE TABLE seguimientos (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              oportunidad_id BIGINT NOT NULL,
                              contacto_id BIGINT,
                              usuario_email VARCHAR(255),
                              tipo_gestion VARCHAR(255),
                              propuesta TEXT,
                              respuesta_cliente TEXT,
                              proxima_accion VARCHAR(255),
                              fecha_gestion VARCHAR(50),
                              fecha_proxima_accion VARCHAR(50),
                              observacion TEXT,
                              CONSTRAINT fk_seguimiento_oportunidad FOREIGN KEY (oportunidad_id)
                                  REFERENCES oportunidades(id) ON DELETE CASCADE,
                              CONSTRAINT fk_seguimiento_contacto FOREIGN KEY (contacto_id)
                                  REFERENCES contactos(id) ON DELETE SET NULL
);
CREATE INDEX idx_seguimientos_oportunidad ON seguimientos(oportunidad_id);
CREATE INDEX idx_seguimientos_contacto ON seguimientos(contacto_id);

CREATE TABLE eventos (
                         id VARCHAR(36) PRIMARY KEY,
                         organizacion_id BIGINT,
                         titulo VARCHAR(255) NOT NULL,
                         tipo_evento VARCHAR(100),
                         fecha VARCHAR(50),
                         hora VARCHAR(20),
                         region VARCHAR(255),
                         comuna VARCHAR(255),
                         organizacion_nombre VARCHAR(255),
                         publico_esperado INT,
                         condiciones_participacion VARCHAR(500),
                         ruta_foto_evidencia VARCHAR(1000),
                         CONSTRAINT fk_evento_organizacion FOREIGN KEY (organizacion_id)
                             REFERENCES organizaciones(id) ON DELETE SET NULL
);
CREATE INDEX idx_eventos_organizacion ON eventos(organizacion_id);