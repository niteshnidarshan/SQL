show databases;
create database repository;
use repository;
show tables;
create table dept(  
  deptno     numeric(2,0),  
  dname      varchar(14),  
  loc        varchar(14),  
  constraint pk_dept primary key (deptno)  
);
create table EMP (
  empno    numeric(4,0),  
  ename    varchar(10),  
  job      varchar(9),  
  mgr      numeric(4,0),  
  hiredate date,  
  sal      numeric(7,2),  
  comm     numeric(7,2),  
  deptno   numeric(2,0),  
  constraint pk_emp primary key (empno),  
  constraint fk_deptno foreign key (deptno) references dept (deptno)  
);


insert into DEPT (DEPTNO, DNAME, LOC)
values(10, 'ACCOUNTING', 'NEW YORK');

-- Insert a row into DEPT table by column position.
insert into dept  
values(20, 'RESEARCH', 'DALLAS');

insert into dept  
values(30, 'SALES', 'CHICAGO');

insert into dept  
values(40, 'OPERATIONS', 'BOSTON');

insert into emp  
values(  
 7839, 'KING', 'PRESIDENT', null,  
 str_to_date('17-11-1981','%d-%m-%Y'),  
 5000, null, 10  
);

insert into emp  
values(  
 7698, 'BLAKE', 'MANAGER', 7839,  
 str_to_date('1-5-1981','%d-%m-%Y'),  
 2850, null, 30  
);

insert into emp  
values(  
 7782, 'CLARK', 'MANAGER', 7839,  
 str_to_date('9-6-1981','%d-%m-%Y'),  
 2450, null, 10  
);

insert into emp  
values(  
 7566, 'JONES', 'MANAGER', 7839,  
 str_to_date('2-4-1981','%d-%m-%Y'),  
 2975, null, 20  
);

insert into emp  
values(  
 7788, 'SCOTT', 'ANALYST', 7566,  
 str_to_date('14-06-87','%d-%m-%Y'),  
 3000, null, 20  
);

insert into emp  
values(  
 7902, 'FORD', 'ANALYST', 7566,  
 str_to_date('3-12-1981','%d-%m-%Y'),  
 3000, null, 20  
);

insert into emp  
values(  
 7369, 'SMITH', 'CLERK', 7902,  
 str_to_date('17-12-1980','%d-%m-%Y'),  
 800, null, 20  
);

insert into emp  
values(  
 7499, 'ALLEN', 'SALESMAN', 7698,  
 str_to_date('20-2-1981','%d-%m-%Y'),  
 1600, 300, 30  
);

insert into emp  
values(  
 7521, 'WARD', 'SALESMAN', 7698,  
 str_to_date('22-2-1981','%d-%m-%Y'),  
 1250, 500, 30  
);

insert into emp  
values(  
 7654, 'MARTIN', 'SALESMAN', 7698,  
 str_to_date('28-9-1981','%d-%m-%Y'),  
 1250, 1400, 30  
);

insert into emp  
values(  
 7844, 'TURNER', 'SALESMAN', 7698,  
 str_to_date('8-9-1981','%d-%m-%Y'),  
 1500, 0, 30  
);

insert into emp  
values(  
 7876, 'ADAMS', 'CLERK', 7788,  
 str_to_date('14-06-87', '%d-%m-%Y'),  
 1100, null, 20  
);

insert into emp  
values(  
 7900, 'JAMES', 'CLERK', 7698,  
 str_to_date('3-12-1981','%d-%m-%Y'),  
 950, null, 30  
);

insert into emp  
values(  
 7934, 'MILLER', 'CLERK', 7782,  
 str_to_date('23-1-1982','%d-%m-%Y'),  
 1300, null, 10  
);

commit;

select ename, dname, job, empno, hiredate, loc  
from emp, dept  
where emp.deptno = dept.deptno  
order by 3;


select dname, count(*) count_of_employees
from dept, emp
where dept.deptno = emp.deptno
group by DNAME
order by 2 desc;

