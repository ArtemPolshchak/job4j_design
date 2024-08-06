-- 1 задание
select p.name as person_name, c.name as company_name
from person p
join company c on p.company_id = c.id
where p.company_id <> 5 or p.company_id is null;

-- 2 задание
with company_counts as (
   select c.name as company_name, count(p.id) as person_count
   from company c left join person p on c.id = p.company_id
   group by c.name
)
select company_name, person_count
from company_counts
where person_count = (select max(person_count) from company_counts);
