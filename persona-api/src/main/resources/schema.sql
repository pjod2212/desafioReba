
-- public.pais definition

CREATE TABLE IF NOT EXISTS public.pais (
	id_pais bigserial NOT NULL,
	nombre varchar(255) NULL,
	CONSTRAINT pais_pkey PRIMARY KEY (id_pais)
);

-- public.tipo_documento definition

CREATE TABLE IF NOT EXISTS public.tipo_documento (
	id_tipo_documento bigserial NOT NULL,
	tipo_documento varchar(255) NULL,
	CONSTRAINT tipo_documento_pkey PRIMARY KEY (id_tipo_documento)
);


-- public.persona definition

CREATE TABLE IF NOT EXISTS public.persona (
	id_persona bigserial NOT NULL,
	apellido varchar(255) NULL,
	email varchar(255) NOT NULL,
	nombre varchar(255) NULL,
	nro_documento int4 NOT NULL,
	pais_id_pais int8 NOT NULL,
	tipo_documento_id_tipo_documento int8 NOT NULL,
	edad int4 NOT NULL,
	CONSTRAINT id_persona UNIQUE (nro_documento, pais_id_pais, tipo_documento_id_tipo_documento),
	CONSTRAINT persona_pkey PRIMARY KEY (id_persona),
	CONSTRAINT fkb7k496cqqbe9eiarp2i5xo5ri FOREIGN KEY (tipo_documento_id_tipo_documento) REFERENCES public.tipo_documento(id_tipo_documento),
	CONSTRAINT fklvt6m6n5co7vue219a1a4wuiq FOREIGN KEY (pais_id_pais) REFERENCES public.pais(id_pais)
);


CREATE TABLE IF NOT EXISTS public.relacion (
	id_relacion bigserial NOT NULL,
	tipo_relacion varchar(255) NULL,
	CONSTRAINT relacion_pkey PRIMARY KEY (id_relacion)
);