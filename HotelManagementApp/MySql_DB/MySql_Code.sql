CREATE DATABASE IF NOT EXISTS hotel_booking;
USE hotel_booking;

-- USERS TABLE
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(20)
);

-- HOTELS TABLE
CREATE TABLE hotel (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    location VARCHAR(100),
    description TEXT,
    amenities TEXT,
    image_url VARCHAR(255)
);

-- ROOMS TABLE
CREATE TABLE room (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    hotel_id BIGINT,
    room_type VARCHAR(50),
    room_size VARCHAR(50),
    bed_count INT,
    base_fare DOUBLE,
    ac BOOLEAN,
    available BOOLEAN,
    FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
);

-- BOOKINGS TABLE
CREATE TABLE booking (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    room_id BIGINT,
    check_in_date DATE,
    check_out_date DATE,
    number_of_adults INT,
    number_of_children INT,
    total_fare DOUBLE,
    status VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);

-- REVIEWS TABLE
CREATE TABLE review (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    hotel_id BIGINT,
    rating INT,
    comment TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);


INSERT INTO users (name, email, password, role)
VALUES (
  'Kavin Admin',
  'kavin@example.com',
  '$2a$10$TjZqJZlyRgyP/ZPI8hEMnO.z8epC8AZ1g0nBh6f.2nKpAamV.NT6a',
  'ROLE_ADMIN'
);

INSERT INTO users (name, email, password, role)
VALUES 
('Admin Kavin', 'admin@hotel.com', '$2a$10$5MViHC6Bx6KD0PYcHZD5F.i8GvF0jxVZ3V5sfWzK2AR9abZKJUt7y', 'ROLE_ADMIN'),
('User Kavin', 'user@hotel.com', '$2a$10$5MViHC6Bx6KD0PYcHZD5F.i8GvF0jxVZ3V5sfWzK2AR9abZKJUt7y', 'ROLE_USER');




