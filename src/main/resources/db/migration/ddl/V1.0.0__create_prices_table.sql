-- V1.0.0__create_prices_table.sql

-- Create prices table
CREATE TABLE prices (
    id UUID PRIMARY KEY,
    brand_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list INT NOT NULL,
    product_id INT NOT NULL,
    priority INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    curr VARCHAR(3) NOT NULL
);

-- Create index for faster queries
CREATE INDEX idx_prices_brand_product_dates
ON prices (brand_id, product_id, start_date, end_date);
