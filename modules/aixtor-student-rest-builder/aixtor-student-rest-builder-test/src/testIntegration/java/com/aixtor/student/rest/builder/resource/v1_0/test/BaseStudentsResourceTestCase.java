package com.aixtor.student.rest.builder.resource.v1_0.test;

import com.aixtor.student.rest.builder.client.dto.v1_0.StudentObject;
import com.aixtor.student.rest.builder.client.http.HttpInvoker;
import com.aixtor.student.rest.builder.client.pagination.Page;
import com.aixtor.student.rest.builder.client.pagination.Pagination;
import com.aixtor.student.rest.builder.client.resource.v1_0.StudentsResource;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author kommineni.chandu
 * @generated
 */
@Generated("")
public abstract class BaseStudentsResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_studentsResource.setContextCompany(testCompany);

		StudentsResource.Builder builder = StudentsResource.builder();

		studentsResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testGetAllStudents() throws Exception {
		Page<Students> page = studentsResource.getAllStudents(
			Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		Students students1 = testGetAllStudents_addStudents(randomStudents());

		Students students2 = testGetAllStudents_addStudents(randomStudents());

		page = studentsResource.getAllStudents(Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(students1, (List<Students>)page.getItems());
		assertContains(students2, (List<Students>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAllStudentsWithPagination() throws Exception {
		Page<Students> totalPage = studentsResource.getAllStudents(null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Students students1 = testGetAllStudents_addStudents(randomStudents());

		Students students2 = testGetAllStudents_addStudents(randomStudents());

		Students students3 = testGetAllStudents_addStudents(randomStudents());

		Page<Students> page1 = studentsResource.getAllStudents(
			Pagination.of(1, totalCount + 2));

		List<Students> studentses1 = (List<Students>)page1.getItems();

		Assert.assertEquals(
			studentses1.toString(), totalCount + 2, studentses1.size());

		Page<Students> page2 = studentsResource.getAllStudents(
			Pagination.of(2, totalCount + 2));

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Students> studentses2 = (List<Students>)page2.getItems();

		Assert.assertEquals(studentses2.toString(), 1, studentses2.size());

		Page<Students> page3 = studentsResource.getAllStudents(
			Pagination.of(1, totalCount + 3));

		assertContains(students1, (List<Students>)page3.getItems());
		assertContains(students2, (List<Students>)page3.getItems());
		assertContains(students3, (List<Students>)page3.getItems());
	}

	protected Students testGetAllStudents_addStudents(Students students)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteStudentById() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetStudentById() throws Exception {
		Students postStudents = testGetStudents_addStudents();

		StudentObject postStudentObject = testGetStudentById_addStudentObject(
			postStudents.getId(), randomStudentObject());

		StudentObject getStudentObject = studentsResource.getStudentById(
			postStudents.getId());

		assertEquals(postStudentObject, getStudentObject);
		assertValid(getStudentObject);
	}

	protected StudentObject testGetStudentById_addStudentObject(
			long studentsId, StudentObject studentObject)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateStudent() throws Exception {
		Students postStudents = testPutStudents_addStudents();

		testUpdateStudent_addStudentObject(
			postStudents.getId(), randomStudentObject());

		StudentObject randomStudentObject = randomStudentObject();

		StudentObject putStudentObject = studentsResource.updateStudent(
			randomStudentObject);

		assertEquals(randomStudentObject, putStudentObject);
		assertValid(putStudentObject);
	}

	protected StudentObject testUpdateStudent_addStudentObject(
			long studentsId, StudentObject studentObject)
		throws Exception {

		return studentsResource.updateStudent(studentsId, studentObject);
	}

	@Test
	public void testAddStudent() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Object students, List<Object> studentses) {
		boolean contains = false;

		for (Object item : studentses) {
			if (equals(students, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			studentses + " does not contain " + students, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object students1, Object students2) {
		Assert.assertTrue(
			students1 + " does not equal " + students2,
			equals(students1, students2));
	}

	protected void assertEquals(
		List<Object> studentses1, List<Object> studentses2) {

		Assert.assertEquals(studentses1.size(), studentses2.size());

		for (int i = 0; i < studentses1.size(); i++) {
			Object students1 = studentses1.get(i);
			Object students2 = studentses2.get(i);

			assertEquals(students1, students2);
		}
	}

	protected void assertEquals(
		StudentObject studentObject1, StudentObject studentObject2) {

		Assert.assertTrue(
			studentObject1 + " does not equal " + studentObject2,
			equals(studentObject1, studentObject2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> studentses1, List<Object> studentses2) {

		Assert.assertEquals(studentses1.size(), studentses2.size());

		for (Object students1 : studentses1) {
			boolean contains = false;

			for (Object students2 : studentses2) {
				if (equals(students1, students2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				studentses2 + " does not contain " + students1, contains);
		}
	}

	protected void assertValid(Object students) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> studentses = page.getItems();

		int size = studentses.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(StudentObject studentObject) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalStudentObjectAssertFieldNames()) {

			if (Objects.equals(
					"studentDepartment", additionalAssertFieldName)) {

				if (studentObject.getStudentDepartment() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"studentEnrollmentNo", additionalAssertFieldName)) {

				if (studentObject.getStudentEnrollmentNo() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("studentGPA", additionalAssertFieldName)) {
				if (studentObject.getStudentGPA() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("studentId", additionalAssertFieldName)) {
				if (studentObject.getStudentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("studentName", additionalAssertFieldName)) {
				if (studentObject.getStudentName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalStudentObjectAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Object students1, Object students2) {
		if (students1 == students2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		StudentObject studentObject1, StudentObject studentObject2) {

		if (studentObject1 == studentObject2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalStudentObjectAssertFieldNames()) {

			if (Objects.equals(
					"studentDepartment", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						studentObject1.getStudentDepartment(),
						studentObject2.getStudentDepartment())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"studentEnrollmentNo", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						studentObject1.getStudentEnrollmentNo(),
						studentObject2.getStudentEnrollmentNo())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("studentGPA", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						studentObject1.getStudentGPA(),
						studentObject2.getStudentGPA())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("studentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						studentObject1.getStudentId(),
						studentObject2.getStudentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("studentName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						studentObject1.getStudentName(),
						studentObject2.getStudentName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_studentsResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_studentsResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object students) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected StudentObject randomStudentObject() throws Exception {
		return new StudentObject() {
			{
				studentDepartment = RandomTestUtil.randomString();
				studentEnrollmentNo = RandomTestUtil.randomString();
				studentGPA = RandomTestUtil.randomDouble();
				studentId = RandomTestUtil.randomLong();
				studentName = RandomTestUtil.randomString();
			}
		};
	}

	protected StudentsResource studentsResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseStudentsResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.aixtor.student.rest.builder.resource.v1_0.StudentsResource
		_studentsResource;

}