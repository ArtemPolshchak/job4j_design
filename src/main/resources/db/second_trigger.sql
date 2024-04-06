create trigger before_trigger
    before insert
    on products
    for each row execute procedure pre_tax();



create or replace function pre_tax()
    returns trigger as
$$BEGIN
    update products
    set price = price + price * 0.2
    where id = new.id;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';