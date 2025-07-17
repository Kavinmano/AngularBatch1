use hotel_java;

INSERT INTO categories (created_at, name, price, updated_at)
VALUES 
  (NOW(), 'Single Room', '1500', NOW()),
  (NOW(), 'Double Room', '2500', NOW()),
  (NOW(), 'Deluxe Room', '3500', NOW()),
  (NOW(), 'Suite', '5000', NOW()),
  (NOW(), 'Presidential Suite', '10000', NOW());
  
  
INSERT INTO clients (address, created_at, email, identification, name, telephone, updated_at)
VALUES 
  ('123 Main St, New York, NY', NOW(), 'john.doe@example.com', 'ID123456789', 'John Doe', '9876543210', NOW()),
  ('456 Park Ave, Los Angeles, CA', NOW(), 'jane.smith@example.com', 'ID987654321', 'Jane Smith', '9123456780', NOW()),
  ('789 Oak Lane, Chicago, IL', NOW(), 'mike.jones@example.com', 'ID456789123', 'Mike Jones', '9988776655', NOW()),
  ('101 Pine St, Houston, TX', NOW(), 'emma.watson@example.com', 'ID321654987', 'Emma Watson', '9112233445', NOW()),
  ('202 Maple Rd, Phoenix, AZ', NOW(), 'liam.brown@example.com', 'ID654123789', 'Liam Brown', '9001122334', NOW());
  
  
  INSERT INTO reservations (client_id, created_at, date, no_days, no_persons, room_id, updated_at)
VALUES 
  (1, NOW(), '2025-07-20', 3, 2, 1, NOW()),
  (2, NOW(), '2025-07-22', 2, 1, 2, NOW()),
  (3, NOW(), '2025-07-25', 5, 4, 3, NOW()),
  (4, NOW(), '2025-07-27', 1, 2, 4, NOW()),
  (5, NOW(), '2025-07-30', 4, 3, 5, NOW());


INSERT INTO rooms (category_id, created_at, floor, is_view, name, no_places, note, updated_at)
VALUES 
  (1, NOW(), 1, 1, 'Room 101', 2, 'Near reception, city view', NOW()),
  (2, NOW(), 2, 0, 'Room 202', 3, 'No view, quiet zone', NOW()),
  (3, NOW(), 3, 1, 'Room 303', 4, 'Balcony with garden view', NOW()),
  (4, NOW(), 4, 1, 'Room 404', 2, 'Top floor, sea view', NOW()),
  (5, NOW(), 5, 0, 'Room 505', 5, 'Presidential suite, no direct view', NOW());
