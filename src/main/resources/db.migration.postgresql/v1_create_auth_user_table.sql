create table public.auth_user(
    id bigserial not null primary key ,
    email varchar(255) not null unique,
    password varchar(255) not null
)