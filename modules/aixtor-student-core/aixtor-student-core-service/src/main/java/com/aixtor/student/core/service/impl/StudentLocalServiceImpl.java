/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.aixtor.student.core.service.impl;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalServiceUtil;
import com.aixtor.student.core.service.base.StudentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.student.core.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
private static final Log _logger=LogFactoryUtil.getLog(StudentLocalServiceImpl.class);
	
	public Student addStudent(
		    String studentName, String studentDepartment, double studentGPA,
		    String studentEnrollmentNo,  ServiceContext serviceContext) throws PortalException {

	 
		    Student student = studentLocalService.createStudent(counterLocalService.increment(Student.class.getName()));

		
		    student.setCompanyId(serviceContext.getCompanyId());
		    student.setUserId(serviceContext.getUserId());


		    student.setCreateDate(new Date());
		    student.setModifiedDate(new Date());

		    student.setStudentName(studentName);
		    student.setStudentDepartment(studentDepartment);
		    student.setStudentGPA(studentGPA);
		    student.setStudentEnrollmentNo(studentEnrollmentNo);
		    
            _logger.info("Executing Add Student Action"+ student.toString());
		 
            //adding the student into database and returning the added student details
		    return studentLocalService.addStudent(student);
		}
	
	public Student updateStudent(
		    long studentId, String studentName, String studentDepartment, double studentGPA,
		    String studentEnrollmentNo, ServiceContext serviceContext) throws PortalException {

		    
		    Student student = studentLocalService.getStudent(studentId);

		   
		    student.setModifiedDate(new Date());

		 
		    student.setStudentName(studentName);
		    student.setStudentDepartment(studentDepartment);
		    student.setStudentGPA(studentGPA);
		    student.setStudentEnrollmentNo(studentEnrollmentNo);

		  _logger.info("Executing Update Student Request Id "+studentId);
		  _logger.info("new student details "+student.toString());

		    return studentLocalService.updateStudent(student);
		}
	
	public Student deleteStudentByID(long studentId) throws PortalException {
		  _logger.info("Deleting Student with id "+studentId);
		   return  studentLocalService.deleteStudent(studentId);
	}
	
	public Student getStudentByID(long studentId) throws PortalException {
		_logger.info("getting student with id "+studentId);
	    return studentLocalService.getStudent(studentId);
	}
   
	//fetching studens with name 
	public List<Student> findStudentsByName(String name){
		_logger.info("fetching student with name "+name);
		return studentPersistence.findByStudentName(name);
	}
	
	
	//fetching students by using Dynamic Query 
	//selecting student with specific ERP Number
    public List<Student> findStudentByERP(String ERP){

    DynamicQuery dynamicQuery= DynamicQueryFactoryUtil.forClass(Student.class, PortalClassLoaderUtil.getClassLoader());
    
    dynamicQuery.add(RestrictionsFactoryUtil.eq("studentEnrollmentNo", ERP)); 

    _logger.info("Executing Dynamic Query for ERP: " + ERP);
    
     List<Student> students = StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
    
      return students;
    }
    
    //custom SQL
    public List<Student> findStudentsGPAGreaterThan(Double gpa){
    	List<Student> students=studentFinder.findByGPAGreaterThan(gpa);
    	return students;
    	
    }
   
}