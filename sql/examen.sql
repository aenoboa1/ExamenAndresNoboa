
/*==============================================================*/
/* Table: SEG_PERFIL                                            */
/*==============================================================*/
create table SEG_PERFIL
(
    COD_PERFIL           varchar(8) not null  comment '',
    NOMBRE               varchar(100)  comment '',
    VERSION              int  comment '',
    primary key (COD_PERFIL)
);

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SEG_USUARIO
(
    COD_USUARIO          int not null  comment '',
    MAIL                 varchar(128) not null  comment '',
    CLAVE                varchar(64) not null  comment '',
    NOMBRE               varchar(128) not null  comment '',
    INTENTOS_FALLIDOS    numeric(8)  comment '',
    SUELDO               numeric(8,2) not null  comment '',
    FECHA_NACIMIENTO     date  comment '',
    VERSION              int  comment '',
    primary key (COD_USUARIO)
);

/*==============================================================*/
/* Table: SEG_USUARIO_PERFIL                                    */
/*==============================================================*/
create table SEG_USUARIO_PERFIL
(
    COD_USUARIO          int not null  comment '',
    COD_PERFIL           varchar(8) not null  comment '',
    FECHA_CREACION       timestamp not null  comment '',
    ES_ACTIVO            boolean not null  comment '',
    VERSION              int  comment '',
    primary key (COD_USUARIO, COD_PERFIL)
);

alter table SEG_USUARIO_PERFIL add constraint FK_SEG_USUA_SEG_USUAR_SEG_PERF foreign key (COD_PERFIL)
    references SEG_PERFIL (COD_PERFIL) on delete restrict on update restrict;

alter table SEG_USUARIO_PERFIL add constraint FK_SEG_USUA_SEG_USUAR_SEG_USUA foreign key (COD_USUARIO)
    references SEG_USUARIO (COD_USUARIO) on delete restrict on update restrict;

