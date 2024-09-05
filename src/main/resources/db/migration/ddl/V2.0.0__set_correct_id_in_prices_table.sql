-- V2.0.0__set_correct_id_in_prices_table.sql

-- Remove useless `id` column
ALTER TABLE prices
DROP COLUMN id;

-- Set `price_list` as primary key
ALTER TABLE prices
ADD PRIMARY KEY (price_list);