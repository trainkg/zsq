--	drop table if exists zq_permission;
--	
--	drop table if exists zq_role;
--	
--	drop table if exists zq_user;
--	
--	drop table if exists zq_user_dict;
--	
--	drop table if exists zq_user_permission;
--	
--	drop table if exists zq_user_role;

/*==============================================================*/
/* Table: zq_permission                                         */
/*==============================================================*/
create table zq_permission
(
   id                   varchar(32) not null,
   name                 varchar(50) not null,
   code                 varchar(10) not null,
   dict_id              varchar(32) not null,
   primary key (id)
);

alter table zq_permission comment '包含系统所有的权限资源';

/*==============================================================*/
/* Table: zq_role                                               */
/*==============================================================*/
create table zq_role
(
   ID                   varchar(32) not null,
   group_name           varchar(20) not null,
   primary key (ID)
);

alter table zq_role comment '系统角色列表';

/*==============================================================*/
/* Table: zq_user                                               */
/*==============================================================*/
create table zq_user
(
   id                   varchar(32) not null,
   username             varchar(50) not null,
   password             varchar(200) not null,
   sex                  smallint comment '0：男 1：女 2：其他',
   email                varchar(100),
   homeAddress          varchar(200),
   phone                varchar(20),
   primary key (id)
);

alter table zq_user comment '人员基本信息表';

/*==============================================================*/
/* Table: zq_user_dict                                          */
/*==============================================================*/
create table zq_user_dict
(
   id                   varchar(32) not null,
   name                 varchar(50) not null,
   type                 smallint not null comment '字典数据类型 ： 记录字典数据使用对象类型  可扩展
            0： 权限资源',
   primary key (id)
);

alter table zq_user_dict comment '用户模块数据字典';

/*==============================================================*/
/* Table: zq_user_permission                                    */
/*==============================================================*/
create table zq_user_permission
(
   role_id              varchar(32) not null,
   perm_id              varchar(32) not null,
   id                   varchar(32) not null,
   primary key (id)
);

alter table zq_user_permission comment '描述角色拥有的权限列表信息';

/*==============================================================*/
/* Table: zq_user_role                                          */
/*==============================================================*/
create table zq_user_role
(
   id                   varchar(32) not null,
   role_id              varchar(32) not null,
   user_id              varchar(32) not null,
   primary key (id)
);

alter table zq_permission add constraint FK_Reference_3 foreign key (dict_id)
      references zq_user_dict (id) on delete restrict on update restrict;

alter table zq_user_permission add constraint FK_Reference_4 foreign key (role_id)
      references zq_role (ID) on delete restrict on update restrict;

alter table zq_user_permission add constraint FK_Reference_5 foreign key (perm_id)
      references zq_permission (id) on delete restrict on update restrict;

alter table zq_user_role add constraint FK_Reference_1 foreign key (role_id)
      references zq_role (ID) on delete restrict on update restrict;

alter table zq_user_role add constraint FK_Reference_2 foreign key (user_id)
      references zq_user (id) on delete restrict on update restrict;
