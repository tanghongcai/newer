create table tbl_user(
  userId number primary key,
  userName varchar2(20),
  pwd varchar2(20),
  realName varchar2(20)
)

create table tbl_user_role(
  usersId number references tbl_user(userId),
  roleId number references tbl_role(rid)
)

create table tbl_role(
  rid number primary key,
  roleName varchar2(20),
  remark varchar2(50)
)

create sequence seq_tbl_user;
create sequence seq_tbl_role;

create or replace trigger tri_tbl_user
before insert on tbl_user
for each row
  begin
    select seq_tbl_user.nextval into:new.userId from dual;
    end;
/


create or replace trigger tri_tbl_role
before insert on tbl_role
for each row
  begin
    select seq_tbl_role.nextval into:new.rid from dual;
    end;
/

insert into tbl_user(userName,pwd,realName) values('admin','123','王五');
insert into tbl_user(userName,pwd,realName) values('zhang','123','张三');

insert into tbl_role(roleName,remark) values('经理','负责管理');
insert into tbl_role(roleName,remark) values('员工','负责事务');

insert into tbl_user_role(usersId,roleId) values(1,1);
insert into tbl_user_role(usersId,roleId) values(2,2);

select * from tbl_user
select * from tbl_user_role
select * from tbl_role
drop table tbl_user
