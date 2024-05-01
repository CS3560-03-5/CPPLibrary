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

CREATE TABLE availability_slots (
    slot_id INT PRIMARY KEY AUTO_INCREMENT,
    studyRoom_id INT,
    start_time VARCHAR(255),
    is_available BOOLEAN,
    FOREIGN KEY (studyRoom_id) REFERENCES studyRoom(studyRoom_id)
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
INSERT INTO students (student_id, student_name, bronco_id, student_major, student_email)
VALUES 
    (1, 'Brandon Chang', '015817191', 'Computer Science', 'bkchang@cpp.edu');
  
-- Inserting values into students table (Sample)
INSERT INTO books (book_id, title, author, publication_date, ISBN, available_copies, subject)
VALUES 
    (2, 'Introduction to the Theory of Computation', 'Michael Sipser', '2012-02-22', '978-0262035613', 2, 'Computer Science');
    
-- Inserting values into the studyRoom table (Sample)
INSERT INTO studyRoom (studyRoom_id, studyRoom_Number, studyRoom_Floor, availability, capacity)
VALUES 
    (2, 2436, 2, 'Available', 3);

-- Inserting into availability_slots

INSERT INTO availability_slots (start_time, is_available)
VALUES
    ("10:30am", TRUE),
    ("11:00am", TRUE),
    ("11:30am", TRUE),
    ("12:00am", TRUE),
    ("12:30am", TRUE),
    ("1:00pm", TRUE),
    ("1:30pm", TRUE),
    ("2:00pm", TRUE),
    ("2:30pm", TRUE),
    ("3:00pm", TRUE),
    ("3:30pm", TRUE),
    ("4:00pm", TRUE),
    ("4:30pm", TRUE),
    ("5:00apm", TRUE),
    ("5:30pm", TRUE),
    ("6:00pm", TRUE),
    ("6:30pm", TRUE),
    ("7:00pm", TRUE),
    ("7:30pm", TRUE),
    ("8:00pm", TRUE),
    ("8:30pm", TRUE),
    ("9:00pm", TRUE),
    ("9:30pm", TRUE),
    ("10:00pm", TRUE),
    ("10:30pm", TRUE),

