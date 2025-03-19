package com.aixtor.student.web.portlet.action;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.aixtor.student.web.constants.AixtorStudentWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB,
	        "mvc.command.name=/add_student"
	    },
	    service = MVCActionCommand.class
	)
public class AddStudentMVCActionCommand implements MVCActionCommand {

	@Reference
    private StudentLocalService studentsLocalService;

    private static final Log _logger = LogFactoryUtil.getLog(AddStudentMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        try {
            // Extract form data
            String studentName = ParamUtil.getString(actionRequest, "studentName");
            String studentDepartment = ParamUtil.getString(actionRequest, "studentDepartment");
            double studentGPA = ParamUtil.getDouble(actionRequest, "studentGPA");
            String enrollmentNo = ParamUtil.getString(actionRequest, "studentEnrollmentNo");
            long mentorId = ParamUtil.getLong(actionRequest, "mentorId");

            _logger.info("Processing Add Student Request: " + studentName);

           

            
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), actionRequest);

           
            Student student = studentsLocalService.addStudent(
            		 studentName,studentDepartment, studentGPA,
        			enrollmentNo,serviceContext);

            _logger.info("Student added successfully: " + student.getStudentId());

            return true;
        } catch (Exception e) {
            _logger.error("Error adding student: " + e.getMessage(), e);
            throw new PortletException(e);
        }
    }

}
