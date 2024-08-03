-- Inserindo um endereço
INSERT INTO address (street, neighborhood, city, state, country, zipcode, lat, lng)
VALUES ('123 Main St', 'Downtown', 'Springfield', 'IL', 'USA', '62701', 39.7817, -89.6501);

-- Inserindo uma loja e associando ao endereço criado
INSERT INTO store (name, description, logo, address_id)
VALUES ('My Store', 'A great store', 'logo.png', LAST_INSERT_ID());

-- Inserindo uma marca
INSERT INTO brand (name)
VALUES ('Brand A');

-- Inserindo um gênero
INSERT INTO genre (name)
VALUES ('Casual');

-- Inserindo um produto e associando à loja e à marca criadas
INSERT INTO product (store_id, brand_id, title, description, price, quantity)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 'Product 1', 'Description of product 1', 29.99, 100);

-- Inserindo uma imagem do produto e associando ao produto criado
INSERT INTO product_image (product_id, url)
VALUES (LAST_INSERT_ID(), 'http://example.com/product1.png');

-- Inserindo um tamanho
INSERT INTO size (size)
VALUES ('M');

-- Associando o produto ao tamanho
INSERT INTO product_size (product_id, size_id)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID());

-- Associando o produto ao gênero
INSERT INTO product_genre (product_id, genre_id)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID());
