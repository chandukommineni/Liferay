package com.aixtor.student.web.portlet.action;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.aixtor.student.web.constants.*;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB,
	        "mvc.command.name=/delete_student"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteStudentMVCActionCommand implements MVCActionCommand {

	@Reference
	private  StudentLocalService studentLocalService;
	
	private static Log _logger=LogFactoryUtil.getLog(DeleteStudentMVCActionCommand.class);
	
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		 long studentId = ParamUtil.getLong(actionRequest, "studentId");
		
		 _logger.info("Delete Student  Action Command Invoked "+studentId);

		 
	        try {
	        	
	        	//checking whether student exists or not
	            Student student = studentLocalService.fetchStudent(studentId);
	            if (student != null) {
	            	studentLocalService.deleteStudentByID(studentId);
	            	return true;
	            }
				else{
					_logger.info("Student Not Found to Delete");
				}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	}


}
