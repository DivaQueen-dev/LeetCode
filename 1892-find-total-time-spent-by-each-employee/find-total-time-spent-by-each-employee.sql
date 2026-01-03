WITH daily_work_time AS (
    SELECT
        SUM(out_time) AS total_out_time,
        SUM(in_time) AS total_in_time,
        emp_id,
        event_day
    FROM employees
    GROUP BY event_day, emp_id
)
SELECT
    event_day AS day,
    emp_id,
    total_out_time - total_in_time AS total_time
FROM daily_work_time;