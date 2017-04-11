-- departments
CREATE TABLE public.departments
(
    department_name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_department_name PRIMARY KEY (department_name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.departments
    OWNER to postgres;

-- employees
CREATE TABLE public.employees
(
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default" NOT NULL,
    birth_date date,
    salary double precision NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    department character varying COLLATE pg_catalog."default",
    CONSTRAINT pk_email PRIMARY KEY (email),
    CONSTRAINT fk_department FOREIGN KEY (department)
    REFERENCES public.departments (department_name) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE SET NULL
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employees
    OWNER to postgres;

CREATE INDEX fki_fk_department
ON public.employees USING btree
(department COLLATE pg_catalog."default")
TABLESPACE pg_default;