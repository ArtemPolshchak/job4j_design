CREATE OR REPLACE PROCEDURE delete_by_id(d_id INTEGER)
    LANGUAGE 'plpgsql'
AS $$
BEGIN
    DELETE FROM products
    WHERE id = d_id;
END;
$$;

CALL delete_by_id(10);

CREATE OR REPLACE FUNCTION delete_zero_count()
    RETURNS INTEGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    deleted_count INTEGER;
BEGIN
    DELETE FROM products
    WHERE count = 0
    RETURNING id INTO deleted_count;

    RETURN deleted_count;
END;
$$;

SELECT delete_zero_count();
