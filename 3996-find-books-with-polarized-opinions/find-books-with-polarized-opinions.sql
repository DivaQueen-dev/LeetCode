WITH book_stats AS (
    SELECT book_id, 
        MAX(session_rating) AS rmax,
        MIN(session_rating) AS rmin,
        COUNT(1) AS cnt,
        SUM(CASE WHEN session_rating <= 2 THEN 1 ELSE 0 END) AS less_2,
        SUM(CASE WHEN session_rating >= 4 THEN 1 ELSE 0 END) AS more_4
    FROM reading_sessions
    GROUP BY book_id
    HAVING COUNT(1) >= 5
       AND SUM(CASE WHEN session_rating <= 2 THEN 1 ELSE 0 END) > 0
       AND SUM(CASE WHEN session_rating >= 4 THEN 1 ELSE 0 END) > 0
       AND CAST(SUM(CASE WHEN session_rating <= 2 THEN 1 ELSE 0 END) 
			  + SUM(CASE WHEN session_rating >= 4 THEN 1 ELSE 0 END) AS FLOAT) / COUNT(1) >= 0.6)
SELECT b.book_id,  b.title,  b.author,  b.genre,  b.pages, bs.rmax - bs.rmin AS rating_spread,
    ROUND(((bs.less_2 + bs.more_4) * 1.0) / bs.cnt, 2) AS polarization_score
FROM book_stats bs
INNER JOIN books b
ON bs.book_id = b.book_id
ORDER BY polarization_score DESC, b.title DESC;