# Write your MySQL query statement below
select machine_id,ROUND(avg(time),3) as processing_time
from(
select a.machine_id,a.process_id,(t.timestamp-a.timestamp) as time
from activity as a
left join activity as t
on a.machine_id=t.machine_id
and a.process_id=t.process_id
where a.activity_type='start'
and t.activity_type='end'
) as f
group by machine_id
