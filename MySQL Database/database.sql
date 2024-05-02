-- Creating a table for students
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    bronco_id varchar(255),
    student_name VARCHAR(255),
    student_major VARCHAR(255),
    student_email VARCHAR(255),
    password VARCHAR(255)
);

-- Creating a table for books
CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication_date DATE,
    ISBN VARCHAR(20),
    available_copies INT,
    subject VARCHAR(255)
);

-- Creating a table for studyrooms
CREATE TABLE studyRoom (
    studyRoom_id INT PRIMARY KEY,
    studyRoom_Number INT,
    studyRoom_Floor INT,
    --availability VARCHAR(255),
    bronco_id_booked_by VARCHAR(255),
    capacity INT
);



-- Creating a table for librarian
Create Table librarian(
	librarian_id INT PRIMARY KEY,
    librarian_name VARCHAR(255),
    librarian_email VARCHAR(255),
    librarian_phoneNumber VARCHAR(255),
    subject_specialties VARCHAR(255),
    guiudes VARCHAR(255)
);

-- Creating a table for requested books by a student (cart)
CREATE TABLE requestedBooks (
    request_id INT PRIMARY KEY,
    student_id INT,
    book_id INT,
    request_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- Inserting values into students table (Sample)
INSERT INTO students (student_id, student_name, bronco_id, student_major, student_email, password)
VALUES 
    (1, 'Brandon Chang', '015817191', 'Computer Science', 'bkchang@cpp.edu', 'admin');
  
-- Inserting values into students table (Sample)
INSERT INTO books (book_id, title, author, publication_date, ISBN, available_copies, subject)
VALUES 
    (2, 'Introduction to the Theory of Computation', 'Michael Sipser', '2012-02-22', '978-0262035613', 2, 'Computer Science');
    
-- Inserting values into the studyRoom table (Sample)
INSERT INTO studyRoom (studyRoom_id, studyRoom_Number, studyRoom_Floor, availability, capacity)
VALUES 
    (2, 2436, 2, 'Available', 3);

NSERT INTO studyRoom (studyRoom_id, studyRoom_Number, studyRoom_Floor, availability, capacity)
VALUES 
    (2, 2436, 2, 'Available', 3),
    (3, 2438, 2, 'Available', 3),
    (4, 2440, 2, 'Available', 3),
    (5, 2442, 2, 'Available', 3),
    (6, 2442, 2, 'Available', 3),
    (7, 2442, 2, 'Available', 3),
    (8, 3134, 3, 'Available', 3),
    (9, 3136, 3, 'Available', 4),
    (10, 3244, 3, 'Available', 6),
    (11, 3246, 3, 'Available', 6),
    (12, 3312, 3, 'Available', 4),
    (13, 3314, 3, 'Available', 4),
    (14, 3316, 3, 'Available', 4),
    (15, 3343, 3, 'Available', 4),
    (16, 3345, 3, 'Available', 4),
    (17, 3642, 3, 'Available', 4),
    (18, 3644, 3, 'Available', 4),
    (19, 3735, 3, 'Available', 3),
    (20, 3737, 3, 'Available', 4),
    (21, 3913, 3, 'Available', 4),
    (22, 3915, 3, 'Available', 4),
    (23, 3917, 3, 'Available', 4),
    (24, 3919, 3, 'Available', 6),
    (25, 3921, 3, 'Available', 4),
    (26, 3923, 3, 'Available', 4),
    (27, 3927, 3, 'Available', 6),
    (28, 3929, 3, 'Available', 6),
    (29, 4134, 4, 'Available', 9),
    (30, 4136, 4, 'Available', 6),
    (31, 4823, 4, 'Available', 9),
    (32, 5439, 5, 'Available', 9),
    (33, 5441, 5, 'Available', 9),
    (34, 5927, 5, 'Available', 4),
    (35, 5929, 5, 'Available', 4),
    (36, 5931, 5, 'Available', 4),
    (37, 5933, 5, 'Available', 4),
    (38, 6439, 6, 'Available', 9),
    (39, 6439, 6, 'Available', 9),
    (40, 6441, 6, 'Available', 9);



