SELECT 	*
FROM 	`Account`
WHERE	AccountID 	IN	( SELECT AccountID
						FROM `Account`
                        WHERE AccountID = 2 
                        OR AccountID = 3 
                        OR AccountID = 4);
                        
-- = ALL(Tất cả)   = ANY(1 trong số...) giống SOME

SELECT 	*
FROM 	`Account`
WHERE	AccountID 	> SOME	( SELECT AccountID
						FROM `Account`
                        WHERE AccountID = 2 
                        OR AccountID = 3 
                        OR AccountID = 4);

-- EXISTS : kiểm tra sự tồn tại của bất kì bản ghi nào trong toán tử con
SELECT 	*
FROM 	`Account`
WHERE	EXISTS	( SELECT AccountID
						FROM `Account`
                        WHERE AccountID = 2 
                        OR AccountID = 3 
                        OR AccountID = 4);

Drop VIEW IF EXISTS view_account;
CREATE VIEW view_account AS
	SELECT AccountID,Email,FullName,DepartmentName
    From `Account`
    JoIN Department USING(DepartmentID);
    
SELECT *
FROM view_account;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
Drop VIEW IF EXISTS 	view_account_is_Sale;
CREATE VIEW 	view_account_is_Sale AS
	SELECT 		AccountID,Email,FullName,DepartmentName
    From 		`Account`
    JoIN 		Department USING(DepartmentID)
    WHERE		DepartmentName = 'Sale';
    
SELECT 	*
FROM 	view_account_is_Sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
Drop VIEW IF EXISTS 	view_accountGroup;
CREATE VIEW 	view_accountGroup AS
	SELECT 		a1.*, COUNT(AccountID)
    From 		`Account` a1
    JoIN 		`GroupAccount` USING(AccountID)
    GROUP BY	AccountID
    HAVING		COUNT(AccountID) = (SELECT COUNT(AccountID)
									FROM `Account`
									JOIN `GroupAccount` USING (AccountID)
                                    GROUP BY AccountID
                                    ORDER BY COUNT(AccountID) DESC
									LIMIT 		1						) ;
                                    
SELECT 	*
FROM 	view_accountGroup;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 100 từ
-- được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS view_content;
CREATE VIEW			view_content AS
SELECT	QuestionID, Content
FROM	Question
WHERE	LENGTH(Content) >= 100 ;

DELETE
FROM	view_content;

SELECT 	*
FROM 	view_content;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS view_acc;
CREATE VIEW			view_acc AS
SELECT 	d.DepartmentID,d.DepartmentName, COUNT(a.AccountID) AS 'Số lượng nhân viên'
FROM	Department d
JOIN	`Account` a
ON		d.DepartmentID = a.DepartmentID
GROUP BY	d.DepartmentID
HAVING		COUNT(a.AccountID) = (	SELECT COUNT(AccountID)
									FROM `Account` a1
									JOIN Department d1 
                                    USING (DepartmentID)
                                    GROUP BY a1.DepartmentID
                                    ORDER BY COUNT(a1.AccountID) DESC
									LIMIT 		1						) ;

SELECT 	*
FROM 	view_acc;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS view_question_create_by_Nguyen;
CREATE VIEW			view_question_create_by_Nguyen AS
SELECT 	Q.CategoryID, Q.Content, A.FullName AS Creator 
FROM 	Question Q
JOIN 	`Account` A 
ON 		A.AccountID = Q.CreatorID
WHERE 	SUBSTRING_INDEX( A.FullName, ' ', 1 ) = 'Nguyễn';

SELECT 	* 
FROM 	view_question_create_by_Nguyen;








