INSERT INTO customers (
        first_name, last_name, age, country) VALUES
            ('John', 'Doe', 28, 'USA'),
            ('Jane', 'Smith', 34, 'Canada'),
            ('Alice', 'Johnson', 25, 'UK'),
            ('Bob', 'Brown', 45, 'Australia'),
            ('Carol', 'White', 31, 'New Zealand');

INSERT INTO orders (amount, customer_id) VALUES
      (100, 1),
      (200, 1),
      (150, 2),
      (250, 2),
      (300, 3),
      (400, 3),
      (350, 4),
      (450, 4),
      (500, 1),
      (550, 3);
