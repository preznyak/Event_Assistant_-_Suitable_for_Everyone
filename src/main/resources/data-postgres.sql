INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (1,'laszlopreznyak1111@gmail.com','facebook.com','Laszlo Preznyak','073044457');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (2,'kovaxarny9666@gmail.com','facebook.com','Arnold Szilveszter Kovacs','0452223397');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (3,'willsmith@gmail.com','facebook.com','William Smith','0731110027');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (4,'jeanclaudevandamme@gmail.com','facebook.com','Jean Claude Van Damme','075454633');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (5,'shrek@gmail.com','facebook.com','Shrek','0952224447');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (6,'shakira@gmail.com','facebook.com','Shakira','052233664488');
INSERT INTO public.contacts(contact_id, email, facebook_link, name, phone_number)
VALUES (7,'antoinegriezmann@gmail.com','facebook.com','Antoine Griezmann','0952224447');

INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (1,'1995-04-11','Preznyak','Laszlo','preferences','2020-03-08 11:00:00',1);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (2,'1996-12-04','Kovacs','Sylvester Stalone','preferences','2020-01-18 10:52:00',2);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (3,'1978-04-02','William','Smith','preferences','2020-01-08 11:10:01',3);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (4,'1961-06-09','Van Damme','Jean Claude','preferences','2020-03-08 11:23:00',4);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (5,'2000-02-10','Shrek','Shrek','preferences','2020-01-08 01:23:00',5);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (6,'1982-12-14','Shakira','Enekes','preferences','2020-03-04 09:45:00',6);
INSERT INTO public.user_details(user_details_id, birth_day, first_name, last_name, preferences, registration_date, contact_contact_id)
VALUES (7,'1987-08-11','Antoine','Griezmann','preferences','2020-01-01 07:25:00',7);

INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (1,'laszlopreznyak11@gmail.com','preznyak',1);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (2,'kovaxarny9666@gmail.com','almaecet',2);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (3,'willsmith@gmail.com','willike',3);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (4,'jeanclaudevandamme@gmail.com','claudevandamme2',4);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (5,'shrek@gmail.com','mocsar',5);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (6,'shakira@gmail.com','wakkawakkka',6);
INSERT INTO public.users(user_id, email, password, user_details_user_details_id)
VALUES (7,'antoinegriezmann@gmail.com','barcelonaormadrid',7);

INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (1, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (2, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (2, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (2, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (2, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);

INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (1, 'Debrecen', 'Hungary', '56', 'Hajdu-Bihar', 'Derek', '4031');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (2, 'Debrecen', 'Hungary', '18', 'Hajdu-Bihar', 'Mikszath Kalman', '4032');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (3, 'Debrecen', 'Hungary', '102', 'Hajdu-Bihar', 'Derek', '4031');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (4, 'Debrecen', 'Hungary', '1', 'Hajdu-Bihar', 'Vezer', '4034');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (5, 'Debrecen', 'Hungary', '16', 'Hajdu-Bihar', 'Csapo', '4035');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (6, 'Szekelyhod', 'Romania', '16', 'Bihor', '1 Mai', '700419');
INSERT INTO public.addresses(address_id, city, country, house_number, state, street_name, zip_code)
VALUES (7, 'Cherechiu', 'Romania', '256', 'Bihor', 'Main street', '701256');

INSERT INTO public.articles(id, content, creation_time, title, youtube_link, user_user_id)
VALUES (1, 'Egyszer a farkas elment a MediaMarktba. Nem lett jo vege.', '2020-02-13', 'Farkas a Lidlbe', 'link.com', 4);
INSERT INTO public.articles(id, content, creation_time, title, youtube_link, user_user_id)
VALUES (2, 'Hatalmas lakodalom volt Ujpesten, ahol a Vegas zenekar huzta a talpalavalot',
        '2020-01-16', 'Vegas Ujpesten', 'link.com', 2);
INSERT INTO public.articles(id, content, creation_time, title, youtube_link, user_user_id)
VALUES (3, ?, ?, ?, ?, ?);

