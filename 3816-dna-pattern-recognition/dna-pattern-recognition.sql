SELECT  
    s.sample_id,
    s.dna_sequence,
    s.species,
    CASE 
        WHEN LEFT(s.dna_sequence, 3) = 'ATG' THEN 1 ELSE 0 
    END AS has_start,
    CASE 
        WHEN RIGHT(s.dna_sequence, 3) IN ('TAA', 'TAG', 'TGA') THEN 1 ELSE 0 
    END AS has_stop,
    CASE 
        WHEN s.dna_sequence LIKE '%ATAT%' THEN 1 ELSE 0 
    END AS has_atat,
    CASE 
        WHEN s.dna_sequence LIKE '%GGG%' THEN 1 ELSE 0 
    END AS has_ggg
FROM samples s
ORDER BY s.sample_id ASC;