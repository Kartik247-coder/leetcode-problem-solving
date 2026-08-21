# Write your MySQL query statement below
select customer_id,count(visit_id) as count_no_trans
from(

select v.customer_id,v.visit_id
from visits as v
left join
transactions as t
on v.visit_id=t.visit_id
where t.visit_id is null
) as f
group by customer_id