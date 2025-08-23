create table public.student
(
    dob   date,
    id    bigint not null
        primary key,
    email varchar(255),
    name  varchar(255)
);

alter table public.student
    owner to postgres;

