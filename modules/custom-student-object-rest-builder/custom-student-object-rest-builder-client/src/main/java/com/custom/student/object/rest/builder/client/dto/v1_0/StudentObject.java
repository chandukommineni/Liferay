package com.custom.student.object.rest.builder.client.dto.v1_0;

import com.custom.student.object.rest.builder.client.function.UnsafeSupplier;
import com.custom.student.object.rest.builder.client.serdes.v1_0.StudentObjectSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author kommineni.chandu
 * @generated
 */
@Generated("")
public class StudentObject implements Cloneable, Serializable {

	public static StudentObject toDTO(String json) {
		return StudentObjectSerDes.toDTO(json);
	}

	public String getEnrollmentNo() {
		return enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	public void setEnrollmentNo(
		UnsafeSupplier<String, Exception> enrollmentNoUnsafeSupplier) {

		try {
			enrollmentNo = enrollmentNoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String enrollmentNo;

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public void setStudentDepartment(
		UnsafeSupplier<String, Exception> studentDepartmentUnsafeSupplier) {

		try {
			studentDepartment = studentDepartmentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String studentDepartment;

	public Double getStudentGPA() {
		return studentGPA;
	}

	public void setStudentGPA(Double studentGPA) {
		this.studentGPA = studentGPA;
	}

	public void setStudentGPA(
		UnsafeSupplier<Double, Exception> studentGPAUnsafeSupplier) {

		try {
			studentGPA = studentGPAUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double studentGPA;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public void setStudentId(
		UnsafeSupplier<Long, Exception> studentIdUnsafeSupplier) {

		try {
			studentId = studentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long studentId;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentName(
		UnsafeSupplier<String, Exception> studentNameUnsafeSupplier) {

		try {
			studentName = studentNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String studentName;

	@Override
	public StudentObject clone() throws CloneNotSupportedException {
		return (StudentObject)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentObject)) {
			return false;
		}

		StudentObject studentObject = (StudentObject)object;

		return Objects.equals(toString(), studentObject.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return StudentObjectSerDes.toJSON(this);
	}

}