PGDMP     "                    z         	   patientdb    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16395 	   patientdb    DATABASE     m   CREATE DATABASE patientdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE patientdb;
                postgres    false            �            1259    16420    patient    TABLE     .  CREATE TABLE public.patient (
    patient_id character varying(255) NOT NULL,
    age character varying(255),
    disease character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    marital_status character varying(255),
    state character varying(255)
);
    DROP TABLE public.patient;
       public         heap    postgres    false            �          0    16420    patient 
   TABLE DATA           i   COPY public.patient (patient_id, age, disease, first_name, last_name, marital_status, state) FROM stdin;
    public          postgres    false    200   )       "           2606    16427    patient patient_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (patient_id);
 >   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_pkey;
       public            postgres    false    200            �   �   x�m�;�0D��)� (RPr��f���dǉ�=�d!!��4�f�xm����!�^%�'֙&x� rA�$��e�b,HG�@�8\)�T"�)j�,��=oU���@�e���^�%6�x���ϼ�,�*3�0+ǵ���\�6R<T7�$�Ł�d5�R�����AoQ�     