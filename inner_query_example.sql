--Create table as per the existing structure and data
create table employee as select * from scott.emp;

create table department as select * from scott.dept;
/
--Verifying
select * from employee;
select * from department;

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
 *   Query to display employee details who are working under 'BLAKE'
 */

