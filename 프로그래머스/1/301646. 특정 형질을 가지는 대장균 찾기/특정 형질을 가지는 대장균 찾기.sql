select COUNT(*) AS COUNT from ECOLI_DATA E
where E.GENOTYPE & 2 = 0 AND -- 0010
    (E.GENOTYPE & 1 = 1 OR  -- 0001
    E.GENOTYPE & 4 = 4) -- 0100