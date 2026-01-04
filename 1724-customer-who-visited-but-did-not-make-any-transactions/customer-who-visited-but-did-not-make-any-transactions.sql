# Write your MySQL query statement below
SELECT customer_id ,COUNT(v.visit_id) as count_no_trans  FROM Visits as v
left join Transactions as t
on v.visit_id = t.visit_id
where t.transaction_id is null
group by customer_id
order by count_no_trans asc;