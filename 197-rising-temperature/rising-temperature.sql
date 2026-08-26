# Write your MySQL query statement below
select w.id
from weather as w
left join weather as t
on DATEDIFF(w.recordDate,t.recordDate)=1
where w.temperature>t.temperature
