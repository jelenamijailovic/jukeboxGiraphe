--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-10-19 12:36:51 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 16695)
-- Name: artist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.artist (
    id bigint NOT NULL,
    name character varying(255),
    genre_id integer
);


ALTER TABLE public.artist OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16665)
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


ALTER TABLE public.databasechangelog OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16660)
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE public.databasechangeloglock OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16759)
-- Name: edge; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.edge (
    id character varying(64) NOT NULL,
    edge_type character varying(64) NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    modified_at timestamp without time zone,
    from_node_id character varying(64) NOT NULL,
    to_node_id character varying(64) NOT NULL,
    properties jsonb NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.edge OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16690)
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genre (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.genre OWNER TO postgres;

--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 186
-- Name: TABLE genre; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.genre IS 'not an ignored comment';


--
-- TOC entry 183 (class 1259 OID 16671)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16673)
-- Name: jhi_persistent_audit_event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jhi_persistent_audit_event (
    event_id bigint NOT NULL,
    principal character varying(50) NOT NULL,
    event_date timestamp without time zone,
    event_type character varying(255)
);


ALTER TABLE public.jhi_persistent_audit_event OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16678)
-- Name: jhi_persistent_audit_evt_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jhi_persistent_audit_evt_data (
    event_id bigint NOT NULL,
    name character varying(150) NOT NULL,
    value character varying(255)
);


ALTER TABLE public.jhi_persistent_audit_evt_data OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16749)
-- Name: node; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.node (
    id character varying(64) NOT NULL,
    node_type character varying(64) NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    modified_at timestamp without time zone,
    properties jsonb NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.node OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16700)
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    id bigint NOT NULL,
    price integer
);


ALTER TABLE public.price OWNER TO postgres;

--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 188
-- Name: TABLE price; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.price IS 'Task entity. @author The JHipster team.';


--
-- TOC entry 189 (class 1259 OID 16705)
-- Name: song; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.song (
    id bigint NOT NULL,
    name character varying(255),
    artist_id integer
);


ALTER TABLE public.song OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16710)
-- Name: traffic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.traffic (
    id bigint NOT NULL,
    traffic_date character varying(255),
    jhi_user character varying(255),
    user_id character varying(255)
);


ALTER TABLE public.traffic OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 16695)
-- Dependencies: 187
-- Data for Name: artist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.artist (id, name, genre_id) FROM stdin;
\.


--
-- TOC entry 2207 (class 0 OID 16665)
-- Dependencies: 182
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
00000000000000	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.47639	1	EXECUTED	7:a6235f40597a13436aa36c6d61db2269	createSequence sequenceName=hibernate_sequence		\N	3.5.3	\N	\N	9943692460
00000000000001	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.528023	2	EXECUTED	7:6b7ef420f18500c8389a13a1826dea42	createTable tableName=jhi_persistent_audit_event; createTable tableName=jhi_persistent_audit_evt_data; addPrimaryKey tableName=jhi_persistent_audit_evt_data; createIndex indexName=idx_persistent_audit_event, tableName=jhi_persistent_audit_event; c...		\N	3.5.3	\N	\N	9943692460
20181002085804-1	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.542671	3	EXECUTED	7:7e4ac4d71534d57d15cca6f36809bc2f	createTable tableName=genre		\N	3.5.3	\N	\N	9943692460
20181002085803-1	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.556031	4	EXECUTED	7:dd1240aa2793fb89f0f3ea2a85895d1b	createTable tableName=artist		\N	3.5.3	\N	\N	9943692460
20181002085806-1	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.569623	5	EXECUTED	7:2414f1363bcfad74396c28d0cb31afd4	createTable tableName=price		\N	3.5.3	\N	\N	9943692460
20181002085802-1	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.581905	6	EXECUTED	7:f7120125656bf2bee23e04c01369bf49	createTable tableName=song		\N	3.5.3	\N	\N	9943692460
20181002085805-1	jhipster	classpath:changeLogs/changeLog-master.xml	2018-10-19 12:08:12.604535	7	EXECUTED	7:3c1abfa891e929783c33f82e970fa046	createTable tableName=traffic		\N	3.5.3	\N	\N	9943692460
\.


--
-- TOC entry 2206 (class 0 OID 16660)
-- Dependencies: 181
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
1	f	\N	\N
\.


--
-- TOC entry 2217 (class 0 OID 16759)
-- Dependencies: 192
-- Data for Name: edge; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.edge (id, edge_type, created_at, modified_at, from_node_id, to_node_id, properties, deleted) FROM stdin;
\.


--
-- TOC entry 2211 (class 0 OID 16690)
-- Dependencies: 186
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genre (id, name) FROM stdin;
\.


--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 183
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1000, false);


--
-- TOC entry 2209 (class 0 OID 16673)
-- Dependencies: 184
-- Data for Name: jhi_persistent_audit_event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jhi_persistent_audit_event (event_id, principal, event_date, event_type) FROM stdin;
\.


--
-- TOC entry 2210 (class 0 OID 16678)
-- Dependencies: 185
-- Data for Name: jhi_persistent_audit_evt_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jhi_persistent_audit_evt_data (event_id, name, value) FROM stdin;
\.


--
-- TOC entry 2216 (class 0 OID 16749)
-- Dependencies: 191
-- Data for Name: node; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.node (id, node_type, created_at, modified_at, properties, deleted) FROM stdin;
\.


--
-- TOC entry 2213 (class 0 OID 16700)
-- Dependencies: 188
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.price (id, price) FROM stdin;
\.


--
-- TOC entry 2214 (class 0 OID 16705)
-- Dependencies: 189
-- Data for Name: song; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.song (id, name, artist_id) FROM stdin;
\.


--
-- TOC entry 2215 (class 0 OID 16710)
-- Dependencies: 190
-- Data for Name: traffic; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.traffic (id, traffic_date, jhi_user, user_id) FROM stdin;
\.


--
-- TOC entry 2088 (class 2606 OID 16768)
-- Name: edge_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.edge
    ADD CONSTRAINT edge_pkey PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 16682)
-- Name: jhi_persistent_audit_evt_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jhi_persistent_audit_evt_data
    ADD CONSTRAINT jhi_persistent_audit_evt_data_pkey PRIMARY KEY (event_id, name);


--
-- TOC entry 2086 (class 2606 OID 16758)
-- Name: node_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.node
    ADD CONSTRAINT node_pkey PRIMARY KEY (id);


--
-- TOC entry 2078 (class 2606 OID 16699)
-- Name: pk_artist; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artist
    ADD CONSTRAINT pk_artist PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 16664)
-- Name: pk_databasechangeloglock; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT pk_databasechangeloglock PRIMARY KEY (id);


--
-- TOC entry 2076 (class 2606 OID 16694)
-- Name: pk_genre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genre
    ADD CONSTRAINT pk_genre PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 16677)
-- Name: pk_jhi_persistent_audit_event; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jhi_persistent_audit_event
    ADD CONSTRAINT pk_jhi_persistent_audit_event PRIMARY KEY (event_id);


--
-- TOC entry 2080 (class 2606 OID 16704)
-- Name: pk_price; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT pk_price PRIMARY KEY (id);


--
-- TOC entry 2082 (class 2606 OID 16709)
-- Name: pk_song; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.song
    ADD CONSTRAINT pk_song PRIMARY KEY (id);


--
-- TOC entry 2084 (class 2606 OID 16717)
-- Name: pk_traffic; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traffic
    ADD CONSTRAINT pk_traffic PRIMARY KEY (id);


--
-- TOC entry 2069 (class 1259 OID 16683)
-- Name: idx_persistent_audit_event; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_persistent_audit_event ON public.jhi_persistent_audit_event USING btree (principal, event_date);


--
-- TOC entry 2072 (class 1259 OID 16684)
-- Name: idx_persistent_audit_evt_data; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_persistent_audit_evt_data ON public.jhi_persistent_audit_evt_data USING btree (event_id);


--
-- TOC entry 2090 (class 2606 OID 16769)
-- Name: edge_from_node_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.edge
    ADD CONSTRAINT edge_from_node_id_fkey FOREIGN KEY (from_node_id) REFERENCES public.node(id);


--
-- TOC entry 2091 (class 2606 OID 16774)
-- Name: edge_to_node_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.edge
    ADD CONSTRAINT edge_to_node_id_fkey FOREIGN KEY (to_node_id) REFERENCES public.node(id);


--
-- TOC entry 2089 (class 2606 OID 16685)
-- Name: fk_evt_pers_audit_evt_data; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jhi_persistent_audit_evt_data
    ADD CONSTRAINT fk_evt_pers_audit_evt_data FOREIGN KEY (event_id) REFERENCES public.jhi_persistent_audit_event(event_id);


--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-10-19 12:36:51 CEST

--
-- PostgreSQL database dump complete
--

