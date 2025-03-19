package com.aixtor.student.web.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.aixtor.student.web.constants.*;
import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB, 
	        "mvc.command.name=/add_student_form"
	    },
	    service = MVCRenderCommand.class
	)
public class AddStudentFormMVCRenderCommand implements MVCRenderCommand {

	 private static Log _log=LogFactoryUtil.getLog(AddStudentFormMVCRenderCommand.class);
	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
	        _log.info("------ AddStudent Render Command invoked ------");
	    	return "/views/addStudent.jsp"; 
	    }

}
