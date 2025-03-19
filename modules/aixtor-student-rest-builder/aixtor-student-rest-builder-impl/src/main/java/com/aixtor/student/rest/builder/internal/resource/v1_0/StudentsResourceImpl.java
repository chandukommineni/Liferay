package com.aixtor.student.rest.builder.internal.resource.v1_0;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.aixtor.student.rest.builder.dto.v1_0.StudentObject;
import com.aixtor.student.rest.builder.resource.v1_0.StudentsResource;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author kommineni.chandu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/students.properties",
	scope = ServiceScope.PROTOTYPE, service = StudentsResource.class
)
public class StudentsResourceImpl extends BaseStudentsResourceImpl {
    private static Log _logger=LogFactoryUtil.getLog(StudentsResourceImpl.class);
	@Override
	public StudentObject getStudentById(@NotNull Long studentId) throws Exception {
        _logger.info("---- Requesting for Student "+studentId +"------");
		Student student=studentLocalSerivce.getStudent(studentId);
        if (student==null) {
        	_logger.info("---- student not found -----");
        	return null;
        }
		return getCopiedStudentsObject(student);
	}

	@Override
	public Page<StudentObject> getAllStudents(Pagination pagination) throws Exception {
	     _logger.info("----- Get All Student List Request Receieved ------");
		 List<Student> students=studentLocalSerivce.getStudents(pagination.getStartPosition(), pagination.getEndPosition());
		 List<StudentObject> studentObjects=new ArrayList<>();
		 for(Student student:students) {
			 studentObjects.add(getCopiedStudentsObject(student));
		 }
	    return Page.of(studentObjects);
	}

	@Override
	public StudentObject deleteStudentById(@NotNull Long studentId) throws Exception {
        _logger.info("----- Delete Student "+studentId+" Request Received -----");
		Student student=studentLocalSerivce.getStudentByID(studentId);
        
		return getCopiedStudentsObject(student);
	}

	@Override
	public StudentObject updateStudent(StudentObject studentObject) throws Exception {
		_logger.info("------ Update Student Request Received -----");
		Long studentId=studentObject.getStudentId();
		String studentName=studentObject.getStudentName();
		String studentDepartment=studentObject.getStudentDepartment();
		String studentEnrollmentNo=studentObject.getStudentEnrollmentNo();
		Double studentGPA=studentObject.getStudentGPA();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), contextHttpServletRequest);	
		Student student=studentLocalSerivce.updateStudent(studentId, studentName, studentDepartment, studentGPA, studentEnrollmentNo,serviceContext);
		return getCopiedStudentsObject(student);
	}

	@Override
	public StudentObject addStudent(StudentObject studentObject) throws Exception {

		_logger.info("------ Add Student Request Received -----");
		Long studentId=studentObject.getStudentId();
		String studentName=studentObject.getStudentName();
		String studentDepartment=studentObject.getStudentDepartment();
		String studentEnrollmentNo=studentObject.getStudentEnrollmentNo();
		Double studentGPA=studentObject.getStudentGPA();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), contextHttpServletRequest);	
		Student student=studentLocalSerivce.addStudent( studentName, studentDepartment, studentGPA, studentEnrollmentNo,serviceContext);
		return getCopiedStudentsObject(student);
	}
	
	public static StudentObject getCopiedStudentsObject(Student student) {
		 StudentObject studentObject=new  StudentObject();
		 
		 studentObject.setStudentId(student.getStudentId());
		 studentObject.setStudentName(student.getStudentName());
		 studentObject.setStudentEnrollmentNo(student.getStudentEnrollmentNo());
		 studentObject.setStudentDepartment(student.getStudentDepartment());
		 studentObject.setStudentGPA(student.getStudentGPA());
		 
		return studentObject;
	}

	@Reference
	private StudentLocalService studentLocalSerivce;
	
}