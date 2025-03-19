package com.aixtor.student.web.portlet.render;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.aixtor.student.web.constants.AixtorStudentWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB,
                "mvc.command.name=/",
                
        },
        service = MVCRenderCommand.class
)
public class StudentMVCRenderCommand implements MVCRenderCommand {
	@Reference
    private StudentLocalService studentLocalService;
    private static Log _logger=LogFactoryUtil.getLog(StudentMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<Student> studentsList = studentLocalService.getStudents(-1, -1);
        renderRequest.setAttribute("studentsList", studentsList);
        _logger.info("----- Students MVC Render Command Invoked --------");
        _logger.info(studentsList);
   
		return "/views/studentList.jsp";
	}

}
