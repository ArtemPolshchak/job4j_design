create
or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
    BEGIN
        insert into products (name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    END
$$;

call insert_data('product_2', 'producer_2', 15, 32);

create
    or replace procedure update_data(u_count integer, tax float, u_id integer)
    language 'plpgsql'
as $$
BEGIN
    if u_count > 0 THEN
        update products
        set count = count - u_count
        where id = u_id;
    end if;
    if
        tax > 0 THEN
        update products
        set price = price + price * tax;
    end if;
END;
$$;

call update_data(10, 0, 1);

call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);

call update_data(0, 0.2, 0);

alter procedure update_data(u_count integer, tax float, u_id integer) rename to update;

drop procedure update_data(u_count integer, tax float, u_id integer);

delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

create
    or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
    returns void
    language 'plpgsql'
as
$$
begin
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
end;
$$;

select f_insert_data('product_1', 'producer_1', 25, 50);

create
    or replace function f_update_data(u_count integer, tax float, u_id integer)
    returns integer
    language 'plpgsql'
as
$$
declare
    result integer;
begin
    if u_count > 0 THEN
        update products
        set count = count - u_count
        where id = u_id;
        select into result count
        from products
        where id = u_id;
    end if;
    if tax > 0 THEN
        update products
        set price = price + price * tax;
        select into result sum(price)
        from products;
    end if;
    return result;
end;
$$;

select f_update_data(10, 0, 1);

select f_insert_data('product_2', 'producer_2', 15, 32);
select f_insert_data('product_3', 'producer_3', 8, 115);

select f_update_data(0, 0.2, 0);
