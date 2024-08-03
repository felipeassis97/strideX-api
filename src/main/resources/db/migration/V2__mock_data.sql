-- Inserting an address
INSERT INTO address (street, neighborhood, city, state, country, zipcode, lat, lng)
VALUES ('123 Main St', 'Downtown', 'Springfield', 'IL', 'USA', '62701', 39.7817, -89.6501);

-- Inserting a store and associating it with the created address
INSERT INTO store (name, description, logo, address_id)
VALUES ('My Store', 'A great store', 'logo.png', LAST_INSERT_ID());

-- Inserting a brand
INSERT INTO brand (name)
VALUES ('Brand A');

-- Inserting a genre
INSERT INTO genre (name)
VALUES ('Casual');

-- Inserting a product and associating it with the created store and brand
INSERT INTO product (store_id, brand_id, title, description, price, quantity)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 'Product 1', 'Description of product 1', 29.99, 100);

-- Inserting a product image and associating it with the created product
INSERT INTO product_image (product_id, url)
VALUES (LAST_INSERT_ID(), 'http://example.com/product1.png');

-- Inserting a size
INSERT INTO size (size)
VALUES ('M');

-- Associating the product with the size
INSERT INTO product_size (product_id, size_id)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID());

-- Associating the product with the genre
INSERT INTO product_genre (product_id, genre_id)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID());
