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
VALUES (3, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (4, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);
INSERT INTO public.additional_costs(additional_cost_id, date, description, name, price)
VALUES (5, '2020-01-04', 'Egy malac a leveshez', 'Malac', 350);

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

INSERT INTO public.event_details(
    event_details_id, description, end_time, start_time)
VALUES (1, 'Sanyi es Zoli eskuvoje', '2020-01-26 09:15:00', '2020-01-28 10:00:00');
INSERT INTO public.event_details(
    event_details_id, description, end_time, start_time)
VALUES (2, 'Rozika keresztelője. Nagyjából 100 vendég, finom ételek, tánc.', '2020-05-12 09:00:00', '2020-05-13 06:00:00');
INSERT INTO public.event_details(
    event_details_id, description, end_time, start_time)
VALUES (3, 'Születésnap Dzsínókának', '2020-06-10 11:00:00', '2020-06-11 06:00:00');
INSERT INTO public.event_details(
    event_details_id, description, end_time, start_time)
VALUES (4, 'Tejfakasztó buli Andrisnak.', '2020-02-10 09:15:00', '2020-02-11 10:00:00');
INSERT INTO public.event_details(
    event_details_id, description, end_time, start_time)
VALUES (5, 'Konfirmálás Kiskerekiben 10 főre.', '2020-05-04 10:00:00', '2020-05-04 12:00:00'
);

INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (1, 'Laszlo', false, 'Preznyak', 1);
INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (2, 'Van', false, 'Damme', 4);
INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (3, 'Antoine', true, 'Griezmann', 7);
INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (4, 'Shrek', false, 'Shrek', 5);
INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (5, 'William', true, 'Smith', 3);
INSERT INTO public.guests(
    guest_id, first_name, is_invitation_accepted, last_name, contact_contact_id)
VALUES (6, 'Laszlo', true, 'Preznyak', 1);


INSERT INTO public.event_details_guest_list(
    event_details_event_details_id, guest_list_guest_id)
VALUES (1, 5);
INSERT INTO public.event_details_guest_list(
    event_details_event_details_id, guest_list_guest_id)
VALUES (5, 6);
INSERT INTO public.event_details_guest_list(
    event_details_event_details_id, guest_list_guest_id)
VALUES (4, 4);
INSERT INTO public.event_details_guest_list(
    event_details_event_details_id, guest_list_guest_id)
VALUES (3, 2);
INSERT INTO public.event_details_guest_list(
    event_details_event_details_id, guest_list_guest_id)
VALUES (2, 3);


INSERT INTO public.events(
    event_id, created, event_category, event_name, locality, event_details_event_details_id, user_user_id)
VALUES (1, current_timestamp, 'WEDDING', 'Homo lagzi', 'Zalaegerszeg', 1, 7);
INSERT INTO public.events(
    event_id, created, event_category, event_name, locality,  user_user_id)
VALUES (2, current_timestamp, 'WEDDING', 'Zsolt és Tímea esküvője', 'Érkeserű', 1);
INSERT INTO public.events(
    event_id, created, event_category, event_name, locality, event_details_event_details_id, user_user_id)
VALUES (3, current_timestamp, 'CHRISTENING', 'Rozika keresztelője', 'Debrecen', 2, 4);
INSERT INTO public.events(
    event_id, created, event_category, event_name, locality, event_details_event_details_id, user_user_id)
VALUES (4, current_timestamp, 'BIRTHDAY', 'Dzsínóka születésnap', 'Komárom', 3, 6);
INSERT INTO public.events(
    event_id, created, event_category, event_name, locality, user_user_id)
VALUES (5, current_timestamp, 'BIRTHDAY', 'Arnold 90. születésnapja', 'New York', 2);

INSERT INTO public.events_additional_cost_list(
    event_event_id, additional_cost_list_additional_cost_id)
VALUES (1, 4);
INSERT INTO public.events_additional_cost_list(
    event_event_id, additional_cost_list_additional_cost_id)
VALUES (2, 3);
INSERT INTO public.events_additional_cost_list(
    event_event_id, additional_cost_list_additional_cost_id)
VALUES (3, 2);
INSERT INTO public.events_additional_cost_list(
    event_event_id, additional_cost_list_additional_cost_id)
VALUES (4, 1);

INSERT INTO public.user_details_address_list(
    user_details_user_details_id, address_list_address_id)
VALUES (1, 1);
INSERT INTO public.user_details_address_list(
    user_details_user_details_id, address_list_address_id)
VALUES (2, 3);
INSERT INTO public.user_details_address_list(
    user_details_user_details_id, address_list_address_id)
VALUES (3, 4);

INSERT INTO public.service_details(
    id, rating, rating_number)
VALUES (1, 0, 0);
INSERT INTO public.service_details(
    id, rating, rating_number)
VALUES (2, 4, 2);
INSERT INTO public.service_details(
    id, rating, rating_number)
VALUES (3, 10, 5);

INSERT INTO public.comments(
    comment_id, commenter, date, message)
VALUES (1, 'Zolika', current_timestamp, 'Tökéletes zenekar, 10/10');
INSERT INTO public.comments(
    comment_id, commenter, date, message)
VALUES (2, 'Bütyök', current_timestamp, 'Nagyszerű ételek, kedves kiszolgálás. CSak ajánlani tudom.');
INSERT INTO public.comments(
    comment_id, commenter, date, message)
VALUES (3, 'Justin Timberlake', current_timestamp, 'He is the best CM Ive ever met');

INSERT INTO public.service_details_comment_list(
    service_details_id, comment_list_comment_id)
VALUES (1, 1);
INSERT INTO public.service_details_comment_list(
    service_details_id, comment_list_comment_id)
VALUES (2, 2);
INSERT INTO public.service_details_comment_list(
    service_details_id, comment_list_comment_id)
VALUES (3, 3);

INSERT INTO public.services(
    service_id, description, home_page, name, service_category, user_user_id, service_details_id)
VALUES (1, 'Lakodalmi zenekar, élő zene, minőség.', 'Home Page', 'Vegas Band', 'BAND', 2, 1);
INSERT INTO public.services(
    service_id, description, home_page, name, service_category, user_user_id, service_details_id)
VALUES (2, 'Kulturált étterem igényes vendégeknek.', 'Home Page', 'Csokonai Étterem', 'RESTAURANT', 7, 2);
INSERT INTO public.services(
    service_id, description, home_page, name, service_category, user_user_id, service_details_id)
VALUES (3, 'Lakodalmi vőfély-hagyományos-modern-megbízható.', 'Home Page', 'Preznyák László Vőfély', 'CEREMONYMASTER', 1, 3);

INSERT INTO public.services_contacts(
    service_service_id, contacts_contact_id)
VALUES (1, 2);
INSERT INTO public.services_contacts(
    service_service_id, contacts_contact_id)
VALUES (1, 5);
INSERT INTO public.services_contacts(
    service_service_id, contacts_contact_id)
VALUES (2, 7);
INSERT INTO public.services_contacts(
    service_service_id, contacts_contact_id)
VALUES (3, 1);


INSERT INTO public.services_addresses(
    service_service_id, addresses_address_id)
VALUES (3, 1);
INSERT INTO public.services_addresses(
    service_service_id, addresses_address_id)
VALUES (1, 2);

INSERT INTO public.contracts(
    contract_id, deposit, deposit_payment_time, description, is_deposit_payed, is_price_payed, payment_method, price, price_payment_time,service_service_id,event_event_id)
VALUES (1, 50, current_timestamp, 'description', false, false, 'CASH', 250, '2020-05-12 12:00:00', 3,1);
INSERT INTO public.contracts(
    contract_id, deposit, deposit_payment_time, description, is_deposit_payed, is_price_payed, payment_method, price, price_payment_time,service_service_id,event_event_id)
VALUES (2, 1000, current_timestamp, 'description', true, false, 'CASH', 3000, '2020-05-12 12:00:00', 2,2);
INSERT INTO public.contracts(
    contract_id, deposit, deposit_payment_time, description, is_deposit_payed, is_price_payed, payment_method, price, price_payment_time, service_service_id)
VALUES (3, 300, current_timestamp, 'description', false, false, 'CARD', 2300, '2020-05-12 12:00:00', 1);
