-- first select
SELECT m.name AS movie_name
FROM movie m
         JOIN book b ON m.name = b.title;
-- second select
SELECT b.title AS book_title
FROM book b
         LEFT JOIN movie m ON b.title = m.name
WHERE m.name IS NULL;

-- third select
SELECT m.name AS title
FROM movie m
         LEFT JOIN book b ON m.name = b.title
WHERE b.title IS NULL

UNION

SELECT b.title AS title
FROM book b
         LEFT JOIN movie m ON b.title = m.name
WHERE m.name IS NULL;
