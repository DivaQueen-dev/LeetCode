with Single_Dept_Emp as(
    select employee_id,department_id from Employee
    group by employee_id
    having count(department_id) = 1
)

select * from Single_Dept_Emp
union
select employee_id,department_id from Employee
where primary_flag = 'Y'
 