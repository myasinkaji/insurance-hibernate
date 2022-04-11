create table stock (
                       id bigint not null,
                       name varchar(255),
                       primary key (id)
) engine=MyISAM;

create table stock_details (
                               id bigint not null,
                               details varchar(255),
                               stock_fk_yasin bigint,
                               primary key (id)
) engine=MyISAM;


alter table stock_details
    add constraint UK_sijixcfapx7svpv4yd1t3p6fg unique (stock_fk_yasin);

alter table stock_details
    add constraint FKtncv3uwwrrlhkd4pi05gl450v
        foreign key (stock_fk_yasin)
            references stock (id);