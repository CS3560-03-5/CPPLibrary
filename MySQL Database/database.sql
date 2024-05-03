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
   studyRoom_Number INTEGER,
   studyRoom_Floor INTEGER,
   bronco_id_booked_by VARCHAR(255),
   capacity INTEGER,
   timeSlot VARCHAR(255),
   availability INT
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

INSERT INTO studyRoom (studyRoom_Number, studyRoom_Floor, bronco_id_booked_by, capacity, timeSlot, availability)
VALUES
(2436, 2, '', 5, '10:00AM', 1),
(2436, 2, '', 5, '10:30AM', 1),
(2436, 2, '', 5, '11:00AM', 1),
(2436, 2, '', 5, '11:30AM', 1),
(2436, 2, '', 5, '12:00PM', 1),
(2436, 2, '', 5, '12:30PM', 1),
(2436, 2, '', 5, '1:00PM', 1),
(2436, 2, '', 5, '1:30PM', 1),
(2436, 2, '', 5, '2:00PM', 1),
(2436, 2, '', 5, '2:30PM', 1),
(2436, 2, '', 5, '3:00PM', 1),
(2436, 2, '', 5, '3:30PM', 1),
(2436, 2, '', 5, '4:00PM', 1),
(2436, 2, '', 5, '4:30PM', 1),
(2436, 2, '', 5, '5:00PM', 1),
(2436, 2, '', 5, '5:30PM', 1),
(2436, 2, '', 5, '6:00PM', 1),
(2436, 2, '', 5, '6:30PM', 1),
(2436, 2, '', 5, '7:00PM', 1),
(2436, 2, '', 5, '7:30PM', 1),
(2436, 2, '', 5, '8:00PM', 1),
(2436, 2, '', 5, '8:30PM', 1),
(2436, 2, '', 5, '9:00PM', 1),
(2436, 2, '', 5, '9:30PM', 1),
(2436, 2, '', 5, '10:00PM', 1),
(2438, 2, '', 5, '10:00AM', 0),
(2438, 2, '', 5, '10:30AM', 1),
(2438, 2, '', 5, '11:00AM', 0),
(2438, 2, '', 5, '11:30AM', 1),
(2438, 2, '', 5, '12:00PM', 0),
(2438, 2, '', 5, '12:30PM', 1),
(2438, 2, '', 5, '1:00PM', 0),
(2438, 2, '', 5, '1:30PM', 1),
(2438, 2, '', 5, '2:00PM', 0),
(2438, 2, '', 5, '2:30PM', 1),
(2438, 2, '', 5, '3:00PM', 0),
(2438, 2, '', 5, '3:30PM', 1),
(2438, 2, '', 5, '4:00PM', 0),
(2438, 2, '', 5, '4:30PM', 1),
(2438, 2, '', 5, '5:00PM', 0),
(2438, 2, '', 5, '5:30PM', 1),
(2438, 2, '', 5, '6:00PM', 0),
(2438, 2, '', 5, '6:30PM', 1),
(2438, 2, '', 5, '7:00PM', 0),
(2438, 2, '', 5, '7:30PM', 1),
(2438, 2, '', 5, '8:00PM', 0),
(2438, 2, '', 5, '8:30PM', 1),
(2438, 2, '', 5, '9:00PM', 0),
(2438, 2, '', 5, '9:30PM', 1),
(2438, 2, '', 5, '10:00PM', 0),
(2440, 2, '', 5, '10:00AM', 1),
(2440, 2, '', 5, '10:30AM', 0),
(2440, 2, '', 5, '11:00AM', 1),
(2440, 2, '', 5, '11:30AM', 0),
(2440, 2, '', 5, '12:00PM', 1),
(2440, 2, '', 5, '12:30PM', 0),
(2440, 2, '', 5, '1:00PM', 1),
(2440, 2, '', 5, '1:30PM', 0),
(2440, 2, '', 5, '2:00PM', 1),
(2440, 2, '', 5, '2:30PM', 0),
(2440, 2, '', 5, '3:00PM', 1),
(2440, 2, '', 5, '3:30PM', 0),
(2440, 2, '', 5, '4:00PM', 1),
(2440, 2, '', 5, '4:30PM', 0),
(2440, 2, '', 5, '5:00PM', 1),
(2440, 2, '', 5, '5:30PM', 0),
(2440, 2, '', 5, '6:00PM', 1),
(2440, 2, '', 5, '6:30PM', 0),
(2440, 2, '', 5, '7:00PM', 1),
(2440, 2, '', 5, '7:30PM', 0),
(2440, 2, '', 5, '8:00PM', 1),
(2440, 2, '', 5, '8:30PM', 0),
(2440, 2, '', 5, '9:00PM', 1),
(2440, 2, '', 5, '9:30PM', 0),
(2440, 2, '', 5, '10:00PM', 1);



