--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Ubuntu 17.2-1.pgdg22.04+1)
-- Dumped by pg_dump version 17.2 (Ubuntu 17.2-1.pgdg22.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- Name: emprunts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprunts (
    idemprunt integer NOT NULL,
    membreid integer,
    livreid integer,
    dateemprunt date NOT NULL,
    dateretourprevue date NOT NULL,
    dateretoureffective date
);


ALTER TABLE public.emprunts OWNER TO postgres;

--
-- Name: emprunts_idemprunt_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprunts_idemprunt_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.emprunts_idemprunt_seq OWNER TO postgres;

--
-- Name: emprunts_idemprunt_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprunts_idemprunt_seq OWNED BY public.emprunts.idemprunt;


--
-- Name: livres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livres (
    id integer NOT NULL,
    titre character varying(255) NOT NULL,
    auteur character varying(255) NOT NULL,
    nationaliteauteur character varying(100),
    categorie character varying(100),
    isbn character varying(20),
    dateparution date,
    nombreexemplaires integer NOT NULL
);


ALTER TABLE public.livres OWNER TO postgres;

--
-- Name: livres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livres_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.livres_id_seq OWNER TO postgres;

--
-- Name: livres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livres_id_seq OWNED BY public.livres.id;


--
-- Name: membres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membres (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    prenom character varying(100) NOT NULL,
    email character varying(255) NOT NULL,
    telephone character varying(15),
    adhesiondate date NOT NULL
);


ALTER TABLE public.membres OWNER TO postgres;

--
-- Name: membres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membres_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.membres_id_seq OWNER TO postgres;

--
-- Name: membres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membres_id_seq OWNED BY public.membres.id;


--
-- Name: emprunts idemprunt; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts ALTER COLUMN idemprunt SET DEFAULT nextval('public.emprunts_idemprunt_seq'::regclass);


--
-- Name: livres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livres ALTER COLUMN id SET DEFAULT nextval('public.livres_id_seq'::regclass);


--
-- Name: membres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membres ALTER COLUMN id SET DEFAULT nextval('public.membres_id_seq'::regclass);


--
-- Data for Name: emprunts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.emprunts (idemprunt, membreid, livreid, dateemprunt, dateretourprevue, dateretoureffective) FROM stdin;
1	4	1	2025-01-15	2025-02-15	\N
2	2	5	2025-01-16	2025-02-16	\N
3	8	9	2025-01-13	2025-02-13	\N
\.


--
-- Data for Name: livres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.livres (id, titre, auteur, nationaliteauteur, categorie, isbn, dateparution, nombreexemplaires) FROM stdin;
1	The Adventures of Tintin	Hergé	Belge	BD	9781234567821	1929-01-10	30
2	kira Vol. 1	Katsuhiro Otomo	Japonaise	Manga	9781234567835	1982-12-20	18
3	Critique of Pure Reason	Emmanuel Kant	Allemande	Philosophie	9781234567809	1781-01-01	5
4	Head First Java	Kathy Sierra	Américaine	Informatique	9781234567825	2005-02-09	10
5	The Origin of Species	Charles Darwin	Anglaise	Scientifique	1859-11-24	1859-11-24	8
6	Méditations Métaphysiques	René Descartes	Française	Philosophie	9781234567899	1641-08-28	9
7	Crime and Punishment	Fyodor Dostoevsky	Russe	Littérature	9781234567808	1866-01-01	6
8	The Art of Computer Programming	Donald Knuth	Américaine	Informatique	968-01-01	1968-01-01	6
9	Design Patterns	Erich Gamma	Allemande	Informatique	9781234567818	1994-10-21	11
10	Democracy in America	Alexis de Tocqueville	Française	Politique	9781234567829	1835-01-01	4
11	Python Crash Course	Eric Matthes	Américaine	Informatique	9781234567803	2015-11-01	18
12	Sapiens: A Brief History of Humankind	Yuval Noah Harari	Israélienne	Scientifique	9781234567896	2014-02-10	8
13	Artificial Intelligence: A Modern Approach	Stuart Russell	Américaine	Informatique	9781234567836	1995-01-01	15
\.


--
-- Data for Name: membres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.membres (id, nom, prenom, email, telephone, adhesiondate) FROM stdin;
1	FOX	Thierry	fox@gmail.com	699990521	2025-01-14
2	Ngaleu	Mike	nmike@gmail.com	655786214	2025-01-09
3	Bobda	Warren	warrano@yahoo.fr	632589214	2025-01-13
4	Fossoh	Doriane	fdoriane@yahoo.fr	682125800	2025-01-12
5	Mogou	Richard	mrichard@gmail.com	622001548	2015-01-15
6	Kamgaing	Romaric	kromaric@gmail.com	623059845	2025-01-10
7	Leale	Ashley	ashleyl@gmail.com	652021235	2025-01-14
8	Mbekou	Sandra	sandra@yahoo.fr	650002530	2025-01-05
9	Kombou	Virginie	kvirginie@gmail.com	693210548	2025-01-15
\.


--
-- Name: emprunts_idemprunt_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprunts_idemprunt_seq', 3, true);


--
-- Name: livres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livres_id_seq', 13, true);


--
-- Name: membres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membres_id_seq', 9, true);


--
-- Name: emprunts emprunts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts
    ADD CONSTRAINT emprunts_pkey PRIMARY KEY (idemprunt);


--
-- Name: livres livres_isbn_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livres
    ADD CONSTRAINT livres_isbn_key UNIQUE (isbn);


--
-- Name: livres livres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livres
    ADD CONSTRAINT livres_pkey PRIMARY KEY (id);


--
-- Name: membres membres_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membres
    ADD CONSTRAINT membres_email_key UNIQUE (email);


--
-- Name: membres membres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membres
    ADD CONSTRAINT membres_pkey PRIMARY KEY (id);


--
-- Name: emprunts emprunts_livreid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts
    ADD CONSTRAINT emprunts_livreid_fkey FOREIGN KEY (livreid) REFERENCES public.livres(id);


--
-- Name: emprunts emprunts_membreid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts
    ADD CONSTRAINT emprunts_membreid_fkey FOREIGN KEY (membreid) REFERENCES public.membres(id);


--
-- PostgreSQL database dump complete
--

