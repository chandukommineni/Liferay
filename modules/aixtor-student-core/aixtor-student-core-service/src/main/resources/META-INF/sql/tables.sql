create table aixtor_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	studentName VARCHAR(75) null,
	studentDepartment VARCHAR(75) null,
	studentGPA DOUBLE,
	studentEnrollmentNo VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);