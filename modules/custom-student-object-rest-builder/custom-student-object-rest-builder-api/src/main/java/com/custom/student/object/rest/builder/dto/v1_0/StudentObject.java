package com.custom.student.object.rest.builder.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kommineni.chandu
 * @generated
 */
@Generated("")
@GraphQLName("StudentObject")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "StudentObject")
public class StudentObject implements Serializable {

	public static StudentObject toDTO(String json) {
		return ObjectMapperUtil.readValue(StudentObject.class, json);
	}

	public static StudentObject unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(StudentObject.class, json);
	}

	@Schema
	public String getEnrollmentNo() {
		return enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	@JsonIgnore
	public void setEnrollmentNo(
		UnsafeSupplier<String, Exception> enrollmentNoUnsafeSupplier) {

		try {
			enrollmentNo = enrollmentNoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String enrollmentNo;

	@Schema
	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	@JsonIgnore
	public void setStudentDepartment(
		UnsafeSupplier<String, Exception> studentDepartmentUnsafeSupplier) {

		try {
			studentDepartment = studentDepartmentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String studentDepartment;

	@Schema
	public Double getStudentGPA() {
		return studentGPA;
	}

	public void setStudentGPA(Double studentGPA) {
		this.studentGPA = studentGPA;
	}

	@JsonIgnore
	public void setStudentGPA(
		UnsafeSupplier<Double, Exception> studentGPAUnsafeSupplier) {

		try {
			studentGPA = studentGPAUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double studentGPA;

	@Schema
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@JsonIgnore
	public void setStudentId(
		UnsafeSupplier<Long, Exception> studentIdUnsafeSupplier) {

		try {
			studentId = studentIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long studentId;

	@Schema
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@JsonIgnore
	public void setStudentName(
		UnsafeSupplier<String, Exception> studentNameUnsafeSupplier) {

		try {
			studentName = studentNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String studentName;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (enrollmentNo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enrollmentNo\": ");

			sb.append("\"");

			sb.append(_escape(enrollmentNo));

			sb.append("\"");
		}

		if (studentDepartment != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentDepartment\": ");

			sb.append("\"");

			sb.append(_escape(studentDepartment));

			sb.append("\"");
		}

		if (studentGPA != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentGPA\": ");

			sb.append(studentGPA);
		}

		if (studentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentId\": ");

			sb.append(studentId);
		}

		if (studentName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentName\": ");

			sb.append("\"");

			sb.append(_escape(studentName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.custom.student.object.rest.builder.dto.v1_0.StudentObject",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}