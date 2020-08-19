REM   Script: inner_query
REM   SQL script for inner queries example

create table employee as select * from scott.emp;

create table department as select * from scott.dept;

select * from employee;

select * from department;

select e.* 
from EMPLOYEE e 
where  
e.sal > (select m.sal from employee m where e.mgr = m.empno);

select * from employee where sal<(select sal from employee where empno = 7788);

select * from employee where sal<(select sal from employee where empno = 7788) and deptno in (10, 20);

select * from employee where sal < (select max(sal) from employee);

select * from employee where sal < (select sal from employee where empno = 7788) and comm > 0;

select * from employee where sal < (select sal from employee where empno = 7788) and comm is not null;

select count(*) from employee where sal > (select min(sal) from employee);

select ename from employee where empno = (select mgr from employee where ename = 'TURNER');

select * from employee where mgr = (select empno from employee where ename = 'BLAKE');

