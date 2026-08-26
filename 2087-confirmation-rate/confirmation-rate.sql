# Write your MySQL query statement below
select s.user_id,coalesce(confirmation_rate,0) as confirmation_rate
from  signups as s
left join
(
select user_id,ROUND(sum(
     case
     when action='confirmed' then 1
     else 0
     end
)/count(action),2) as confirmation_rate
from confirmations as c
group by user_id
) as f
on s.user_id=f.user_id
