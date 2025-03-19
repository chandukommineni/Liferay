package com.aixtor.student.rest.builder.client.serdes.v1_0;

import com.aixtor.student.rest.builder.client.dto.v1_0.StudentObject;
import com.aixtor.student.rest.builder.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author kommineni.chandu
 * @generated
 */
@Generated("")
public class StudentObjectSerDes {

	public static StudentObject toDTO(String json) {
		StudentObjectJSONParser studentObjectJSONParser =
			new StudentObjectJSONParser();

		return studentObjectJSONParser.parseToDTO(json);
	}

	public static StudentObject[] toDTOs(String json) {
		StudentObjectJSONParser studentObjectJSONParser =
			new StudentObjectJSONParser();

		return studentObjectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(StudentObject studentObject) {
		if (studentObject == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (studentObject.getStudentDepartment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentDepartment\": ");

			sb.append("\"");

			sb.append(_escape(studentObject.getStudentDepartment()));

			sb.append("\"");
		}

		if (studentObject.getStudentEnrollmentNo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentEnrollmentNo\": ");

			sb.append("\"");

			sb.append(_escape(studentObject.getStudentEnrollmentNo()));

			sb.append("\"");
		}

		if (studentObject.getStudentGPA() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentGPA\": ");

			sb.append(studentObject.getStudentGPA());
		}

		if (studentObject.getStudentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentId\": ");

			sb.append(studentObject.getStudentId());
		}

		if (studentObject.getStudentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentName\": ");

			sb.append("\"");

			sb.append(_escape(studentObject.getStudentName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StudentObjectJSONParser studentObjectJSONParser =
			new StudentObjectJSONParser();

		return studentObjectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(StudentObject studentObject) {
		if (studentObject == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (studentObject.getStudentDepartment() == null) {
			map.put("studentDepartment", null);
		}
		else {
			map.put(
				"studentDepartment",
				String.valueOf(studentObject.getStudentDepartment()));
		}

		if (studentObject.getStudentEnrollmentNo() == null) {
			map.put("studentEnrollmentNo", null);
		}
		else {
			map.put(
				"studentEnrollmentNo",
				String.valueOf(studentObject.getStudentEnrollmentNo()));
		}

		if (studentObject.getStudentGPA() == null) {
			map.put("studentGPA", null);
		}
		else {
			map.put(
				"studentGPA", String.valueOf(studentObject.getStudentGPA()));
		}

		if (studentObject.getStudentId() == null) {
			map.put("studentId", null);
		}
		else {
			map.put("studentId", String.valueOf(studentObject.getStudentId()));
		}

		if (studentObject.getStudentName() == null) {
			map.put("studentName", null);
		}
		else {
			map.put(
				"studentName", String.valueOf(studentObject.getStudentName()));
		}

		return map;
	}

	public static class StudentObjectJSONParser
		extends BaseJSONParser<StudentObject> {

		@Override
		protected StudentObject createDTO() {
			return new StudentObject();
		}

		@Override
		protected StudentObject[] createDTOArray(int size) {
			return new StudentObject[size];
		}

		@Override
		protected void setField(
			StudentObject studentObject, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "studentDepartment")) {
				if (jsonParserFieldValue != null) {
					studentObject.setStudentDepartment(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "studentEnrollmentNo")) {

				if (jsonParserFieldValue != null) {
					studentObject.setStudentEnrollmentNo(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "studentGPA")) {
				if (jsonParserFieldValue != null) {
					studentObject.setStudentGPA(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "studentId")) {
				if (jsonParserFieldValue != null) {
					studentObject.setStudentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "studentName")) {
				if (jsonParserFieldValue != null) {
					studentObject.setStudentName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}