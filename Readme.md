1. create a databse name as tax and  the following tables in the database

-------------------------------------------
-- Table: public.tax_dept

-- DROP TABLE IF EXISTS public.tax_dept;

CREATE TABLE IF NOT EXISTS public.tax_dept
(
    dept_code character varying(15) COLLATE pg_catalog."default" NOT NULL,
    dept_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tax_dept_pkey PRIMARY KEY (dept_code),
    CONSTRAINT tax_dept_dept_name_key UNIQUE (dept_name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tax_dept
    OWNER to postgres;
	
	------------------------------------------------
	-- Table: public.tax_design

-- DROP TABLE IF EXISTS public.tax_design;

CREATE TABLE IF NOT EXISTS public.tax_design
(
    design_code character varying(15) COLLATE pg_catalog."default" NOT NULL,
    design_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tax_design_pkey PRIMARY KEY (design_code),
    CONSTRAINT tax_design_design_name_key UNIQUE (design_name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tax_design
    OWNER to postgres;
	
	
	--------------------------------------------------
	
	-- Table: public.tax_staff

-- DROP TABLE IF EXISTS public.tax_staff;

CREATE TABLE IF NOT EXISTS public.tax_staff
(
    id integer NOT NULL DEFAULT nextval('tax_staff_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    designation character varying(100) COLLATE pg_catalog."default" NOT NULL,
    department character varying(100) COLLATE pg_catalog."default" NOT NULL,
    basic_salary numeric(10,2) NOT NULL,
    parentuser character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tax_staff_pkey PRIMARY KEY (id),
    CONSTRAINT tax_staff_name_key UNIQUE (name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tax_staff
    OWNER to postgres;
	
	
	CREATE TABLE IF NOT EXISTS public.tax_users
(
    username character varying(25) COLLATE pg_catalog."default",
    password character varying(25) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tax_users
    OWNER to postgres;
	
	
	
	
	
	
	
	