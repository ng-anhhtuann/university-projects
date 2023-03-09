-- Insert row to table format --
INSERT INTO users (userid, username, userphone, useraddress, usernumberborrow, usernumberbuy, userbuyamount, userborrowamount, userborrowing)
VALUES 
  (1, 'John Doe', '123-456-7890', '123 Main St', 0, 0, 0, 0, 0),
  (2, 'Jane Smith', '555-555-5555', '456 Elm St', 2, 3, 50, 30, 1),
  (3, 'Bob Johnson', '987-654-3210', '789 Oak St', 1, 1, 20, 10, 1),
  (4, 'Alice Lee', '111-222-3333', '246 Maple St', 0, 2, 40, 0, 0),
  (5, 'Mark Davis', '444-444-4444', '369 Pine St', 3, 2, 60, 50, 1);
