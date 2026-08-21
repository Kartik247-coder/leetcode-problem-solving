# Write your MySQL query statement below
select w.id
from weather as w
left join
weather as v
on DATEDIFF(w.recordDate,v.recordDate)=1
where w.temperature>v.temperature