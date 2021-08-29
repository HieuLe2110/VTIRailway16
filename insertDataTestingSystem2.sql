-- insertData
USE administer_exams;

-- insert to Table 1
INSERT INTO		Department(DepartmentName	)
VALUES						(N'Giám đốc '	),
							(N'Thư kí'		),
							(N'Tài chính'	),
							(N'Trưởng phòng'),
                            (N'Nhân viên'	);

-- insert to Table 2
INSERT INTO		`Position`(PositionName		)
VALUES						('Dev'			),
							('Test'			),
							('Scrum Master'	),
							('PM'			);
                            
-- insert to Table 3
INSERT INTO		`Account`(Email					,UserName			,FullName			,DepartmentID 		,PositionID			)
VALUES					 ('email1@gmail.com'	,'User1'			,N'Nguyen Van A'	,1					,1					),
						 ('email2@gmail.com'	,'User2'			,N'Nguyen Van B'	,2					,2					),
						 ('email3@gmail.com'	,'User3'			,N'Nguyen Van C'	,3					,4					),
						 ('email4@gmail.com'	,'User4'			,N'Nguyen Van D'	,4					,2					),
                         ('email5@gmail.com'	,'User5'			,N'Nguyen Van E'	,2					,3					);
                          	
-- insert to Table 4
INSERT INTO		`Group`	 (GroupName				,CreatorID			)
VALUES					 ('MySQL'				,1					),
						 ('Java'				,1					),
						 ('HTML'				,3					),
						 ('CSS'					,2					),
                         ('Ruby'				,3					);
                         
-- insert to Table 5
INSERT INTO	`GroupAccount`(GroupID				,AccountID			)
VALUES					  (1					,1		 			),
						  (1					,3					),
						  (3					,3					),
						  (2					,2					),
                          (2					,3					);

-- insert to Table 6
INSERT INTO	 TypeQuestion(TypeName				)
VALUES					 ('Essay'				),
						 ('Multiple-Choice'		); 

-- insert to Table 7
INSERT INTO CategoryQuestion (CategoryName		)
VALUES						 ('Java'			),
							 ('C++'				),
							 ('HTML'			),
							 ('CSS'				),
							 ('Ruby'			);
                             
-- insert to Table 8
INSERT INTO		Question (Content			,CategoryID		,TypeID		,CreatorID)	
VALUES					 (N'Hỏi về Java'	,1				,1	        ,1		),		
						 (N'Hỏi về C++'		,2				,2	        ,2		),		
						 (N'Hỏi về HTML'	,3				,2	        ,3		),		
						 (N'Hỏi về CSS'		,4				,1	        ,2		),		
                         (N'Hỏi về Ruby'	,5				,1	        ,3		);		
 
 -- insert to Table 9
INSERT INTO	 Answer	 (Content					 ,	QuestionID 		,	isCorrect)
VALUES				 ('Trong Java .......' 		 ,	1		   		,	0		),
					 ('Trong HTML.......' 		 ,	5		 		,	1		),
                     ('Trong CSS.......' 		 ,	2		 	  	,	0		),
                     ('Trong MySQL........' 	 ,	4		  		,	0		),
                     ('Trong CSS......' 		 ,	3		  		,	1		);

-- insert to Table 10
INSERT INTO	 Exam	 (`Code`	,Title				,	CategoryID	,	Duration	,	CreatorID)
VALUES				 ('A_1'   	,'Kiến thức về Java '		 	,	1		  	,		60		,	1 	  	 ),
					 ('A_2'   	,'Kiến thức về HTML '		    ,	2		  	,		60		,	4		 ),
                     ('A_3'   	,'Kiến thức về CSS '		    ,	2		  	,		60		,	2		 ),
                     ('B_1'   	,'Kiến thức về Ruby'		    ,	4		  	,		120		,	5		 ),
                     ('B_2'   	,'Kiến thức về MySQL'		    ,	5		  	,		120		,	3		 );

-- insert to Table 11
INSERT INTO	 ExamQuestion	(ExamID		,	QuestionID 	)
VALUES				 		(1		  	,	3		),
							(5			,	1		),
							(2		  	,	4		),
							(4		 	,	5		),
							(3		 	,	2		);