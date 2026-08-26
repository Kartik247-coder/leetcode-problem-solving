# Write your MySQL query statement below
select product_id,coalesce(ROUND(sum(s)/sum(units),2),0) as average_price
from(
select p.product_id,(p.price*u.units) as s,u.units
from prices as p
left join UnitsSold as u
on p.product_id=u.product_id
and u.purchase_date>=start_date
and u.purchase_date<=end_date
) as f
group by product_id
