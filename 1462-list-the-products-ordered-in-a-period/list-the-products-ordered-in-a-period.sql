SELECT 
Products.product_name,
SUM(Orders.unit) AS unit
FROM Products
INNER JOIN Orders
ON Products.product_id=Orders.product_id
WHERE MONTH(order_date)=02 AND YEAR(order_date)=2020
GROUP BY Products.product_name
HAVING unit>=100