-- Initialize category table with sample data
INSERT INTO category (id, description, name)
VALUES (1, 'Electronic devices and gadgets', 'Electronics'),
       (2, 'Clothing and fashion items', 'Apparel'),
       (3, 'Home and kitchen products', 'Home & Kitchen'),
       (4, 'Books and stationery', 'Books'),
       (5, 'Sports and outdoor equipment', 'Sports'),
       (6, 'Health and beauty products', 'Beauty'),
       (7, 'Toys and games for children', 'Toys'),
       (8, 'Automotive parts and accessories', 'Automotive'),
       (9, 'Groceries and food items', 'Grocery'),
       (10, 'Furniture and home decor', 'Furniture');

-- Initialize product table with sample data
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (1, 'Latest smartphone with advanced camera', 'Smartphone X', 150, 899.99, 1),
       (2, 'Wireless noise-canceling headphones', 'Premium Headphones', 75, 249.99, 1),
       (3, 'Comfortable cotton t-shirt', 'Classic T-Shirt', 200, 19.99, 2),
       (4, 'Non-stick frying pan set', 'Cookware Set', 50, 59.95, 3),
       (5, 'Bestselling fiction novel', 'The Great Adventure', 120, 14.99, 4),
       (6, 'Professional football', 'Match Ball', 80, 39.99, 5),
       (7, 'Moisturizing face cream', 'Hydrating Cream', 180, 24.50, 6),
       (8, 'Educational building blocks', 'Kids Building Set', 90, 29.99, 7),
       (9, 'Car phone mount', 'Phone Holder', 110, 12.99, 8),
       (10, 'Organic extra virgin olive oil', 'Premium Olive Oil', 65, 15.99, 9);

-- Update sequences to avoid primary key conflicts
SELECT setval('category_seq', COALESCE((SELECT MAX(id) FROM category), 0) + 1);
SELECT setval('product_seq', COALESCE((SELECT MAX(id) FROM product), 0) + 1);
