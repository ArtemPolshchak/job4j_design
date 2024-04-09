create
    or replace function tax()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.2
    where id = (select id from inserted);
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger first_trigger
    after insert on products
    referencing new table as inserted
    for each statement execute procedure tax();
