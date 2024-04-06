create trigger third_trigger
    after insert on products
    for each row execute procedure update_products();

create or replace function update_products()
    returns trigger as
$$BEGIN
    INSERT INTO history_of_price (name, price, date)
    VALUES (NEW.name, NEW.price, CURRENT_TIMESTAMP);
    RETURN NEW;
END;
$$
    LANGUAGE 'plpgsql';