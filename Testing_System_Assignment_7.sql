-- q 1

USE `administer_exams`;
DROP TRIGGER IF EXISTS trigger_1;
DELIMITER $$
CREATE TRIGGER trigger_1
	BEFORE INSERT ON `question`
    FOR EACH ROW
		BEGIN
			IF  NEW.CreateDate > now() THEN
				set NEW.CreateDate = now();
				END IF;
		END $$
DELIMITER ;

INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java Naang cao'	,	1		,   '1'			,   '1'		,'2030-04-05');

SELECT *
FROM `QUESTION`;

-- q2
-- phải xoá TRIGGER 1 đi mới chạy được TRIGGER 2
DROP TRIGGER IF EXISTS trigger_2;
DELIMITER $$
CREATE TRIGGER trigger_2
	BEFORE INSERT ON `question`
    FOR EACH ROW
		BEGIN
			IF  NEW.CreateDate > now() THEN
				SIGNAL SQLSTATE '12345' -- 10001 -> 999999
                SET MESSAGE_TEXT = "lỗi CreatDate không thể lớn hơn thời gian hiện tại";
			END IF;
		END $$
DELIMITER ;

INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java Naang cao'	,	1		,   '1'			,   '1'		,'2030-04-05');

SELECT *
FROM `QUESTION`;

-- q3

DROP TRIGGER IF EXISTS trigger_4;
DELIMITER $$
CREATE TRIGGER trigger_4
	BEFORE DELETE ON `Question`
    FOR EACH ROW
		BEGIN
			DELETE
            FROM	`Answer`
            WHERE	QuestionID = OLD.QuestionID;
		END $$
DELIMITER ;
SET foreign_key_checks = 0;
DELETE
FROM	`Question`
WHERE	QuestionID = 2;
SELECT	*
FROM	`Answer`;
-- --------

-- Question 1: Tạo Trigger không cho phép người dùngv nhập vào Group có ngày tạo trước một năm
DROP TRIGGER IF EXISTS trigger_Group;
DELIMITER $$
CREATE TRIGGER trigger_Group
	BEFORE INSERT ON `Group`
    FOR EACH ROW
		BEGIN
			IF  NEW.CreateDate < (date_sub(now)) THEN
				SIGNAL SQLSTATE '12347' 
                SET MESSAGE_TEXT = "Không truy cập được";
			END IF;
		END $$
DELIMITER ;

INSERT INTO `Group`	(GroupName				, CreatorID		, CreateDate )
VALUES 				(N'Testing System 123'		,   1			,'2019-10-05');
SELECT *
FROM `Group`;

-- Question 4
DROP TRIGGER IF EXISTS trigger_4;
DELIMITER $$
CREATE TRIGGER trigger_4
BEFORE UPDATE ON Question
FOR EACH ROW
	BEGIN
		IF OLD.TypeID = 1 THEN
			   SIGNAL SQLSTATE '12344' --
               SET MESSAGE_TEXT = " ko cho phep update "; 
            END IF;
	END $$
DELIMITER ;
UPDATE Question
SET Content = 'test123'
WHERE QuestionID = 1;
SELECT * FROM question;


-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS trigger_1year_ago;
DELIMITER $$
		CREATE TRIGGER trigger_1year_ago
        BEFORE INSERT ON `Group`
        FOR EACH ROW
        BEGIN
			DECLARE v_Timestamp DATETIME;
            SET v_Timestamp = (DATE_SUB(NOW(), INTERVAL 1 YEAR));
			IF NEW.CreateDate < v_Timestamp THEN
			   SIGNAL SQLSTATE '12344' --
               SET MESSAGE_TEXT = " Time Input Error "; 
            END IF;
        END $$
DELIMITER ;

INSERT INTO `Group`	(GroupName				, CreatorID		, CreateDate )
VALUES 				(N'Testing System BASE'		,   1			,'2020-10-05');
SELECT *
FROM `Group`;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"

DROP TRIGGER IF EXISTS verify_stop_input_on_DepartmentName_of_Sale;
DELIMITER $$
CREATE TRIGGER verify_stop_input_on_DepartmentName_of_Sale
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF NEW.DepartmentID = 2 THEN
			SIGNAL SQLSTATE '12349'
			SET MESSAGE_TEXT = " Sale cannot add more use "; 
		END IF;
	END $$
DELIMITER ;

INSERT INTO	`Account`(Email							,UserName			,FullName				,DepartmentID 	,PositionID	,CreateDate  )
VALUES 				 ('sieunhanquansiphong@gmail.com'	, 'sieunhan'		,'Nguyen Sieu Nhan'		,   '2'			,   '1'		,'2021-09-18');
				
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS verify_count_user_of_group;
DELIMITER $$
CREATE TRIGGER verify_count_user_of_group
BEFORE INSERT ON GroupAccount
FOR EACH ROW
	BEGIN
		DECLARE var_CountAccountID TINYINT;
        SELECT	count(GA.AccountID) INTO var_CountAccountID
        FROM	GroupAccount AS GA
        GROUP BY GA.GroupID;
		IF 		(var_CountGroupID > 5) THEN
			SIGNAL SQLSTATE '12245'
			SET MESSAGE_TEXT = " Can't add more User into this group "; 
		END IF;
    END $$
DELIMITER ;

SET foreign_key_checks = 0;
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	'1'		,    '11'		,'2021-09-18');
SELECT 	*
FROM	`GroupAccount`;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS verify_question_max10_of_exam;
DELIMITER $$
CREATE TRIGGER verify_question_max10_of_exam
BEFORE INSERT ON ExamQuestion
FOR EACH ROW
	BEGIN
		DECLARE var_CountQuestionID TINYINT;
        SELECT	count(EQ.QuestionID) INTO var_CountQuestionID
        FROM	ExamQuestion AS EQ
        GROUP BY EQ.ExamID;
		IF 		(var_CountQuestionID > 10) THEN
			SIGNAL SQLSTATE '12245'
			SET MESSAGE_TEXT = " Can't add more question into this exam "; 
		END IF;
    END $$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó

INSERT INTO	`Account`(Email				,UserName	,FullName				,DepartmentID 	,PositionID	,CreateDate)
VALUES 				('admin@gmail.com'	,'Bi An'	,'Nguyen BI DANH'		,   '7'			,   '1'		,'2021-09-18');

DROP TRIGGER IF EXISTS update_account_table;
DELIMITER $$
CREATE TRIGGER update_account_table
BEFORE DELETE ON `Account`
FOR EACH ROW
	BEGIN
		IF OLD.Email = 'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12222'
			SET MESSAGE_TEXT = " Cant delete this Account Admin "; 
		END IF;
    END $$
DELIMITER ;

DELETE	
FROM	`Account`
Where	Email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS set_department_wattingDepartment;
DELIMITER $$
CREATE TRIGGER set_department_wattingDepartment
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		DECLARE var_watting_Department VARCHAR(50);
        SELECT	D.DepartmentName INTO var_watting_Department
        FROM	DepartmentID AS D;
		IF 		(NEW.DepartmentID IS NULL) THEN
				SET NEW.DepartmentID = 11 AND DepartmentName = 'Waiting Department';
		END IF;
    END $$
DELIMITER ;

INSERT INTO	`Account`(Email							,UserName			,FullName		,PositionID		,CreateDate  )
VALUES 				 ('phamnhatvuongn@gmail.com'	, 'bac Vuong'		,'Pham Nhat Vuong'	,   '1'			,'2021-09-18');
	
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.

DROP TRIGGER IF EXISTS var_answer__for_question;
DELIMITER $$
CREATE TRIGGER var_answer__for_question
BEFORE INSERT ON `Answer`
FOR EACH ROW
	BEGIN
		DECLARE v_CountAnsInQUes TINYINT;
		DECLARE v_CountAnsIsCorrects TINYINT;
        
		SELECT		count(A.AnswerID) INTO v_CountAnsInQUes 
        FROM 		answer A
        GROUP BY	A.QuestionID = NEW.QuestionID;
        
		SELECT		count(1) INTO v_CountAnsIsCorrects
        FROM 		answer A
        WHERE 		A.QuestionID = NEW.QuestionID AND A.isCorrect = NEW.isCorrect;
        
		IF (v_CountAnsInQUes > 4 ) OR (v_CountAnsIsCorrects > 2) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant insert more answer for this question';
		END IF;
    END $$
DELIMITER ;


INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 20'	,   1			,	0		);
SELECT 	*
FROM	ANSWER;

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

INSERT INTO Exam	(`Code`		, Title					, CategoryID, Duration, CreatorID, CreateDate )
VALUES 				('VTIQ008'	, N'Đề thi C# Nang cao'	,	2		,	60	  ,   '5'	 ,'2021-09-15');


DROP TRIGGER IF EXISTS delete_exam;
DELIMITER $$
CREATE TRIGGER delete_exam
BEFORE DELETE ON Exam
FOR EACH ROW
	BEGIN
		DECLARE v_delete_create_time DATETIME;
        SET		v_delete_create_time = date_sub(now(), interval 2 DAY);
		IF (OLD.CreateDate > v_delete_create_time) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = " Cant delete this Exam "; 
		END IF;
    END $$
DELIMITER ;

DELETE	
FROM	Exam E
Where	E.ExamID = 12;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào

DROP TRIGGER IF EXISTS var_update_question;
DELIMITER $$
CREATE TRIGGER var_update_question
BEFORE UPDATE ON Question
FOR EACH ROW
	BEGIN
		DECLARE v_update_QuestionID TINYINT;
        SET		v_update_QuestionID = (	SELECT  q.QuestionId
										FROM	Question q
										JOIN	Exam e
										ON		q.QuestionId = e.ExamId);
		IF (OLD.QuestionId != v_update_QuestionID) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = " Cant update this question "; 
		END IF;
    END $$
DELIMITER ;

DROP TRIGGER IF EXISTS check_before_update_question;
DELIMITER $$
CREATE TRIGGER check_before_update_question
BEFORE UPDATE ON `Question`
FOR EACH ROW
	BEGIN
		DECLARE v_CountQuesByID TINYINT;
		SET 	v_CountQuesByID = -1;
		SELECT  count(1) INTO v_CountQuesByID 
        FROM 	ExamQuestion ex 
        WHERE 	ex.QuestionID = NEW.QuestionID;
        
		IF (v_CountQuesByID != -1) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cant Update This Question';
		END IF ;
	END $$
DELIMITER ;

UPDATE 	`administer_exams`.Question
SET 	Content = 'What is this' 
WHERE	QuestionID = '253';
SELECT	*
FROM	Question;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT *,
		CASE
			WHEN Duration <= 60 THEN 'Short time'
            WHEN Duration > 60 && Duration <= 90 THEN 'Medium time'
            WHEN Duration > 90 THEN 'Long time'
            ELSE 'không xác định'
		END AS Duration
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT		 ga.GroupID, count(a.AccountID),
	CASE
		WHEN count(ga.AccountID) <= 5 THEN 'few'
        WHEN count(ga.AccountID) <= 20 THEN 'normal'
        WHEN count(ga.AccountID) > 20 THEN 'higher'
	END AS the_number_user_amount
FROM		`Account` a
JOIN		`GroupAccount` ga USING (AccountID)
GROUP BY	ga.GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT D.DepartmentName,
	CASE
		WHEN COUNT(A.DepartmentID) = 0 THEN 'Không có User'
		ELSE COUNT(A.DepartmentID)
	END AS count_user
FROM department D
LEFT JOIN `Account` A ON D.DepartmentID = A.DepartmentID
GROUP BY D.DepartmentID;


