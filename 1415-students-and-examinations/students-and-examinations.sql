# Write your MySQL query statement below
select f.student_id,f.student_name,f.subject_name,count(e.student_id) as attended_exams
from
(select s.student_id,s.student_name,sb.subject_name
from students as s
cross join
subjects as sb) as f
left join
examinations as e
on f.student_id=e.student_id
and f.subject_name=e.subject_name
group by f.student_id,f.subject_name
order by f.student_id,f.subject_name



