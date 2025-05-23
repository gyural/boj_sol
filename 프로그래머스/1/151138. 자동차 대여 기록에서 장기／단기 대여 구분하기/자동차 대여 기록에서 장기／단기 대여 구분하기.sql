-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, 
    TO_CHAR(START_DATE, 'yyyy-mm-dd'), 
    TO_CHAR(END_DATE, 'yyyy-mm-dd'),
    CASE 
        WHEN END_DATE - START_DATE + 1 >= 30 THEN '장기 대여'
        ELSE '단기 대여'
    END AS RENT_TYPE 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE TO_CHAR(START_DATE, 'yyyy-mm-dd') BETWEEN '2022-09-01' AND '2022-09-31'
ORDER BY HISTORY_ID DESC