SELECT A.CAR_ID, A.CAR_TYPE, ROUND(A.DAILY_FEE * 30 * (1-B.DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN B ON A.CAR_TYPE = B.CAR_TYPE AND B.CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE = '30일 이상' LEFT OUTER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY C ON A.CAR_ID = C.CAR_ID AND ('2022-11-01' BETWEEN C.START_DATE AND C.END_DATE OR '2022-11-30' BETWEEN C.START_DATE AND C.END_DATE)
WHERE ROUND(A.DAILY_FEE * 30 * (1-B.DISCOUNT_RATE/100)) BETWEEN 500000 AND 2000000 AND C.CAR_ID IS NULL
GROUP BY A.CAR_ID
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC;