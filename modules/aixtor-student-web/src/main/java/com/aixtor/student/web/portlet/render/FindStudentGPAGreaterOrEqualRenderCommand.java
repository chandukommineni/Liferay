package com.aixtor.student.web.portlet.render;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.service.StudentLocalService;
import com.aixtor.student.web.constants.AixtorStudentWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AixtorStudentWebPortletKeys.AIXTORSTUDENTWEB,
                "mvc.command.name=/find_by_gpa_greater_than"
        },
        service = MVCRenderCommand.class
)
public class FindStudentGPAGreaterOrEqualRenderCommand implements MVCRenderCommand {
    @Reference
    private StudentLocalService studentLocalService;

    private static final Log _logger = LogFactoryUtil.getLog(FindStudentByERPRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        double studentGPA= ParamUtil.getDouble(renderRequest, "studentGPA");
        _logger.info("Fetching Students GPA Greater than "+studentGPA);
        List<Student> studentsList=studentLocalService.findStudentsGPAGreaterThan(studentGPA);
        renderRequest.setAttribute("studentsList", studentsList);
        renderRequest.setAttribute("back", true);
        return "/views/studentList.jsp";
    }

}
