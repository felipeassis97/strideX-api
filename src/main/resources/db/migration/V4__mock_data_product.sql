-- Inserting products and associating them with the created store and brand
INSERT INTO product (store_id, brand_id, title, description, price, quantity)
VALUES
-- Store 1
(1, 1, 'Nike Air Max 270 React', 'Nike Air Max 270 React with modern comfort and style.', 149.99, 50),
(1, 2, 'Adidas Ultraboost 21', 'Adidas Ultraboost 21 offers exceptional cushioning and support.', 179.99, 30),
(1, 3, 'Puma RS-X3', 'Puma RS-X3 features a bold design and supreme comfort.', 129.99, 40),
(1, 4, 'New Balance 990v5', 'New Balance 990v5 combines premium support with classic style.', 199.99, 25),
(1, 5, 'Asics Gel-Kayano 27', 'Asics Gel-Kayano 27 provides advanced cushioning and stability.', 159.99, 60),
(1, 6, 'Converse Chuck Taylor All Star', 'Converse Chuck Taylor All Star is a timeless classic with all-day comfort.', 69.99, 80),
(1, 7, 'Reebok Nano X1', 'Reebok Nano X1 designed for intense workouts and durability.', 139.99, 35),
(1, 8, 'Under Armour HOVR Phantom', 'Under Armour HOVR Phantom offers innovative cushioning technology.', 159.99, 45),
(1, 9, 'Saucony Endorphin Speed', 'Saucony Endorphin Speed is perfect for speed and agility.', 179.99, 20),
(1, 10, 'Brooks Ghost 14', 'Brooks Ghost 14 provides superior cushioning and a smooth ride.', 149.99, 50),

-- Store 2
(2, 11, 'Veja V-10', 'Veja V-10 is known for its sustainable design and stylish comfort.', 129.99, 40),
(2, 12, 'Hoka One One Bondi 7', 'Hoka One One Bondi 7 delivers maximum cushioning and comfort.', 159.99, 30),
(2, 13, 'Merrell Moab 2', 'Merrell Moab 2 is ideal for trails and rugged terrains.', 139.99, 50),
(2, 14, 'Timberland PRO Men 6" Pit Boss', 'Timberland PRO Pit Boss offers durability and support.', 189.99, 20),
(2, 15, 'Clarks Desert Boot', 'Clarks Desert Boot features a classic design with long-lasting comfort.', 129.99, 60),
(2, 1, 'Vans Old Skool', 'Vans Old Skool is known for its iconic style and versatility.', 79.99, 90),
(2, 2, 'Nike Air Max 97', 'Nike Air Max 97 provides retro style with advanced comfort.', 179.99, 50),
(2, 3, 'Adidas NMD R1', 'Adidas NMD R1 features a sleek design with cushioning.', 139.99, 40),
(2, 4, 'Puma Future Rider', 'Puma Future Rider blends retro aesthetics with modern comfort.', 119.99, 30),
(2, 4, 'New Balance 574', 'New Balance 574 combines a classic look with versatile wear.', 99.99, 60),

-- Store 3
(3, 5, 'Asics GT-2000 9', 'Asics GT-2000 9 offers stability and cushioning for a comfortable run.', 159.99, 25),
(3, 5, 'Converse One Star', 'Converse One Star is known for its simple yet stylish design.', 69.99, 50),
(3, 5, 'Reebok Classic Leather', 'Reebok Classic Leather features a timeless design with durability.', 109.99, 30),
(3, 5, 'Under Armour Charged Assert 8', 'Under Armour Charged Assert 8 provides great cushioning and support.', 119.99, 45),
(3, 6, 'Saucony Triumph 18', 'Saucony Triumph 18 offers premium cushioning and support.', 169.99, 20),
(3, 6, 'Brooks Adrenaline GTS 21', 'Brooks Adrenaline GTS 21 provides additional support for stability.', 159.99, 40),
(3, 6, 'Nike Air Zoom Pegasus 38', 'Nike Air Zoom Pegasus 38 is versatile with responsive cushioning.', 139.99, 55),
(3, 6, 'Adidas Pureboost DPR', 'Adidas Pureboost DPR offers a snug fit with a boost midsole.', 129.99, 45),
(3, 6, 'Puma Clyde Court', 'Puma Clyde Court combines performance with style for the court.', 149.99, 35),
(3, 6, 'New Balance Fresh Foam 1080v11', 'New Balance Fresh Foam 1080v11 features plush cushioning and comfort.', 179.99, 30),

-- Store 4
(4, 8, 'Asics Gel-Nimbus 23', 'Asics Gel-Nimbus 23 offers maximum cushioning for long runs.', 169.99, 20),
(4, 8, 'Converse Chuck 70', 'Converse Chuck 70 provides a vintage look with upgraded comfort.', 89.99, 50),
(4, 8, 'Reebok Zig Kinetica', 'Reebok Zig Kinetica offers a futuristic design and responsive cushioning.', 139.99, 40),
(4, 8, 'Under Armour HOVR Sonic', 'Under Armour HOVR Sonic features advanced cushioning for a smooth ride.', 159.99, 25),
(4, 7, 'Saucony Peregrine 11', 'Saucony Peregrine 11 is perfect for trail running with rugged durability.', 149.99, 30),
(4, 7, 'Brooks Launch 8', 'Brooks Launch 8 is built for speed and agility with a responsive feel.', 139.99, 40),
(4, 7, 'Nike React Infinity Run', 'Nike React Infinity Run offers plush cushioning and stability.', 159.99, 50),
(4, 3, 'Adidas Solarboost 19', 'Adidas Solarboost 19 features energizing cushioning for a great run.', 169.99, 25),
(4, 3, 'Puma RS-Fast', 'Puma RS-Fast combines bold design with all-day comfort.', 129.99, 35),
(4, 3, 'New Balance 1080v11', 'New Balance 1080v11 provides exceptional cushioning for long-distance running.', 179.99, 30),

-- Store 5
(5, 1, 'Asics Gel-Kayano 28', 'Asics Gel-Kayano 28 delivers stability and comfort for runners.', 169.99, 20),
(5, 1, 'Converse Run Star Hike', 'Converse Run Star Hike features a rugged design with platform soles.', 119.99, 45),
(5, 1, 'Reebok Floatride Energy 3.0', 'Reebok Floatride Energy 3.0 offers lightweight cushioning and comfort.', 139.99, 35),
(5, 1, 'Under Armour HOVR Machina', 'Under Armour HOVR Machina combines smart technology with cushioning.', 159.99, 30),
(5, 1, 'Saucony Endorphin Pro', 'Saucony Endorphin Pro is designed for speed with carbon-fiber plate technology.', 199.99, 20),
(5, 2, 'Brooks Ghost 13', 'Brooks Ghost 13 offers soft cushioning and smooth transitions.', 149.99, 50),
(5, 2, 'Nike ZoomX Vaporfly NEXT%', 'Nike ZoomX Vaporfly NEXT% delivers unbeatable speed and performance.', 249.99, 15),
(5, 4, 'Adidas Adizero Adios Pro', 'Adidas Adizero Adios Pro features lightweight design and carbon plate.', 229.99, 20),
(5, 4, 'Puma Mirage Sport', 'Puma Mirage Sport offers retro style with modern comfort.', 139.99, 30),
(5, 3, 'New Balance FuelCell Rebel', 'New Balance FuelCell Rebel provides energetic cushioning and lightweight feel.', 159.99, 25),

-- Store 6
(6, 9, 'Asics Gel-Contend 7', 'Asics Gel-Contend 7 provides excellent cushioning and comfort for daily runs.', 119.99, 40),
(6, 9, 'Converse Chuck Taylor All Star Platform', 'Converse Chuck Taylor All Star Platform adds height with classic style.', 79.99, 50),
(6, 5, 'Reebok Royal Glide', 'Reebok Royal Glide combines classic design with modern comfort.', 99.99, 45),
(6, 5, 'Under Armour Charged Bandit 7', 'Under Armour Charged Bandit 7 offers responsive cushioning and support.', 129.99, 35),
(6, 3, 'Saucony Kinvara 12', 'Saucony Kinvara 12 is known for its lightweight and responsive feel.', 139.99, 25),
(6, 2, 'Brooks Glycerin 19', 'Brooks Glycerin 19 offers plush cushioning and an ultra-soft ride.', 159.99, 30),
(6, 3, 'Nike Free RN 5.0', 'Nike Free RN 5.0 provides a natural feel with flexible cushioning.', 129.99, 45),
(6, 1, 'Adidas Pureboost Go', 'Adidas Pureboost Go features responsive cushioning and lightweight design.', 119.99, 40),
(6, 7, 'Puma RS-0', 'Puma RS-0 combines retro design with modern comfort.', 129.99, 35),
(6, 7, 'New Balance 880v11', 'New Balance 880v11 delivers reliable cushioning and support for every run.', 149.99, 30),

-- Store 7
(7, 5, 'Asics Gel-FujiTrabuco 8', 'Asics Gel-FujiTrabuco 8 is perfect for trail running with rugged support.', 159.99, 25),
(7, 6, 'Converse Chuck Taylor All Star High Top', 'Converse Chuck Taylor All Star High Top offers a classic silhouette with added ankle support.', 79.99, 50),
(7, 8, 'Reebok Zig Kinetica II', 'Reebok Zig Kinetica II features a bold design with innovative cushioning.', 149.99, 40),
(7, 11, 'Under Armour HOVR Rise', 'Under Armour HOVR Rise delivers cushioning and support for high-intensity workouts.', 139.99, 35),
(7, 1, 'Saucony Triumph ISO 5', 'Saucony Triumph ISO 5 offers enhanced cushioning and a secure fit.', 179.99, 30),
(7, 13, 'Brooks Beast 20', 'Brooks Beast 20 is designed for overpronators with maximum support.', 169.99, 20),
(7, 3, 'Nike Air Max 90', 'Nike Air Max 90 combines retro style with plush cushioning.', 159.99, 40),
(7, 2, 'Adidas Terrex Swift R2', 'Adidas Terrex Swift R2 provides trail-ready durability and traction.', 139.99, 35),
(7, 11, 'Puma RS-2K', 'Puma RS-2K features a retro aesthetic with modern comfort.', 129.99, 45),
(7, 13, 'New Balance 860v11', 'New Balance 860v11 offers stability and cushioning for a smooth ride.', 159.99, 30),

-- Store 8
(8, 14, 'Asics Gel-Cumulus 23', 'Asics Gel-Cumulus 23 provides a cushioned and smooth running experience.', 159.99, 25),
(8, 11, 'Converse Chuck Taylor All Star 70', 'Converse Chuck Taylor All Star 70 features a vintage design with upgraded materials.', 89.99, 50),
(8, 2, 'Reebok Nano X1 Froning', 'Reebok Nano X1 Froning is built for functional fitness with durability.', 139.99, 40),
(8, 4, 'Under Armour HOVR Phantom 2', 'Under Armour HOVR Phantom 2 offers plush cushioning and energy return.', 159.99, 30),
(8, 5, 'Saucony Ride 14', 'Saucony Ride 14 features a balanced cushioning and comfortable ride.', 149.99, 35),
(8, 3, 'Brooks Hyperion Tempo', 'Brooks Hyperion Tempo is designed for speed and responsiveness.', 159.99, 20),
(8, 2, 'Nike Air Zoom Pegasus 37', 'Nike Air Zoom Pegasus 37 offers responsive cushioning and a secure fit.', 139.99, 40),
(8, 5, 'Adidas Adizero Boston 10', 'Adidas Adizero Boston 10 combines speed with cushioning for race day.', 169.99, 25),
(8, 8, 'Puma RS-X', 'Puma RS-X features a bold design with cushioned comfort.', 129.99, 35),
(8, 8, 'New Balance Fresh Foam Hierro v6', 'New Balance Fresh Foam Hierro v6 provides trail-ready cushioning and grip.', 179.99, 30),

-- Store 9
(9, 7, 'Asics Gel-Quantum 360 6', 'Asics Gel-Quantum 360 6 offers maximum cushioning and support for all-day wear.', 179.99, 20),
(9, 6, 'Converse Chuck Taylor All Star Slip-On', 'Converse Chuck Taylor All Star Slip-On features convenience with classic style.', 69.99, 45),
(9, 5, 'Reebok Floatride Run Fast 2', 'Reebok Floatride Run Fast 2 combines speed and comfort for running.', 139.99, 35),
(9, 9, 'Under Armour HOVR Guardian', 'Under Armour HOVR Guardian provides stability and cushioning for everyday training.', 159.99, 30),
(9, 10, 'Saucony Freedom 4', 'Saucony Freedom 4 offers a responsive and flexible ride with premium cushioning.', 169.99, 25),
(9, 1, 'Brooks Revel 5', 'Brooks Revel 5 features a stylish design with comfortable cushioning.', 129.99, 40),
(9, 10, 'Nike Air Zoom Vomero 15', 'Nike Air Zoom Vomero 15 delivers cushioned comfort and responsiveness.', 159.99, 35),
(9, 1, 'Adidas Terrex Agravic', 'Adidas Terrex Agravic is built for rugged trails with durability and grip.', 149.99, 30),
(9, 10, 'Puma RS-Fast G', 'Puma RS-Fast G combines style with performance for everyday wear.', 139.99, 25),
(9, 4, 'New Balance 840v4', 'New Balance 840v4 offers plush cushioning and support for long-distance runs.', 149.99, 30),

-- Store 10
(10, 5, 'Asics Gel-Kayano Lite 2', 'Asics Gel-Kayano Lite 2 provides a lightweight alternative with premium support.', 159.99, 20),
(10, 2, 'Converse Chuck Taylor All Star Low Top', 'Converse Chuck Taylor All Star Low Top offers a classic design with a low-profile fit.', 69.99, 45),
(10, 7, 'Reebok Nano X2', 'Reebok Nano X2 is built for intense workouts with stability and comfort.', 139.99, 35),
(10, 3, 'Under Armour HOVR Mega', 'Under Armour HOVR Mega features advanced cushioning and support for running.', 159.99, 30),
(10, 7, 'Saucony Endorphin Speed 3', 'Saucony Endorphin Speed 3 combines speed with cushioning for a competitive edge.', 179.99, 25),
(10, 5, 'Brooks Launch GTS 9', 'Brooks Launch GTS 9 offers speed and support with a responsive ride.', 139.99, 40),
(10, 9, 'Nike Air Zoom Streak 7', 'Nike Air Zoom Streak 7 delivers a lightweight and fast feel for races.', 159.99, 25),
(10, 9, 'Adidas Ultraboost Light', 'Adidas Ultraboost Light features lightweight cushioning for a comfortable run.', 179.99, 30),
(10, 1, 'Puma Clyde All Pro', 'Puma Clyde All Pro combines performance with a classic basketball design.', 149.99, 35),
(10, 2, 'New Balance 1080v12', 'New Balance 1080v12 provides plush cushioning and a smooth ride for every run.', 189.99, 20);

-- Inserting product images for all products
INSERT INTO product_image (product_id, url)
VALUES
-- Store 1
(1, 'http://example.com/product1_nike_air_max_270_react.png'),
(2, 'http://example.com/product2_adidas_ultraboost_21.png'),
(3, 'http://example.com/product3_puma_rs_x3.png'),
(4, 'http://example.com/product4_new_balance_990v5.png'),
(5, 'http://example.com/product5_asics_gel_kayano_27.png'),
(6, 'http://example.com/product6_converse_chuck_taylor_all_star.png'),
(7, 'http://example.com/product7_reebok_nano_x1.png'),
(8, 'http://example.com/product8_under_armour_hovr_phantom.png'),
(9, 'http://example.com/product9_saucony_endorphin_speed.png'),
(10, 'http://example.com/product10_brooks_ghost_14.png'),
-- Store 2
(11, 'http://example.com/product11_veja_v10.png'),
(12, 'http://example.com/product12_hoka_one_one_bondi_7.png'),
(13, 'http://example.com/product13_merrell_moab_2_gore_tex.png'),
(14, 'http://example.com/product14_timberland_pro_6_inch_pit_boss.png'),
(15, 'http://example.com/product15_clarks_desert_boot.png'),
(16, 'http://example.com/product16_vans_old_skool.png'),
(17, 'http://example.com/product17_nike_air_max_97.png'),
(18, 'http://example.com/product18_adidas_nmd_r1.png'),
(19, 'http://example.com/product19_puma_future_rider.png'),
(20, 'http://example.com/product20_new_balance_574.png'),
-- Store 3
(21, 'http://example.com/product21_asics_gt_2000_9.png'),
(22, 'http://example.com/product22_converse_one_star.png'),
(23, 'http://example.com/product23_nike_air_force_1.png'),
(24, 'http://example.com/product24_adidas_superstar.png'),
(25, 'http://example.com/product25_puma_clyde.png'),
(26, 'http://example.com/product26_nike_air_max_90.png'),
(27, 'http://example.com/product27_adidas_yeezy_boost_350.png'),
(28, 'http://example.com/product28_puma_suede_classic.png'),
(29, 'http://example.com/product29_new_balance_1080v11.png'),
(30, 'http://example.com/product30_asics_gel_nimbus_23.png'),
-- Store 4
(31, 'http://example.com/product31_vans_authentic.png'),
(32, 'http://example.com/product32_nike_free_run_5.png'),
(33, 'http://example.com/product33_adidas_pureboost.png'),
(34, 'http://example.com/product34_puma_fusion.png'),
(35, 'http://example.com/product35_new_balance_fresh_foam_1080.png'),
(36, 'http://example.com/product36_asics_gt_4000.png'),
(37, 'http://example.com/product37_nike_react_infinity_run.png'),
(38, 'http://example.com/product38_adidas_terrex_agravic.png'),
(39, 'http://example.com/product39_puma_riders.png'),
(40, 'http://example.com/product40_new_balance_860v11.png'),
-- Store 5
(41, 'http://example.com/product41_vans_sk8_hi.png'),
(42, 'http://example.com/product42_nike_zoomx_vaporfly.png'),
(43, 'http://example.com/product43_adidas_stan_smith.png'),
(44, 'http://example.com/product44_puma_ignite.png'),
(45, 'http://example.com/product45_new_balance_520.png'),
(46, 'http://example.com/product46_asics_gel_cumulus_23.png'),
(47, 'http://example.com/product47_nike_react_element_55.png'),
(48, 'http://example.com/product48_adidas_climacool.png'),
(49, 'http://example.com/product49_puma_cell_endura.png'),
(50, 'http://example.com/product50_new_balance_373.png'),
-- Store 6
(51, 'http://example.com/product51_nike_air_max_2021.png'),
(52, 'http://example.com/product52_adidas_pod_s3.1.png'),
(53, 'http://example.com/product53_puma_king.png'),
(54, 'http://example.com/product54_new_balance_997.png'),
(55, 'http://example.com/product55_asics_gel_quantum.png'),
(56, 'http://example.com/product56_nike_zoom_pegasus.png'),
(57, 'http://example.com/product57_adidas_samba.png'),
(58, 'http://example.com/product58_puma_basket.png'),
(59, 'http://example.com/product59_new_balance_5740.png'),
(60, 'http://example.com/product60_asics_gel_kayano_28.png'),
-- Store 7
(61, 'http://example.com/product61_nike_air_max_2021.png'),
(62, 'http://example.com/product62_adidas_ultraboost_21.png'),
(63, 'http://example.com/product63_puma_rs_x3.png'),
(64, 'http://example.com/product64_new_balance_990v5.png'),
(65, 'http://example.com/product65_asics_gel_kayano_27.png'),
(66, 'http://example.com/product66_converse_chuck_taylor_all_star.png'),
(67, 'http://example.com/product67_reebok_nano_x1.png'),
(68, 'http://example.com/product68_under_armour_hovr_phantom.png'),
(69, 'http://example.com/product69_saucony_endorphin_speed.png'),
(70, 'http://example.com/product70_brooks_ghost_14.png'),
-- Store 8
(71, 'http://example.com/product71_veja_v10.png'),
(72, 'http://example.com/product72_hoka_one_one_bondi_7.png'),
(73, 'http://example.com/product73_merrell_moab_2_gore_tex.png'),
(74, 'http://example.com/product74_timberland_pro_6_inch_pit_boss.png'),
(75, 'http://example.com/product75_clarks_desert_boot.png'),
(76, 'http://example.com/product76_vans_old_skool.png'),
(77, 'http://example.com/product77_nike_air_max_97.png'),
(78, 'http://example.com/product78_adidas_nmd_r1.png'),
(79, 'http://example.com/product79_puma_future_rider.png'),
(80, 'http://example.com/product80_new_balance_574.png'),
-- Store 9
(81, 'http://example.com/product81_asics_gt_2000_9.png'),
(82, 'http://example.com/product82_converse_one_star.png'),
(83, 'http://example.com/product83_nike_air_force_1.png'),
(84, 'http://example.com/product84_adidas_superstar.png'),
(85, 'http://example.com/product85_puma_clyde.png'),
(86, 'http://example.com/product86_nike_air_max_90.png'),
(87, 'http://example.com/product87_adidas_yeezy_boost_350.png'),
(88, 'http://example.com/product88_puma_suede_classic.png'),
(89, 'http://example.com/product89_new_balance_1080v11.png'),
(90, 'http://example.com/product90_asics_gel_nimbus_23.png'),
-- Store 10
(91, 'http://example.com/product91_vans_authentic.png'),
(92, 'http://example.com/product92_nike_free_run_5.png'),
(93, 'http://example.com/product93_adidas_pureboost.png'),
(94, 'http://example.com/product94_puma_fusion.png'),
(95, 'http://example.com/product95_new_balance_fresh_foam_1080.png'),
(96, 'http://example.com/product96_asics_gt_4000.png'),
(97, 'http://example.com/product97_nike_react_infinity_run.png'),
(98, 'http://example.com/product98_adidas_terrex_agravic.png'),
(99, 'http://example.com/product99_puma_riders.png'),
(100, 'http://example.com/product100_new_balance_860v11.png');

-- Associating products with random sizes
INSERT INTO product_size (product_id, size_id)
VALUES
-- Product 1 with sizes 1 and 3
(1, 1), (1, 3),
-- Product 2 with size 2
(2, 2),
-- Product 3 with sizes 4 and 5
(3, 4), (3, 5),
-- Product 4 with sizes 6 and 7
(4, 6), (4, 7),
-- Product 5 with size 8
(5, 8),
-- Product 6 with sizes 1, 2, 3, and 4
(6, 1), (6, 2), (6, 3), (6, 4),
-- Product 7 with size 5
(7, 5),
-- Product 8 with sizes 6, 7, 8, and 9
(8, 6), (8, 7), (8, 8), (8, 9),
-- Product 9 with sizes 1 and 10
(9, 1), (9, 10),
-- Product 10 with size 3
(10, 3),
-- Product 11 with sizes 4, 5, 6, and 7
(11, 4), (11, 5), (11, 6), (11, 7),
-- Product 12 with sizes 1 and 8
(12, 1), (12, 8),
-- Product 13 with sizes 2 and 5
(13, 2), (13, 5),
-- Product 14 with size 9
(14, 9),
-- Product 15 with sizes 1, 2, and 4
(15, 1), (15, 2), (15, 4),
-- Product 16 with sizes 3, 6, and 7
(16, 3), (16, 6), (16, 7),
-- Product 17 with size 10
(17, 10),
-- Product 18 with sizes 2, 5, and 8
(18, 2), (18, 5), (18, 8),
-- Product 19 with size 1
(19, 1),
-- Product 20 with sizes 4, 6, and 9
(20, 4), (20, 6), (20, 9),
-- Product 21 with sizes 2 and 7
(21, 2), (21, 7),
-- Product 22 with sizes 3 and 5
(22, 3), (22, 5),
-- Product 23 with sizes 1, 8, and 9
(23, 1), (23, 8), (23, 9),
-- Product 24 with size 4
(24, 4),
-- Product 25 with sizes 6 and 10
(25, 6), (25, 10),
-- Product 26 with size 7
(26, 7),
-- Product 27 with sizes 1, 2, and 5
(27, 1), (27, 2), (27, 5),
-- Product 28 with sizes 3 and 8
(28, 3), (28, 8),
-- Product 29 with sizes 4, 5, and 6
(29, 4), (29, 5), (29, 6),
-- Product 30 with size 9
(30, 9),
-- Product 31 with sizes 2, 3, and 10
(31, 2), (31, 3), (31, 10),
-- Product 32 with sizes 1 and 6
(32, 1), (32, 6),
-- Product 33 with sizes 5 and 7
(33, 5), (33, 7),
-- Product 34 with size 8
(34, 8),
-- Product 35 with sizes 2, 4, and 10
(35, 2), (35, 4), (35, 10),
-- Product 36 with sizes 1, 3, and 5
(36, 1), (36, 3), (36, 5),
-- Product 37 with sizes 6 and 9
(37, 6), (37, 9),
-- Product 38 with size 7
(38, 7),
-- Product 39 with sizes 2 and 4
(39, 2), (39, 4),
-- Product 40 with sizes 1, 8, and 10
(40, 1), (40, 8), (40, 10),
-- Product 41 with sizes 3, 5, and 7
(41, 3), (41, 5), (41, 7),
-- Product 42 with sizes 2, 6, and 8
(42, 2), (42, 6), (42, 8),
-- Product 43 with sizes 4 and 10
(43, 4), (43, 10),
-- Product 44 with sizes 1 and 3
(44, 1), (44, 3),
-- Product 45 with sizes 5, 6, and 9
(45, 5), (45, 6), (45, 9),
-- Product 46 with size 7
(46, 7),
-- Product 47 with sizes 1, 4, and 8
(47, 1), (47, 4), (47, 8),
-- Product 48 with sizes 2 and 10
(48, 2), (48, 10),
-- Product 49 with sizes 3, 5, and 9
(49, 3), (49, 5), (49, 9),
-- Product 50 with sizes 4 and 7
(50, 4), (50, 7),
-- Product 51 with sizes 1, 2, and 6
(51, 1), (51, 2), (51, 6),
-- Product 52 with sizes 3, 8, and 10
(52, 3), (52, 8), (52, 10),
-- Product 53 with size 4
(53, 4),
-- Product 54 with sizes 5, 7, and 8
(54, 5), (54, 7), (54, 8),
-- Product 55 with sizes 1 and 9
(55, 1), (55, 9),
-- Product 56 with sizes 2, 3, and 6
(56, 2), (56, 3), (56, 6),
-- Product 57 with size 8
(57, 8),
-- Product 58 with sizes 4, 5, and 10
(58, 4), (58, 5), (58, 10),
-- Product 59 with size 6
(59, 6),
-- Product 60 with sizes 1 and 7
(60, 1), (60, 7),
-- Product 61 with sizes 2, 8, and 10
(61, 2), (61, 8), (61, 10),
-- Product 62 with sizes 3 and 5
(62, 3), (62, 5),
-- Product 63 with sizes 4, 6, and 9
(63, 4), (63, 6), (63, 9),
-- Product 64 with sizes 1, 7, and 10
(64, 1), (64, 7), (64, 10),
-- Product 65 with sizes 2 and 4
(65, 2), (65, 4),
-- Product 66 with sizes 5 and 9
(66, 5), (66, 9),
-- Product 67 with size 6
(67, 6),
-- Product 68 with sizes 1, 2, and 8
(68, 1), (68, 2), (68, 8),
-- Product 69 with sizes 3, 4, and 7
(69, 3), (69, 4), (69, 7),
-- Product 70 with sizes 5 and 10
(70, 5), (70, 10),
-- Product 71 with sizes 1, 6, and 9
(71, 1), (71, 6), (71, 9),
-- Product 72 with sizes 2, 7, and 8
(72, 2), (72, 7), (72, 8),
-- Product 73 with sizes 3 and 4
(73, 3), (73, 4),
-- Product 74 with sizes 5, 8, and 9
(74, 5), (74, 8), (74, 9),
-- Product 75 with size 6
(75, 6),
-- Product 76 with sizes 1, 4, and 10
(76, 1), (76, 4), (76, 10),
-- Product 77 with sizes 2, 5, and 7
(77, 2), (77, 5), (77, 7),
-- Product 78 with sizes 3 and 9
(78, 3), (78, 9),
-- Product 79 with sizes 4 and 6
(79, 4), (79, 6),
-- Product 80 with sizes 1, 8, and 10
(80, 1), (80, 8), (80, 10),
-- Product 81 with sizes 2, 4, and 5
(81, 2), (81, 4), (81, 5),
-- Product 82 with sizes 3 and 7
(82, 3), (82, 7),
-- Product 83 with sizes 4, 6, and 8
(83, 4), (83, 6), (83, 8),
-- Product 84 with size 9
(84, 9),
-- Product 85 with sizes 1, 2, and 10
(85, 1), (85, 2), (85, 10),
-- Product 86 with sizes 3, 4, and 7
(86, 3), (86, 4), (86, 7),
-- Product 87 with sizes 5, 6, and 9
(87, 5), (87, 6), (87, 9),
-- Product 88 with sizes 1, 7, and 8
(88, 1), (88, 7), (88, 8),
-- Product 89 with sizes 2, 5, and 10
(89, 2), (89, 5), (89, 10),
-- Product 90 with sizes 3 and 6
(90, 3), (90, 6),
-- Product 91 with sizes 4, 7, and 9
(91, 4), (91, 7), (91, 9),
-- Product 92 with sizes 1, 5, and 8
(92, 1), (92, 5), (92, 8),
-- Product 93 with sizes 2 and 4
(93, 2), (93, 4),
-- Product 94 with sizes 3 and 10
(94, 3), (94, 10),
-- Product 95 with sizes 1, 6, and 9
(95, 1), (95, 6), (95, 9),
-- Product 96 with sizes 2, 5, and 8
(96, 2), (96, 5), (96, 8),
-- Product 97 with sizes 3, 4, and 7
(97, 3), (97, 4), (97, 7),
-- Product 98 with sizes 1, 9, and 10
(98, 1), (98, 9), (98, 10),
-- Product 99 with sizes 2, 6, and 8
(99, 2), (99, 6), (99, 8),
-- Product 100 with sizes 4, 5, and 10
(100, 4), (100, 5), (100, 10);

-- Associating products 1 to 100 with random genres (1 to 10)
INSERT INTO product_genre (product_id, genre_id)
VALUES
-- Product 1 with genres 1 and 2
(1, 1), (1, 2),
-- Product 2 with genre 3
(2, 3),
-- Product 3 with genres 4 and 5
(3, 4), (3, 5),
-- Product 4 with genres 6 and 7
(4, 6), (4, 7),
-- Product 5 with genre 8
(5, 8),
-- Product 6 with genres 1, 2, and 3
(6, 1), (6, 2), (6, 3),
-- Product 7 with genre 4
(7, 4),
-- Product 8 with genres 5, 6, and 7
(8, 5), (8, 6), (8, 7),
-- Product 9 with genre 8
(9, 8),
-- Product 10 with genres 1 and 9
(10, 1), (10, 9),
-- Product 11 with genres 2 and 3
(11, 2), (11, 3),
-- Product 12 with genres 4, 5, and 6
(12, 4), (12, 5), (12, 6),
-- Product 13 with genre 7
(13, 7),
-- Product 14 with genres 8 and 9
(14, 8), (14, 9),
-- Product 15 with genres 1 and 10
(15, 1), (15, 10),
-- Product 16 with genres 2, 3, and 5
(16, 2), (16, 3), (16, 5),
-- Product 17 with genre 4
(17, 4),
-- Product 18 with genres 6 and 7
(18, 6), (18, 7),
-- Product 19 with genres 1, 2, and 8
(19, 1), (19, 2), (19, 8),
-- Product 20 with genre 3
(20, 3),
-- Product 21 with genres 4, 5, and 10
(21, 4), (21, 5), (21, 10),
-- Product 22 with genre 6
(22, 6),
-- Product 23 with genres 1, 2, and 7
(23, 1), (23, 2), (23, 7),
-- Product 24 with genres 3 and 9
(24, 3), (24, 9),
-- Product 25 with genres 4, 5, and 8
(25, 4), (25, 5), (25, 8),
-- Product 26 with genre 10
(26, 10),
-- Product 27 with genres 1 and 3
(27, 1), (27, 3),
-- Product 28 with genres 2 and 4
(28, 2), (28, 4),
-- Product 29 with genres 5, 6, and 8
(29, 5), (29, 6), (29, 8),
-- Product 30 with genres 7 and 10
(30, 7), (30, 10),
-- Product 31 with genres 1 and 2
(31, 1), (31, 2),
-- Product 32 with genres 3 and 5
(32, 3), (32, 5),
-- Product 33 with genre 6
(33, 6),
-- Product 34 with genres 4, 7, and 8
(34, 4), (34, 7), (34, 8),
-- Product 35 with genre 9
(35, 9),
-- Product 36 with genres 1 and 3
(36, 1), (36, 3),
-- Product 37 with genres 2, 4, and 10
(37, 2), (37, 4), (37, 10),
-- Product 38 with genre 5
(38, 5),
-- Product 39 with genres 6, 8, and 9
(39, 6), (39, 8), (39, 9),
-- Product 40 with genre 7
(40, 7),
-- Product 41 with genres 1 and 2
(41, 1), (41, 2),
-- Product 42 with genres 3, 4, and 10
(42, 3), (42, 4), (42, 10),
-- Product 43 with genres 5 and 7
(43, 5), (43, 7),
-- Product 44 with genres 6 and 8
(44, 6), (44, 8),
-- Product 45 with genre 9
(45, 9),
-- Product 46 with genres 1, 3, and 5
(46, 1), (46, 3), (46, 5),
-- Product 47 with genres 2 and 6
(47, 2), (47, 6),
-- Product 48 with genre 4
(48, 4),
-- Product 49 with genres 7, 8, and 10
(49, 7), (49, 8), (49, 10),
-- Product 50 with genres 1 and 9
(50, 1), (50, 9),
-- Product 51 with genres 2 and 4
(51, 2), (51, 4),
-- Product 52 with genres 3, 6, and 7
(52, 3), (52, 6), (52, 7),
-- Product 53 with genre 5
(53, 5),
-- Product 54 with genres 1, 8, and 10
(54, 1), (54, 8), (54, 10),
-- Product 55 with genres 2 and 9
(55, 2), (55, 9),
-- Product 56 with genres 3, 4, and 6
(56, 3), (56, 4), (56, 6),
-- Product 57 with genre 7
(57, 7),
-- Product 58 with genres 1, 2, and 5
(58, 1), (58, 2), (58, 5),
-- Product 59 with genres 3, 8, and 9
(59, 3), (59, 8), (59, 9),
-- Product 60 with genres 4 and 10
(60, 4), (60, 10),
-- Product 61 with genres 1, 6, and 8
(61, 1), (61, 6), (61, 8),
-- Product 62 with genres 2, 4, and 9
(62, 2), (62, 4), (62, 9),
-- Product 63 with genres 3 and 10
(63, 3), (63, 10),
-- Product 64 with genres 5 and 7
(64, 5), (64, 7),
-- Product 65 with genre 6
(65, 6),
-- Product 66 with genres 1, 2, and 4
(66, 1), (66, 2), (66, 4),
-- Product 67 with genres 3 and 5
(67, 3), (67, 5),
-- Product 68 with genre 7
(68, 7),
-- Product 69 with genres 2, 6, and 10
(69, 2), (69, 6), (69, 10),
-- Product 70 with genres 4 and 8
(70, 4), (70, 8),
-- Product 71 with genres 1, 3, and 9
(71, 1), (71, 3), (71, 9),
-- Product 72 with genres 2, 5, and 7
(72, 2), (72, 5), (72, 7),
-- Product 73 with genres 6 and 8
(73, 6), (73, 8),
-- Product 74 with genre 10
(74, 10),
-- Product 75 with genres 1, 2, and 4
(75, 1), (75, 2), (75, 4),
-- Product 76 with genres 3, 5, and 6
(76, 3), (76, 5), (76, 6),
-- Product 77 with genre 7
(77, 7),
-- Product 78 with genres 1, 8, and 9
(78, 1), (78, 8), (78, 9),
-- Product 79 with genres 2 and 3
(79, 2), (79, 3),
-- Product 80 with genres 4, 6, and 10
(80, 4), (80, 6), (80, 10),
-- Product 81 with genres 5 and 8
(81, 5), (81, 8),
-- Product 82 with genre 1
(82, 1),
-- Product 83 with genres 2, 3, and 5
(83, 2), (83, 3), (83, 5),
-- Product 84 with genres 4 and 6
(84, 4), (84, 6),
-- Product 85 with genres 1, 7, and 9
(85, 1), (85, 7), (85, 9),
-- Product 86 with genre 2
(86, 2),
-- Product 87 with genres 3, 5, and 10
(87, 3), (87, 5), (87, 10),
-- Product 88 with genres 4 and 7
(88, 4), (88, 7),
-- Product 89 with genres 1, 6, and 8
(89, 1), (89, 6), (89, 8),
-- Product 90 with genres 2 and 9
(90, 2), (90, 9),
-- Product 91 with genres 3, 4, and 7
(91, 3), (91, 4), (91, 7),
-- Product 92 with genres 1 and 10
(92, 1), (92, 10),
-- Product 93 with genres 2, 6, and 8
(93, 2), (93, 6), (93, 8),
-- Product 94 with genres 3 and 9
(94, 3), (94, 9),
-- Product 95 with genres 4 and 5
(95, 4), (95, 5),
-- Product 96 with genres 1, 2, and 6
(96, 1), (96, 2), (96, 6),
-- Product 97 with genres 3, 7, and 10
(97, 3), (97, 7), (97, 10),
-- Product 98 with genres 4 and 9
(98, 4), (98, 9),
-- Product 99 with genres 1, 5, and 8
(99, 1), (99, 5), (99, 8),
-- Product 100 with genres 2, 3, and 6
(100, 2), (100, 3), (100, 6);
