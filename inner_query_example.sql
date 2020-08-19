--Create table as per the existing structure and data
create table employee as select * from scott.emp;

create table department as select * from scott.dept;
/
--Verifying
select * from employee;
select * from department;

/**
* To get row number
*/
select rownum, t.* from tab t;


/**
* Query to find first three max salaried wmployee details
*/
select * from 
(select * from employee order by sal desc) 
where 
rownum <= 3
order by sal desc;


/****Question*******
 *   To select all the employees whose salaray is greater than his manager salary
 */
select e.*
from EMPLOYEE e
where 
e.sal > (select m.sal from employee m where e.mgr = m.empno);

/* solution result 
EMPNO	ENAME	JOB	MGR	HIREDATE	SAL	COMM	DEPTNO
7788	SCOTT	ANALYST	7566	19-APR-87	3000	 - 	20
7902	FORD	ANALYST	7566	03-DEC-81	3000	 - 	20
*/

/****Question*******
 *   Query employee details whose salary is less than 7788 employee
 */
select * from employee where sal<(select sal from employee where empno = 7788);

/****Question*******
 *   Query employee details whose salary is less than 7788 employee and working under 10th & 20th dept
 */
 
select * from employee where sal<(select sal from employee where empno = 7788) and deptno in (10, 20);

/****Question*******
 *   Query employee details whose salary is less than maximum salary
 */
select * from employee where sal < (select max(sal) from employee);

/****Question*******
 *   Query employee details whose salary is less than 7788 employee and who are getting commission
 */
select * from employee where sal < (select sal from employee where empno = 7788) and comm > 0;
select * from employee where sal < (select sal from employee where empno = 7788) and comm is not null;

/****Question*******
 *   Query to count the number of employees whose salary is greater than minimum salary
 */
select count(*) from employee where sal > (select min(sal) from employee);


/****Question*******
 *   Query to display Turner's manager name
 */
select ename from employee where empno = (select mgr from employee where ename = 'TURNER');


/****Question*******
 *   Query to display employee details who are working under 'BLAKE'
 */
select * from employee where mgr = (select empno from employee where ename = 'BLAKE');

/****Question*******
 *   Query to display maximum salary employee details who are working under 'BLAKE'
 */
select * from employee where sal = (select max(sal) from employee where mgr = (select empno from employee where ename = 'BLAKE') )
 
/****Question*******
 *   Query to display the third max salaried employee
 */
select * from employee where sal = (select max(sal) from employee where sal < (select max(sal) from employee where sal < (select max(sal) from employee)));


/****Question*******
 *   Query to display the employee details working under sales department
 */
select * from employee where deptno = (select deptno from department where dname = 'SALES');

select e.* from employee e, department d 
where e.deptno = d.deptno
and d.dname = 'SALES';

/****Question*******
 *   Query to display the employee details who are having maximum total salary under sales department
 */
select * from employee 
where 
sal+nvl(comm,0) = (select max(sal+nvl(comm,0)) from employee where deptno = (select deptno from department where dname = 'SALES'));

