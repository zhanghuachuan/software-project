/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/18 15:42:33                           */
/*==============================================================*/


drop table if exists Admin;

drop table if exists Book;

drop table if exists Business;

drop table if exists User;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   Admin_ID             varchar(20) not null,
   Admin_Name           varchar(20) not null,
   Admin_Password       varchar(20) not null,
   Admin_Phone          varchar(11) not null,
   Admin_Identification varchar(20) not null,
   primary key (Admin_ID)
);

/*==============================================================*/
/* Table: Book                                                  */
/*==============================================================*/
create table Book
(
   Book_Id              varchar(10) not null,
   Admin_ID             varchar(20) not null,
   Book_Name            varchar(30) not null,
   Book_Price           varchar(10) not null,
   Book_Quantity        varchar(10) not null,
   Book_Author          varchar(20) not null,
   Book_Type            varchar(10) not null,
   primary key (Book_Id)
);

/*==============================================================*/
/* Table: Business                                              */
/*==============================================================*/
create table Business
(
   Book_Id              varchar(10) not null,
   Username             varchar(10) not null,
   Money                varchar(10),
   Time                 datetime,
   Quantity             varchar(10),
   primary key (Book_Id, Username)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   Username             varchar(10) not null,
   Admin_ID             varchar(20) not null,
   Real_name            varchar(10) not null,
   Password             varchar(15) not null,
   Telephone            varchar(11) not null,
   Email                varchar(20) not null,
   Address              varchar(50) not null,
   Identification       varchar(20) not null,
   primary key (Username)
);

alter table Book add constraint FK_manage foreign key (Admin_ID)
      references Admin (Admin_ID) on delete restrict on update restrict;

alter table Business add constraint FK_Business foreign key (Book_Id)
      references Book (Book_Id) on delete restrict on update restrict;

alter table Business add constraint FK_Business2 foreign key (Username)
      references User (Username) on delete restrict on update restrict;

alter table User add constraint FK_manage1 foreign key (Admin_ID)
      references Admin (Admin_ID) on delete restrict on update restrict;

