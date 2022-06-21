CREATE TABLE IF NOT EXISTS public.students
                (
                        id serial NOT NULL,
                        first_name character varying(45) NOT NULL,
                        last_name character varying(45) NOT NULL,
                        middle_name character varying(45) NOT NULL,
                        group_name character varying(45) NOT NULL,
                        age integer NOT NULL,
                        CONSTRAINT student_id_pkey PRIMARY KEY (id)
                )