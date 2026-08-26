# Write your MySQL query statement below
select query_name,round(avg(ratio),2) as quality,
round(sum( 
    case 
    when rating<3 then 1
    else 0
    end
)*100/count(rating),2) as poor_query_percentage
from(                              
select query_name,rating,(rating/position) as ratio
from queries
) as f
group by query_name