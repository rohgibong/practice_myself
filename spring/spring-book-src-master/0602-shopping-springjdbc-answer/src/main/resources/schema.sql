CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        address VARCHAR(255) NOT NULL,
                        phone VARCHAR(20) NOT NULL,
                        email_address VARCHAR(255) NOT NULL,
                        payment_method VARCHAR(50) NOT NULL
);

CREATE TABLE cart_items (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            product_id VARCHAR(50) NOT NULL,
                            product_name VARCHAR(255) NOT NULL,
                            product_price DECIMAL(10, 2) NOT NULL,
                            quantity INT NOT NULL,
                            order_id INT,
                            FOREIGN KEY (order_id) REFERENCES orders(id)
);