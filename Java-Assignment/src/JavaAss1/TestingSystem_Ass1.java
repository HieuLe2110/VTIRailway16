package JavaAss1;

import java.time.LocalDate;
import java.util.Date;

import JavaAss1.Position.PositionName;

public class TestingSystem_Ass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Khoi tao gia tri department

		Department dept1 = new Department();
		dept1.id = 1;
		dept1.name = "Sale";

		Department dept2 = new Department();
		dept2.id = 2;
		dept2.name = "Giam doc";

		Department dept3 = new Department();
		dept3.id = 3;
		dept3.name = "Truong phong";

		Department dept4 = new Department();
		dept4.id = 4;
		dept4.name = "Ke toan";

		Department dept5 = new Department();
		dept5.id = 5;
		dept5.name = "Nhan su";

		// Khoi tao gia tri Position

		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.Test;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Scrum_Master;

		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.PM;

		Position pos5 = new Position();
		pos5.id = 5;
		pos5.name = PositionName.Test;

		// khoi tao group

		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";

		// Khoi tao gia Account

		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1@gmail.com";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.department = dept1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();
		Group[] groupAcc1 = { group1, group2 };
		acc1.groups = groupAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2@gmail.com";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.department = dept2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.of(2021, 03, 17);
		acc2.groups = new Group[] { group3, group2 };

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3@gmail.com";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.department = dept3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();

		// khoi tao groupAcc

//		GroupAccount ga1 = new GroupAccount();
//		ga1.groID = g1;
//
//		GroupAccount ga2 = new GroupAccount();
//		ga2.groID = g2;
//
//		GroupAccount ga3 = new GroupAccount();
//		ga3.groID = g3;
//
//		// khoi tao typeQues
//
//		TypeQuestion tq1 = new TypeQuestion();
//		tq1.typeID = 1;
//		tq1.typeName = typeQues.Essay;
//
//		TypeQuestion tq2 = new TypeQuestion();
//		tq2.typeID = 2;
//		tq2.typeName = typeQues.MultipleChoice;
//
//		TypeQuestion tq3 = new TypeQuestion();
//		tq3.typeID = 3;
//		tq3.typeName = typeQues.Essay;
//
//		TypeQuestion tq4 = new TypeQuestion();
//		tq4.typeID = 4;
//		tq4.typeName = typeQues.MultipleChoice;
//
//		TypeQuestion tq5 = new TypeQuestion();
//		tq5.typeID = 5;
//		tq5.typeName = typeQues.Essay;

		// khoi tao CateQues

//		CategoryQuestion cq1 = new CategoryQuestion();
//		cq1.categoryID = 1;
//		cq1.categoryName = "Java";
//
//		CategoryQuestion cq2 = new CategoryQuestion();
//		cq2.categoryID = 2;
//		cq2.categoryName = ".NET";
//
//		CategoryQuestion cq3 = new CategoryQuestion();
//		cq3.categoryID = 3;
//		cq3.categoryName = "SQL";
//
//		CategoryQuestion cq4 = new CategoryQuestion();
//		cq4.categoryID = 4;
//		cq4.categoryName = "Postman";
//
//		CategoryQuestion cq5 = new CategoryQuestion();
//		cq5.categoryID = 5;
//		cq5.categoryName = "Ruby";

		// khoi tao Ques

//		Question ques1 = new Question();
//		ques1.questionID = 1;
//		ques1.contentQuestion = "Question about Java";
//		ques1.categoryID = cq1;
//		ques1.typeID = typeQues.Essay;
//		ques1.creatorID = user1;
//		ques1.creatQuesDate = new Date("2021-09-24");
//
//		Question ques2 = new Question();
//		ques2.questionID = 2;
//		ques2.contentQuestion = "Question about .NET";
//		ques2.categoryID = cq2;
//		ques2.typeID = typeQues.Essay;
//		ques2.creatorID = user3;
//		ques2.creatQuesDate = new Date("2021-09-24");
//
//		Question ques3 = new Question();
//		ques3.questionID = 3;
//		ques3.contentQuestion = "Question about SQL";
//		ques3.categoryID = cq3;
//		ques3.typeID = typeQues.MultipleChoice;
//		ques3.creatorID = user1;
//		ques3.creatQuesDate = new Date("2021-09-24");
//
//		Question ques4 = new Question();
//		ques4.questionID = 4;
//		ques4.contentQuestion = "Question about Postman";
//		ques4.categoryID = cq4;
//		ques4.typeID = typeQues.Essay;
//		ques4.creatorID = user2;
//		ques4.creatQuesDate = new Date("2021-09-24");
//
//		Question ques5 = new Question();
//		ques5.questionID = 5;
//		ques5.contentQuestion = "Question about Ruby";
//		ques5.categoryID = cq5;
//		ques5.typeID = typeQues.MultipleChoice;
//		ques5.creatorID = user1;
//		ques5.creatQuesDate = new Date("2021-09-24");

		// khoi tao answer

//		Answer an1 = new Answer();
//		an1.answerID = 1;
//		an1.contentAnswer = "Answer for Java";
//		an1.questionID = ques1;
//		an1.isCorrect = false;
//
//		Answer an2 = new Answer();
//		an2.answerID = 2;
//		an2.contentAnswer = "Answer for .NET";
//		an2.questionID = ques2;
//		an2.isCorrect = true;
//
//		Answer an3 = new Answer();
//		an3.answerID = 3;
//		an3.contentAnswer = "Answer for SQL";
//		an3.questionID = ques3;
//		an3.isCorrect = false;
//
//		Answer an4 = new Answer();
//		an4.answerID = 4;
//		an4.contentAnswer = "Answer for Postman";
//		an4.questionID = ques4;
//		an4.isCorrect = true;
//
//		Answer an5 = new Answer();
//		an5.answerID = 5;
//		an5.contentAnswer = "Answer for Ruby";
//		an5.questionID = ques5;
//		an5.isCorrect = false;

		// khoi tao exam

//		Exam ex1 = new Exam();
//		ex1.examID = 1;
//		ex1.code = "001abc";
//		ex1.title = "Exam firt";
//		ex1.categoryID = cq1;
//		ex1.duration = 60;
//		ex1.creatorID = user1;
//		ex1.createExamDate = new Date("2019-09-21");
//
//		Exam ex2 = new Exam();
//		ex2.examID = 2;
//		ex2.code = "001abc";
//		ex2.title = "Exam second";
//		ex2.categoryID = cq2;
//		ex2.duration = 120;
//		ex2.creatorID = user1;
//		ex2.createExamDate = new Date("2020-12-21");
//
//		Exam ex3 = new Exam();
//		ex3.examID = 3;
//		ex3.code = "001abc";
//		ex3.title = "Exam third";
//		ex3.categoryID = cq3;
//		ex3.duration = 60;
//		ex3.creatorID = user4;
//		ex3.createExamDate = new Date("2021-08-01");

		// khoi tao examQues

//		ExamQuestion eq1 = new ExamQuestion();
//		eq1.examID = ex1;
//		eq1.questionID = ques1;
//
//		ExamQuestion eq2 = new ExamQuestion();
//		eq2.examID = ex3;
//		eq2.questionID = ques3;
//
//		ExamQuestion eq3 = new ExamQuestion();
//		eq3.examID = ex1;
//		eq3.questionID = ques5;

		// Question 3: Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối
		// tượng ra

		System.out.println("Thông tin các Account trên hệ thống:");
		System.out.println("Account 1: 	ID : " + acc1.id 
									+ " Email: " 		+ acc1.email 
									+ " UserName: " 	+ acc1.userName
									+ " FullName: " 	+ acc1.fullName 
									+ " Department: " 	+acc1.department.name
									+ " Position: " 	+ acc1.position.name
									+ " Group: " 		+ acc1.groups[0].name
									+ " " 				+ acc1.groups[1].name
									+ "CreateDate: "	+ acc1.createDate);

	}

}
