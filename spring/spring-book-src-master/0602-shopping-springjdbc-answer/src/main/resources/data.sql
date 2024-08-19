INSERT INTO orders (name, address, phone, email_address, payment_method) VALUES
    ('김철수', '서울시', '090-0000-0000', 'taro@example.com', 'CONVENIENCE_STORE');

INSERT INTO cart_items (product_id, product_name, product_price, quantity, order_id) VALUES
                                                                                         ('p01', '지우개', 100, 3, 1),
                                                                                         ('p02', '노트', 200, 4, 1);