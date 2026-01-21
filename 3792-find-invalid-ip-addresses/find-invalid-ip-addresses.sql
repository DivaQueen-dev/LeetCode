SELECT ip, COUNT(*) AS invalid_count
FROM logs
WHERE 
  -- Condition 1: Must have exactly 4 octets
  LENGTH(ip) - LENGTH(REPLACE(ip, '.', '')) != 3

  -- Condition 2: Leading zero in any octet
  OR ip REGEXP '\\.0[0-9]+|^0[0-9]+'

  -- Condition 3: Octet value out of range
  OR NOT (
    SUBSTRING_INDEX(ip, '.', 1) REGEXP '^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$' AND
    SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) REGEXP '^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$' AND
    SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', -2), '.', 1) REGEXP '^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$' AND
    SUBSTRING_INDEX(ip, '.', -1) REGEXP '^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$'
  )
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;