--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: khs; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.khs (
    id_khs integer NOT NULL,
    nim_mhs character varying(15),
    kode_mk character varying(15),
    tahun_ajaran integer,
    nilai double precision,
    jumlahnilai double precision
);


--
-- Name: khs_id_khs_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.khs_id_khs_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: khs_id_khs_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.khs_id_khs_seq OWNED BY public.khs.id_khs;


--
-- Name: mahasiswa; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.mahasiswa (
    nim_mhs character varying(15) NOT NULL,
    prodi_mhs character varying(20),
    nama_mhs character varying(45),
    id_users bigint NOT NULL
);


--
-- Name: mahasiswa_id_users_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.mahasiswa_id_users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: mahasiswa_id_users_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.mahasiswa_id_users_seq OWNED BY public.mahasiswa.id_users;


--
-- Name: matakuliah; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.matakuliah (
    kode_mk character varying(15) NOT NULL,
    nama_mk character varying(100),
    sks_mk integer,
    smt_mk integer
);


--
-- Name: roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    created_on bigint,
    description character varying(255),
    modified_on bigint,
    name character varying(255)
);


--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: tahunajaran; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tahunajaran (
    tahun_ajaran integer NOT NULL,
    semester character varying
);


--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    username character varying(255)
);


--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: khs id_khs; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.khs ALTER COLUMN id_khs SET DEFAULT nextval('public.khs_id_khs_seq'::regclass);


--
-- Name: mahasiswa id_users; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mahasiswa ALTER COLUMN id_users SET DEFAULT nextval('public.mahasiswa_id_users_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: khs; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.khs (id_khs, nim_mhs, kode_mk, tahun_ajaran, nilai, jumlahnilai) FROM stdin;
-15	0110216035	IE11004	20191	4	12
-14	0110216035	NF12002	20191	4	12
\.


--
-- Data for Name: mahasiswa; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.mahasiswa (nim_mhs, prodi_mhs, nama_mhs, id_users) FROM stdin;
0110216035	Informatika	Mohammad Akmaluddin Novianto	15
\.


--
-- Data for Name: matakuliah; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.matakuliah (kode_mk, nama_mk, sks_mk, smt_mk) FROM stdin;
IE11004	Pengantar Open Source dan Aplikasi	3	1
NF12002	Pancasila dan Pendidikan Kewarganegaraan	3	2
NF21003	Statistik dan Probabilitas	3	2
NF21002	Metode Penelitian	2	3
NF11003	Bahasa Indonesia	2	1
NF11002	Matematika Dasar	2	1
IE11007	Matematika Diskrit	3	1
IE11006	Organisasi dan Arsitektur Komputer	3	1
IE11003	Pengantar Teknologi Informasi	2	1
NF12003	Bahasa Inggris	2	2
IE12001	Basis Data I	3	2
IE12004	Jaringan Komputer	3	2
NF21001	Pembentukan Karakter	2	2
SI31005	Audit Sistem Informasi	2	5
IE12005	Struktur Data dan Algoritma	3	2
IE12006	Administrasi Sistem	3	3
IE21003	Basis Data II	3	3
NF12001	Keterampilan Berpikir Kreatif	2	3
IE21005	Pemrograman Berorientasi Objek	3	3
IE21001	Pemrograman Web	3	3
IE21004	Tata Kelola Teknologi Informasi	3	3
TI22005	Analisis Numerik	3	4
IE22003	Data Warehouse	2	4
IE22001	Interaksi Manusia dan Komputer	2	4
TI22001	Pemrograman Sistem dan Jaringan	3	4
TI22003	Pemrograman Web Lanjutan	3	4
IE22002	Rekayasa Perangkat Lunak	3	4
NF32001	Technopreneurship & Kewirausahaan	3	4
TI034203	Teori Bahasa dan Otomata	2	4
TI31002	Big Data	3	6
IE32001	Cloud Computing	2	6
TI31003	Kecerdasan Buatan	3	5
NF31001	Keterampilan Kepemimpinan	2	5
NF22001	Keterampilan Komunikasi & Kerjasama	2	6
TI31001	Komputasi Paralel	3	5
IE31001	Manajemen Proyek	3	5
TI31004	Pemrograman Mobile	3	5
TI22006	Pemrograman Visual	3	5
TI32001	Pengolahan Citra	3	6
TI32003	Sistem Terdistribusi	3	6
NF41001	Etika Profesi	2	7
IE41001	Keamanan Sistem Informasi	2	7
TI40001	Kerja Praktek TI	3	7
NF40001	Tugas Akhir I	2	7
NF40002	Tugas Akhir II	4	8
TI31011	OOAD ( TPL )	3	5
TI32011	Pola Desain Perangkat Lunak (TPL)	3	6
TI41011	SQA (TPL)	2	7
TI32012	Tugas Proyek Perangkat Lunak (TPL)	3	6
TI31021	Administrasi Jaringan ( Infrastruktur TI)	3	5
TI41021	Keamanan Komputer dan Jaringan (Infrastruktur TI)	2	7
TI32022	Manajemen Infrastruktur IT (Infrastruktur TI)	3	6
TI32021	Tugas Proyek Infrastruktur (Infrastruktur TI)	3	6
TI40111	Grafika Komputer	3	0
IE12003	Sistem Operasi	2	2
SI41002	Change Management	2	7
TI41002	Enterprise Application Integration (Integrasi Sistem)	2	6
SI32004	IT Risk Management	2	6
SI40001	Kerja Praktek SI	3	7
SI32003	Knowledge management	2	6
SI31001	Manajemen Pemasaran Berbasis IT	2	5
SI22003	Manajemen Produksi & Riset Operasi	3	4
SI31006	Manajemen SDM Berbasis IT	3	5
SI22002	Pengantar Akuntansi	2	4
SI21001	Pengantar Bisnis	2	4
SI22004	Prinsip-Prinsip Manajemen	2	3
SI31004	Sistem Penunjang Keputusan	3	5
SI22001	Sistem Informasi Manajemen	3	4
SI32012	Penjaminan Mutu Sistem Informasi	3	6
SI41011	Proyek: IT Governance	3	7
SI32021	Supply Chain Management	3	6
SI32011	Audit Sistem Informasi Lanjutan	3	5
SI31021	Customer Relationship Management	3	5
SI31011	E-Government	3	5
SI32022	Perencangan Strategik SI	3	6
SI41021	Proyek enterprise SI	3	7
TI32002	Natural Language Processing (NLP)	3	0
TI40112	Pemrograman Game	3	0
TI40113	Pemrograman Framework	3	0
TI40114	Desain Analisis Algoritma	3	0
TI40121	Jaringan Nirkabel	3	0
TI40122	Routing & Switching	3	0
TI40123	IT Disaster Recovery Plan	3	0
TI40124	Teknologi Virtualisasi	3	0
TI40125	Ethical Hacking	2	0
TI40101	Web Security	2	0
TI40126	Cyber Law	2	0
TI40116	Semantic Web	2	0
TI40127	Digital Forensik	2	0
TI40128	Kriptografi	2	0
TI40117	Visualisasi Data	3	0
SI40101	Sistem Informasi Penilaian Kinerja	3	0
SI40102	Manajemen Aset	3	0
SI40111	Audit Sistem Informasi Berbasis Komputer	3	0
SI40112	IT Service Management	3	0
SI40113	IT DRP	3	0
SI40103	Cyber Law	2	0
SI40104	Prilaku Organisasi	2	0
SI31002	Sistem Informasi Akuntansi dan Keuangan	3	0
TI40115	Data Mining	2	0
SI40122	E-Business	3	0
SI32001	Enterprise Resource planning	3	0
NF11001	Pendidikan Agama	2	1
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.roles (id, created_on, description, modified_on, name) FROM stdin;
1	\N	Admin	\N	ADMIN
2	\N	User	\N	USER
\.


--
-- Data for Name: tahunajaran; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.tahunajaran (tahun_ajaran, semester) FROM stdin;
20191	Ganjil
\.


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.user_roles (user_id, role_id) FROM stdin;
6	1
15	2
16	2
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.users (id, email, first_name, last_name, password, username) FROM stdin;
6	admin@gmail.com	admin	admin	$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u	admin
15	akmalseferagic@gmail.com	Mohammad Akmaluddin	Novianto	$2a$10$Xqt7HcQlTKUAuVoM5D/aFuD4Af0WkuBz6dFz34Zps.ELh1sGRuZvW	0110216035
16	satriasuryan@gmail.com	Satria	Suryanegara	$2a$10$WFF9KU0rpv27b4yncyg9GOXmrO3JbaTEMooBVhMfMuXAcEQHjpxCa	0110216077
\.


--
-- Name: khs_id_khs_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.khs_id_khs_seq', 34, true);


--
-- Name: mahasiswa_id_users_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.mahasiswa_id_users_seq', 1, false);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.roles_id_seq', 2, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 16, true);


--
-- Name: khs ambilmk_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.khs
    ADD CONSTRAINT ambilmk_pkey PRIMARY KEY (id_khs);


--
-- Name: mahasiswa mahasiswa_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT mahasiswa_pkey PRIMARY KEY (nim_mhs);


--
-- Name: matakuliah matakuliah_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.matakuliah
    ADD CONSTRAINT matakuliah_pkey PRIMARY KEY (kode_mk);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: tahunajaran tahun_ajaran_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tahunajaran
    ADD CONSTRAINT tahun_ajaran_pkey PRIMARY KEY (tahun_ajaran);


--
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_roles fkh8ciramu9cc9q3qcqiv4ue8a6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: user_roles fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: mahasiswa id_users; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT id_users FOREIGN KEY (id_users) REFERENCES public.users(id);


--
-- Name: khs kode_mk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.khs
    ADD CONSTRAINT kode_mk FOREIGN KEY (kode_mk) REFERENCES public.matakuliah(kode_mk);


--
-- Name: khs nim_mhs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.khs
    ADD CONSTRAINT nim_mhs FOREIGN KEY (nim_mhs) REFERENCES public.mahasiswa(nim_mhs);


--
-- Name: khs tahun_ajaran; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.khs
    ADD CONSTRAINT tahun_ajaran FOREIGN KEY (tahun_ajaran) REFERENCES public.tahunajaran(tahun_ajaran);


--
-- PostgreSQL database dump complete
--

