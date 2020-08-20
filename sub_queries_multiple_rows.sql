/***sub_queries_multiple_rows***/

/** all = and
**  any = or
**/

create table employee as select * from scott.emp;

create table department as select * from scott.dept;

/***Question***
*Deisplay employee details who are working under SALES & ACCOUNTING departments
*/
select * from employee where deptno in (select deptno from department where dname in ('SALES', 'ACCOUNTING'));

/***Question***
*Deisplay employee details who are working under BLAKE & CLARK
*/
select * from employee where mgr in (select empno from employee where ename in ('BLAKE', 'CLARK'));

/***Question***
*Deisplay employee details whose salary is less than any employee salary working under 20th department
*/
select * from employee where sal < ANY(select sal from employee where deptno = 20);

/***Question***
*Deisplay employee details whose salary is less than all employee salary working under 30th department
*/
select * from employee where sal < ALL(select sal from employee where deptno = 30);

/***Question***
*Deisplay employee name who has maximum experience working in research & operation dept
*/
select ename from employee where (sysdate-hiredate) = (select max(sysdate-hiredate) from employee where deptno in (select deptno from department where dname in ('RESEARCH', 'OPERATIONS')))

/***Question***
*Deisplay employee details who are having max and min commission
*/
select * from employee where comm = (select max(comm) from employee)
union
select * from employee where comm = (select min(comm) from employee)

or

select * from employee where comm in (select max(comm) from employee union select min(comm) from employee)
