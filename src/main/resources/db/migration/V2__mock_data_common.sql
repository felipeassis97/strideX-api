-- Inserting 10 real addresses
INSERT INTO address (street, neighborhood, city, state, country, zipcode, lat, lng)
VALUES
('1600 Amphitheatre Parkway', 'Mountain View', 'Mountain View', 'CA', 'USA', '94043', 37.4220, -122.0841),
('1 Apple Park Way', 'Cupertino', 'Cupertino', 'CA', 'USA', '95014', 37.3349, -122.0090),
('350 5th Ave', 'Midtown', 'New York', 'NY', 'USA', '10118', 40.7484, -73.9857),
('221B Baker Street', 'Marylebone', 'London', 'London', 'UK', 'NW1 6XE', 51.5237, -0.1586),
('4-1-1 Hiyoshi', 'Kohoku-ku', 'Yokohama', 'Kanagawa', 'Japan', '223-8522', 35.5539, 139.6528),
('Piazza del Colosseo, 1', 'Celio', 'Rome', 'Lazio', 'Italy', '00184', 41.8902, 12.4922),
('Plaza de la Constitución', 'Centro Histórico', 'Mexico City', 'CDMX', 'Mexico', '06000', 19.4326, -99.1332),
('Rathausmarkt 1', 'Altstadt', 'Hamburg', 'Hamburg', 'Germany', '20095', 53.5503, 9.9926),
('Plaça de Catalunya', 'Eixample', 'Barcelona', 'Catalonia', 'Spain', '08002', 41.3869, 2.1701),
('100 Parliament St', 'Westminster', 'London', 'London', 'UK', 'SW1A 2BQ', 51.5014, -0.1257);

-- Inserting 15 sneaker brands
INSERT INTO brand (name)
VALUES
('Nike'),
('Adidas'),
('Puma'),
('Reebok'),
('New Balance'),
('Converse'),
('Vans'),
('Asics'),
('Under Armour'),
('Saucony'),
('Fila'),
('Jordan'),
('Dr. Martens'),
('Skechers'),
('LeCoq Sportif');

-- Inserting sneaker genres
INSERT INTO genre (name)
VALUES
('Casual'),
('Athletic'),
('Running'),
('Basketball'),
('Lifestyle'),
('Training'),
('Skateboarding'),
('Outdoor'),
('Fashion'),
('Streetwear');

-- Inserting all possible sizes
INSERT INTO size (us_size, eu_size, br_size, cm_size)
VALUES
    (4.0, 36.0, 34.0, 22.0),
    (4.5, 36.5, 35.0, 22.5),
    (5.0, 37.0, 35.0, 23.0),
    (5.5, 37.5, 36.0, 23.5),
    (6.0, 38.0, 36.0, 24.0),
    (6.5, 39.0, 37.0, 24.5),
    (7.0, 40.0, 38.0, 25.0),
    (7.5, 40.5, 39.0, 25.5),
    (8.0, 41.0, 39.0, 26.0),
    (8.5, 41.5, 40.0, 26.5),
    (9.0, 42.5, 40.0, 27.0),
    (9.5, 43.0, 41.0, 27.5),
    (10.0, 44.0, 42.0, 28.0),
    (10.5, 44.5, 42.5, 28.5),
    (11.0, 45.0, 43.0, 29.0),
    (11.5, 46.0, 44.0, 29.5),
    (12.0, 46.5, 44.0, 30.0),
    (12.5, 47.0, 45.0, 30.5),
    (13.0, 48.0, 46.0, 31.0),
    (13.5, 48.5, 46.5, 31.5),
    (14.0, 49.0, 47.0, 32.0),
    (14.5, 50.0, 48.0, 32.5),
    (15.0, 50.5, 48.0, 33.0);