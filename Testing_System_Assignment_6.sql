USE administer_exams;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP procedure IF EXISTS get_all_account_of_department;
DELIMITER $$
CREATE PROCEDURE get_all_account_of_department(IN tenPhongBan NVARCHAR(50))
	BEGIN
		SELECT	* 
        FROM 	`Account`
        JOIN	Department
        USING	(DepartmentID)
        WHERE	DepartmentName = tenPhongBan;
        -- WHERE	DepartmentName = `Sale`;
    END $$
DELIMITER ;
CALL	get_all_account_of_department('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS accnum_in_group;
DELIMITER $$
CREATE PROCEDURE accnum_in_group()
	BEGIN
		SELECT 	groupID, groupname, COUNT(ga.AccountID) , Group_Concat(ga.accountID)
        FROM 	`Group` g
        JOIN 	GroupAccount ga 
        ON		g.groupID = ga.GroupID
        GROUP BY GroupID;
	END $$
DELIMITER ;	
CALL accnum_in_group();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS quesnum;
DELIMITER $$
CREATE PROCEDURE quesnum()
	BEGIN
		SELECT 	TypeID, COUNT(q.QuestionID) , Group_Concat(q.questionID)
        FROM 	question q
        JOIN 	typequestion tq USING(typeID)
        WHERE month(q.CreateDate) = month(now()) AND year(q.CreateDate) = year(now())
        GROUP BY q.TypeID
        ;
	END $$
DELIMITER ;	

SELECT month(q.CreateDate)
FROM question q;
CALL quesnum();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_GetCountQuesFromType;
DELIMITER $$
CREATE PROCEDURE sp_GetCountQuesFromType()
BEGIN
WITH CTE_MaxTypeID AS(
SELECT count(q.TypeID) AS SL FROM question q
GROUP BY q.TypeID
)
SELECT tq.TypeName, count(q.TypeID) AS SL FROM question q
INNER JOIN typequestion tq ON tq.TypeID = q.TypeID
GROUP BY q.TypeID

HAVING count(q.TypeID) = (SELECT MAX(SL) FROM CTE_MaxTypeID);
END$$
DELIMITER ;
Call sp_GetCountQuesFromType();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS sp_GetCountQuesFromType;
DELIMITER $$
CREATE PROCEDURE sp_GetCountQuesFromType()
BEGIN
	WITH CTE_MaxTypeID AS(	SELECT count(q.TypeID) AS SL 
							FROM question q
							GROUP BY q.TypeID	)
	SELECT tq.TypeName, count(q.TypeID) AS SL FROM question q
	INNER JOIN typequestion tq 
    ON tq.TypeID = q.TypeID
	GROUP BY q.TypeID
	HAVING count(q.TypeID) = (	SELECT MAX(SL) 
								FROM CTE_MaxTypeID	);
END$$
DELIMITER ;
Call sp_GetCountQuesFromType();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_DeleteExamWithID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteExamWithID (IN in_ExamID TINYINT UNSIGNED)
	BEGIN
		DELETE FROM examquestion 
        WHERE ExamID = in_ExamID;
		DELETE FROM Exam 
        WHERE ExamID = in_ExamID;
	END$$
DELIMITER ;
CALL sp_DeleteExamWithID(7);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong
-- 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")