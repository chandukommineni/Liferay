package com.aixtor.student.web.portlet.render;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.aixtor.student.web.constants.*;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB, 
	        "mvc.command.name=/edit_student_form"
	    },
	    service = MVCRenderCommand.class
	)

public class EditStudentFormMVCRenderCommand implements MVCRenderCommand {
	private static Log _logger=LogFactoryUtil.getLog(EditStudentFormMVCRenderCommand.class);
    @Reference
    private StudentLocalService studentLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long studentId=ParamUtil.getLong(renderRequest,"studentId");
		
		_logger.info("Edit Student Render Invoked "+studentId );
		if (studentId > 0) {
            // Fetch the student from the database using the student ID
            Student student;
			try {
				student = studentLocalService.getStudent(studentId);
				_logger.info("Studend Fetched "+student);
				 renderRequest.setAttribute("student", student);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
           
        }
		return "/views/editStudent.jsp";
	}

}
