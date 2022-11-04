select * from student;
select * from student where age>10 and student.age<20;
select name from student;
select * from student where name like '%j%' or name like '%J%';
select * from student where age>student.id;
select * from student order by age