DROP DATABASE administer_exams;
CREATE DATABASE IF NOT EXISTS administer_exams;
USE administer_exams;

CREATE TABLE Department(
	DepartmentID INT,
    DepartmentName VARCHAR(50)
);

CREATE TABLE `Position`(
	PositiontID INT,
    PositionName VARCHAR(50)
);

CREATE TABLE `Account`(
	AccountID INT,
    Email VARCHAR(50),
    UserName VARCHAR(50),
    FullName VARCHAR(50),
    DepartmentID INT,
    PositionID INT,
    CreateDate DATE
);

CREATE TABLE `Group`(
	GroupID INT,
    GroupName VARCHAR(50),
    CreatorID INT,
    CreateDate DATE
);

CREATE TABLE GroupAccount(
	GroupID INT,
    AccountID INT,
    JoinDate DATE
);

CREATE TABLE TypeQuestion(
	TypeID INT,
    TypeName VARCHAR(50)
);

CREATE TABLE CategoryQuestion(
	CategoryID INT,
    CategoryName VARCHAR(50)
);

CREATE TABLE Question(
	QuestionID INT,
    Content VARCHAR(50),
    CategoryID INT,
    TypeID INT,
    CreatorID INT,
    CreateDate DATE
);

CREATE TABLE Answer(
	AnswerID INT,
    Content VARCHAR(50),
    QuestionID INT,
    isCorrect VARCHAR(50)
);

CREATE TABLE Exam(
	ExamID INT,
    `Code` VARCHAR(50),
    Title VARCHAR(50),
    CategoryID INT,
    Duration DATE,
    CreatorID INT,
    CreateDate DATE
);