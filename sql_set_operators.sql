/***Set Operators***
*===================
1) Union
2) Union all
3) Intersect
4) Minus

1) Unions - this operator returns all the values from all the sets excluding duplicates.

select deptno from emp 
union 
select deptno from dept;

2) Union all - this operator returns all the values from all the sets including duplicates.

select deptno from emp 
union all
select deptno from dept;

3) Intersect - This operator returns common values from all the sets.

select deptno from emp 
intersect
select deptno from dept;

4) Minus - This operator returns the values which are available in one set but not available in another set.

select deptno from emp 
minus 
select deptno from dept;

create table employee as select * from scott.emp;

create table department as select * from scott.dept;
/
select deptno from employee
union
select deptno from department;
/
select deptno from employee
union all
select deptno from department;
/
select deptno from employee
intersect
select deptno from department;
/
select deptno from employee
minus
select deptno from department;
/
**/
/****Question****
*Query to display last three records from the table
*
*/
select * from employee where rownum <= (select count(*) from employee)
minus
select * from employee where rownum <= (select count(*) from employee)-3;

/****Question****
*Query to display employee records except first & last records of the table
*
*/
select * from employee where rownum <> (select max(rownum) from employee)
minus
select * from employee e where rownum <> (select min(rownum)+1 from employee)

/****Question****
*Query to display maximum & minimum saleried employee records
*
*/
select * from employee where sal = (select max(sal) from employee)
union
select * from employee where sal = (select min(sal) from employee)

/****Question****
*Query to count number of employees who are workin in CHIKAGO
*
*/
select e.* from employee e, department d
where
d.loc = 'CHICAGO'
and e.deptno = d.deptno

or

select * from employee 
where 
deptno = (select deptno from department where loc = 'CHICAGO');

/****Question****
*Query to display maximum & minimum experienced employee records
*
*/
select * from employee where (sysdate-hiredate) = (select max(sysdate-hiredate) from employee)
union
select * from employee where (sysdate-hiredate) = (select min(sysdate-hiredate) from employee)

/****Question****
*Query to display maximum & minimum experienced employee records who are working in ACCOUNTING
*
*/
select * from employee where (sysdate-hiredate) = (select max(sysdate-hiredate) from employee where deptno = (select deptno from department where dname = 'ACCOUNTING'))
union
select * from employee where (sysdate-hiredate) = (select min(sysdate-hiredate) from employee where deptno = (select deptno from department where dname = 'ACCOUNTING'))

/****Question****
*Query to display empllyee details whose salary is less than maximum salary working under 30th department
*
*/
select * from employee where deptno = 30 and sal < (select max(sal) from employee where deptno = 30) order by sal desc

/****Question****
*Query to display sum of all the salary of employees who are working under 'BLAKE'
*
*/
select sum(sal) from employee where mgr = (select empno from employee where ename = 'BLAKE');

/****Question****
*Query to display the employee details whose salary is less then maximum commission
*
*/
select * from employee where sal < (select max(COMM) from employee);




