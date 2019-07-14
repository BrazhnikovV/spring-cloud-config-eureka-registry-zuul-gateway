insert into account (id,created_at,updated_at,account_number )
values ( 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '75-563-457556' );
insert into customer ( id, created_at, updated_at,email,first_name,last_name,password,role,token,username,account_id )
values ( 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'brazhnikov_ve@mail.ru', 'Vasya', 'Brazhnikov', '21232f297a57a5a743894a0e4a801fc3', 'ROLE_ADMIN', '8d5dd466-226c-419b-ac04-a5ccc6b42d82', 'admin', 1);
