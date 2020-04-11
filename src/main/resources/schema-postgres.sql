DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities (
    email VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (email) REFERENCES users(email)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (email,authority);

DROP TABLE IF EXISTS additional_costs CASCADE;
CREATE TABLE additional_costs (
    additional_cost_id bigint NOT NULL,
    date date,
    description character varying(255),
    name character varying(255),
    price double precision,
    CONSTRAINT additional_costs_pkey PRIMARY KEY (additional_cost_id)
);

DROP TABLE IF EXISTS addresses CASCADE;
CREATE TABLE addresses (
    address_id bigint NOT NULL,
    city character varying(255),
    country character varying(255),
    house_number character varying(255),
    state character varying(255),
    street_name character varying(255),
    zip_code character varying(255),
    CONSTRAINT addresses_pkey PRIMARY KEY (address_id)
);

DROP TABLE IF EXISTS comments CASCADE;
CREATE TABLE comments (
    comment_id bigint NOT NULL,
    commenter character varying(255),
    date date,
    message character varying(255),
    CONSTRAINT comments_pkey PRIMARY KEY (comment_id)
);

DROP TABLE IF EXISTS contacts CASCADE;
CREATE TABLE contacts (
    contact_id bigint NOT NULL,
    email character varying(255),
    facebook_link character varying(255),
    name character varying(255),
    phone_number character varying(255),
    CONSTRAINT contacts_pkey PRIMARY KEY (contact_id)
);

DROP TABLE IF EXISTS event_details CASCADE;
CREATE TABLE event_details (
    event_details_id bigint NOT NULL,
    description character varying(255),
    end_time timestamp without time zone,
    start_time timestamp without time zone,
    CONSTRAINT event_details_pkey PRIMARY KEY (event_details_id)
);

DROP TABLE IF EXISTS service_details CASCADE;
CREATE TABLE service_details (
    id bigint NOT NULL,
    rating double precision,
    rating_number integer,
    CONSTRAINT service_details_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_details CASCADE;
CREATE TABLE user_details (
    user_details_id bigint NOT NULL,
    birth_day date,
    first_name character varying(255),
    last_name character varying(255),
    preferences character varying(255),
    registration_date date,
    contact_contact_id bigint,
    CONSTRAINT user_details_pkey PRIMARY KEY (user_details_id),
    CONSTRAINT fk_ud_contact_id FOREIGN KEY (contact_contact_id)
        REFERENCES contacts (contact_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS articles CASCADE;
CREATE TABLE articles (
    id bigint NOT NULL,
    content text,
    creation_time timestamp without time zone,
    title character varying(255),
    youtube_link character varying(255),
    user_user_id bigint,
    CONSTRAINT articles_pkey PRIMARY KEY (id),
    CONSTRAINT fk_a_user_id FOREIGN KEY (user_user_id)
        REFERENCES users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


DROP TABLE IF EXISTS guests CASCADE;
CREATE TABLE guests (
    guest_id bigint NOT NULL,
    first_name character varying(255),
    is_invitation_accepted boolean,
    last_name character varying(255),
    contact_contact_id bigint,
    CONSTRAINT guests_pkey PRIMARY KEY (guest_id),
    CONSTRAINT fk_g_contact_id FOREIGN KEY (contact_contact_id)
        REFERENCES contacts (contact_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
    user_id bigint NOT NULL,
    email character varying(255) NOT NULL,
    last_login_date date,
    password character varying(255),
    user_details_user_details_id bigint,
    service_owner boolean DEFAULT false,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT uk_email UNIQUE (email),
    CONSTRAINT fk_u_user_details_id FOREIGN KEY (user_details_user_details_id)
        REFERENCES user_details (user_details_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


DROP TABLE IF EXISTS services CASCADE;
CREATE TABLE services (
    service_id bigint NOT NULL,
    description character varying(255),
    home_page character varying(255),
    name character varying(255),
    service_category character varying(255),
    user_user_id bigint,
    service_details_id bigint,
    CONSTRAINT services_pkey PRIMARY KEY (service_id),
    CONSTRAINT fk_s_user_id FOREIGN KEY (user_user_id)
        REFERENCES users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_s_service_details_id FOREIGN KEY (service_details_id)
        REFERENCES service_details(id)  MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS contracts CASCADE;
CREATE TABLE contracts (
    contract_id bigint NOT NULL,
    deposit integer,
    deposit_payment_time timestamp without time zone,
    description character varying(255),
    is_deposit_payed boolean,
    is_price_payed boolean,
    payment_method character varying(255),
    price integer,
    price_payment_time timestamp without time zone,
    service_start_time timestamp without time zone,
    service_end_time timestamp without time zone,
    service_service_id bigint,
    event_event_id bigint,
    CONSTRAINT contracts_pkey PRIMARY KEY (contract_id),
    CONSTRAINT fk_c_service_service_id FOREIGN KEY (service_service_id)
        REFERENCES services(service_id)  MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_c_event_event_id FOREIGN KEY (event_event_id)
        REFERENCES events(event_id)  MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


DROP TABLE IF EXISTS user_details_address_list;
CREATE TABLE user_details_address_list
(
    user_details_user_details_id bigint NOT NULL,
    address_list_address_id bigint NOT NULL,
    CONSTRAINT uk_udal_address_id UNIQUE (address_list_address_id),
    CONSTRAINT fk_udal_address_id FOREIGN KEY (address_list_address_id)
        REFERENCES addresses (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_udal_user_details_id FOREIGN KEY (user_details_user_details_id)
        REFERENCES user_details (user_details_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


DROP TABLE IF EXISTS services_addresses CASCADE;
CREATE TABLE services_addresses (
    service_service_id bigint NOT NULL,
    addresses_address_id bigint NOT NULL,
    CONSTRAINT uk_sa_address_id UNIQUE (addresses_address_id),
    CONSTRAINT fk_sa_service_id FOREIGN KEY (service_service_id)
        REFERENCES services (service_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_sa_address_id FOREIGN KEY (addresses_address_id)
        REFERENCES addresses (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
-- ----------------------------------------------------------------


DROP TABLE IF EXISTS event_details_guest_list;
CREATE TABLE event_details_guest_list (
    event_details_event_details_id bigint NOT NULL,
    guest_list_guest_id bigint NOT NULL,
    CONSTRAINT uk_edgl_guest_id UNIQUE (guest_list_guest_id),
    CONSTRAINT fk_edgl_guest_id FOREIGN KEY (guest_list_guest_id)
        REFERENCES guests (guest_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_edgl_event_details_id FOREIGN KEY (event_details_event_details_id)
        REFERENCES event_details (event_details_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS events CASCADE;
CREATE TABLE events (
    event_id bigint NOT NULL,
    created timestamp without time zone,
    event_category character varying(255),
    event_name character varying(255),
    locality character varying(255),
    event_details_event_details_id bigint,
    user_user_id bigint,
    CONSTRAINT events_pkey PRIMARY KEY (event_id),
    CONSTRAINT fk_e_event_details_id FOREIGN KEY (event_details_event_details_id)
        REFERENCES event_details (event_details_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_e_user_id FOREIGN KEY (user_user_id)
        REFERENCES users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS events_additional_cost_list;
CREATE TABLE events_additional_cost_list (
    event_event_id bigint NOT NULL,
    additional_cost_list_additional_cost_id bigint NOT NULL,
    CONSTRAINT uk_eacl_additional_cost_id UNIQUE (additional_cost_list_additional_cost_id),
    CONSTRAINT fk_eacl_event_id FOREIGN KEY (event_event_id)
        REFERENCES events (event_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_eacl_additional_cost_id FOREIGN KEY (additional_cost_list_additional_cost_id)
        REFERENCES additional_costs (additional_cost_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS offers CASCADE;
CREATE TABLE offers (
    offer_id bigint NOT NULL,
    deposit integer,
    deposit_payment_time timestamp without time zone,
    description character varying(255),
    is_offer_accepted boolean,
    payment_method character varying(255),
    price integer,
    price_payment_time timestamp without time zone,
    event_event_id bigint,
    service_service_id bigint,
    CONSTRAINT offers_pkey PRIMARY KEY (offer_id),
    CONSTRAINT fk_o_service_id FOREIGN KEY (service_service_id)
        REFERENCES services (service_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_o_event_id FOREIGN KEY (event_event_id)
        REFERENCES events (event_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS service_details_comment_list;
CREATE TABLE service_details_comment_list
(
    service_details_id bigint NOT NULL,
    comment_list_comment_id bigint NOT NULL,
    CONSTRAINT uk_sdcl_comment_id UNIQUE (comment_list_comment_id),
    CONSTRAINT fk_sdcl_comment_id FOREIGN KEY (comment_list_comment_id)
        REFERENCES comments (comment_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_sdcl_service_details_id FOREIGN KEY (service_details_id)
        REFERENCES service_details (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS services_contacts;
CREATE TABLE services_contacts (
    service_service_id bigint NOT NULL,
    contacts_contact_id bigint NOT NULL,
    CONSTRAINT uk_sc_contact_id UNIQUE (contacts_contact_id),
    CONSTRAINT fk_sc_service_id FOREIGN KEY (service_service_id)
        REFERENCES services (service_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_sc_contact_id FOREIGN KEY (contacts_contact_id)
        REFERENCES contacts (contact_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);






