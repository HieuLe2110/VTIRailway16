USE administer_exams;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT	*
FROM 	`Account` AS A1
JOIN 	Department AS D1
ON 		A1.DepartmentID = D1.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/3/2020
SELECT 	*
FROM 	`Account`
WHERE 	CreateDate > '2020:3:20 00:00:00';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT 	PositionID
FROM 	`Account`
JOIN 	`Position`
USING 	(PositionID)
WHERE 	PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên
SELECT		DepartmentName, count(DepartmentID) AS 'Số lượng nhân viên'
FROM 		`Account`
JOIN 		Department 
USING		(DepartmentID)
GROUP BY 	DepartmentID
HAVING		count(DepartmentID) >= 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT		QuestionID, Content, count(QuestionID) AS 'Số lần xuất hiện'
FROM 		ExamQuestion
JOIN		Question
USING		(QuestionID)
GROUP BY	QuestionID
HAVING 		count(QuestionID) = (	SELECT		count(QuestionID)
									FROM 		ExamQuestion
									GROUP BY	QuestionID
									ORDER BY	count(QuestionID) DESC
									LIMIT 		1							);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 		CategoryID, CategoryName, count(QuestionID) AS 'Tổng số Question được dùng'
FROM 		CategoryQuestion
JOIN		Question
USING		( CategoryID )
GROUP BY	CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 		q.QuestionID, q.Content , count(eq.QuestionID) AS 'Số lượng xuất hiện trong exam'
FROM 		ExamQuestion eq
RIGHT JOIN  Question q 
ON 			q.QuestionID = eq.QuestionID
GROUP BY 	q.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT		q.QuestionID,	count(a.AnswerID) AS 'Số lượng câu trả lời nhiều nhất'
FROM		Question q
JOIN		Answer a
ON			q.QuestionID = a.QuestionID
GROUP BY	q.QuestionID
HAVING		count(a.AnswerID) = (	SELECT		count(AnswerID)
									FROM		Answer
                                    GROUP BY	QuestionID
                                    ORDER BY 	COUNT(AnswerID) DESC
									LIMIT 		1						);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT 		g.GroupID, g.GroupName, count(ga.AccountID) AS 'Số lượng account'
FROM		`Group` g
JOIN	GroupAccount ga
ON			g.GroupID = ga.GroupID
GROUP BY	ga.GroupID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT		d.DepartmentName AS 'Chức vụ', count(a.AccountID) AS 'Số lượng người ít nhất' 
FROM		Department d
JOIN		`Account` a
ON			d.DepartmentID = a.DepartmentID
GROUP BY	d.DepartmentName
HAVING		count(a.AccountID) = (	SELECT 	MIN(SL_acc)
									FROM	(	SELECT	count(AccountID) AS SL_acc
												FROM	`Account` 
												GROUP BY	DepartmentID
                                                HAVING		count(AccountID)	) AS minPA );

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu nhân viên thuộc 1 trong 4 vị trí sau: dev, test, scrum master, PM
SELECT DepartmentName, COUNT(a.PositionID), group_concat(PositionName)
FROM `Account` a 
JOIN department d ON a.DepartmentID = d.DepartmentID
JOIN position p ON a.PositionID = p.PositionID
GROUP BY a.DepartmentID, a.positionID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT 		Q.QuestionID, Q.Content, A.FullName, TQ.TypeName, ANS.Content
FROM 		Question Q
JOIN 		CategoryQuestion CQ 	ON Q.CategoryID = CQ.CategoryID
JOIN 		TypeQuestion TQ 		ON Q.TypeID = TQ.TypeID
JOIN 		`Account` A 			ON Q.CreatorID = A.AccountID 
JOIN 		Answer AS ANS 			ON Q.QuestionID = ANS.QuestionID
ORDER BY 	Q.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 		TQ.TypeID, TQ.TypeName, COUNT(Q.TypeID) AS 'Số lượng câu hỏi' 
FROM 		Question Q
JOIN 		TypeQuestion TQ 
ON 			Q.TypeID = TQ.TypeID
GROUP BY	Q.TypeID;

-- Question 14:Lấy ra group không có account nào
SELECT		 * 
FROM 		`Group` G
LEFT JOIN 	GroupAccount GA ON G.GroupID = GA.GroupID
WHERE 		GA.AccountID IS NULL;

-- Question 15: Lấy ra group không có account nào
SELECT 		*
FROM 		`Group`
WHERE 		GroupID NOT IN (SELECT 	GroupID
							FROM 	GroupAccount);

-- Question 16: Lấy ra question không có answer nào
SELECT		 * 
FROM 		Question Q
LEFT JOIN 	Answer ANS ON Q.QuestionID = ANS.QuestionID
WHERE 		ANS.QuestionID IS NULL;

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT	 A.FullName 
FROM 	`Account` A
JOIN 	GroupAccount GA
ON 		A.AccountID = GA.AccountID
WHERE 	GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT	 A.FullName 
FROM 	`Account` A
JOIN 	GroupAccount GA
ON 		A.AccountID = GA.AccountID
WHERE 	GA.GroupID = 3;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau 
SELECT	 A.FullName 
FROM 	`Account` A
JOIN 	GroupAccount GA
ON 		A.AccountID = GA.AccountID
WHERE 	GA.GroupID = 1
UNION
SELECT	 A.FullName 
FROM 	`Account` A
JOIN 	GroupAccount GA
ON 		A.AccountID = GA.AccountID
WHERE 	GA.GroupID = 3;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT 		g.GroupName, COUNT(ga.GroupID) AS 'Số Lượng thành viên'
FROM 		GroupAccount ga
JOIN 		`Group` g 
ON 			ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) >= 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT 		g.GroupName, COUNT(ga.GroupID) AS 'Số Lượng thành viên'
FROM 		GroupAccount ga
JOIN 		`Group` g 
ON 			ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) <= 7;

-- c) Ghép 2 kết quả từ câu a) và câu
SELECT 		g.GroupName, COUNT(ga.GroupID) AS 'Số Lượng thành viên'
FROM 		GroupAccount ga
JOIN 		`Group` g 
ON 			ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) >= 5
UNION
SELECT 		g.GroupName, COUNT(ga.GroupID) AS 'Số Lượng thành viên'
FROM 		GroupAccount ga
JOIN 		`Group` g 
ON 			ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) <= 7;



SELECT 	*
FROM 	department AS d1
LEFT JOIN 	`Account` AS a1 -- = JOIN
ON 		d1.DepartmentID = a1.DepartmentID; 
-- Có thể sử dụng ' USING(DepartmentID) ' nếu 2 bảng có trường trùng nhau

-- lấy ra các câu hỏi và người tạo của câu hỏi đấy
SELECT 	*
FROM 	Question AS q1
INNER JOIN 	`Account` AS a1 -- = JOIN
ON 		q1.QuestionID = a1.AccountID; 

-- Lấy ra tất cả câu trả lời và câu hỏi tương ứng của câu trả lời đóALTER
SELECT 	*
FROM 	Answer AS a1
LEFT JOIN 	Question AS q1
ON 		a1.QuestionID = q1.QuestionID;

-- Left Excluding join : thêm 1 câu đk WHERE
-- thống kê các phòng ban mà không có account nào thì mình dùng Left Excluding join
SELECT 	*
FROM 	Answer AS a1
LEFT JOIN 	Question AS q1
ON 		a1.QuestionID = q1.QuestionID
WHERE a1.QuestionID IS NULL;

-- union: lấy ra tất cả các giá trị unique(không lặp lại) từ 2 cậu lệnh select
SELECT AccountID

-- Lấy các account thuộc nhóm thứ 1
-- Lấy các account thuộc nhóm thứ 2

SELECT 	*
FROM 	GroupAccount AS G
JOIN 	`Account` AS A
ON		G.AccountID = A.AccountID
WHERE 	G.GroupID = 1
union

SELECT *
FROM 	GroupAccount AS G
JOIN 	`Account` AS A
ON		G.AccountID = A.AccountID
WHERE 	G.GroupID = 2;