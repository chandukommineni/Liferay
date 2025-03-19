package com.aixtor.student.web.portlet.action;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import com.aixtor.student.web.constants.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB,
	        "mvc.command.name=/edit_student"
	    },
	    service = MVCActionCommand.class
	)
public class EditStudentMVCActionCommand implements MVCActionCommand {

	@Reference
	private StudentLocalService studentLocalService;
	
    private static Log _logger=LogFactoryUtil.getLog(EditStudentMVCActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		    long studentId = ParamUtil.getLong(actionRequest, "studentId");
		    String studentName = ParamUtil.getString(actionRequest, "studentName");
		    String studentDepartment = ParamUtil.getString(actionRequest, "studentDepartment");
		    double studentGPA = (double) ParamUtil.getDouble(actionRequest, "studentGPA");
		    String enrollmentNo = ParamUtil.getString(actionRequest, "enrollmentNo");

		    ServiceContext serviceContext;
		    
		    _logger.info("Edit Action command invoked");
			try {
				serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), actionRequest);
				studentLocalService.updateStudent(studentId, studentName,studentDepartment,studentGPA,enrollmentNo,serviceContext);
				return true;

			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
		return false;
	}
}
