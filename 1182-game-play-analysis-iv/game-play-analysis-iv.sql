# Write your MySQL query statement below
select coalesce (ROUND(SUM(case
           when b.event_date is not null then 1
           else 0
           end
)/(select count(distinct player_id) from activity),2),0) as fraction
from activity as a
left join
activity as b
on a.player_id=b.player_id
and DATEDIFF(b.event_date,a.event_date)=1
where (a.player_id,a.event_date) in
(
    select player_id,MIN(event_date)
    from activity
    group by player_id
)
