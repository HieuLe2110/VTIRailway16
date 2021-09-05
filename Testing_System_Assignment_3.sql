USE 	administer_exams;

-- Question 2: lấy ra tất cả các phòng ban
SELECT	*
FROM	Department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT	*
FROM	Department
WHERE	DepartmentName = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT	*
FROM	`Account`
WHERE	LENGTH(FullName) = (SELECT MAX(LENGTH(FullName))FROM `Account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id= 3
SELECT *
FROM `Account`
GROUP BY DepartmentID = 3 
HAVING LENGTH(FullName) = (SELECT MAX(LENGTH(FullName))FROM `Account`);

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT	*
FROM	`Group`
WHERE	CreateDate < '2019:12:20 00:00:00';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT		QuestionID, count(QuestionID)
FROM		Answer
GROUP BY	QuestionID
HAVING		count(QuestionID) >=4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT		`Code`, Duration
FROM		Exam
WHERE		Duration >= 60 AND CreateDate < '2019-12-20 00:00:00';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT		GroupName, CreateDate
FROM		`Group`
ORDER BY	CreateDate DESC 
LIMIT		5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT 		DepartmentID, COUNT(AccountID), group_concat(FullName)
FROM 		`Account`
WHERE 		DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT 		FullName
FROM 		`Account`
WHERE 		(substring_index(Fullname,' ',-1)) LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
SET 		foreign_key_checks = 0;  -- xoá khoá ngoại
DELETE
FROM 		Exam
WHERE 		CreateDate < '2019-12-20';
SET 		foreign_key_checks = 1;  -- trả lại khoá ngoại

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE
FROM 		Question
WHERE 		Content LIKE ('Câu hỏi%');
SELECT 		*
FROM 		Question;

/* Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và
email thành loc.nguyenba@vti.com.vn */
UPDATE 		`Account`
SET 		Fullname= 'Nguyen Ba Loc' , email = 'loc.nguyenba@vti.com.vn' , DepartmentID = '4'
WHERE 		AccountID = 5;
SELECT 		*
FROM		`Account`
WHERE 		AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE		`GroupAccount`
SET			AccountID = 5
WHERE		GroupID = 4;
SELECT * FROM `Account`;
