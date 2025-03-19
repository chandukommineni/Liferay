<%@ include file="./init.jsp" %>
<%@ page import="com.aixtor.student.core.model.Student" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<portlet:defineObjects />

<portlet:actionURL name="/edit_student" var="editStudentURL" />

<!-- Retrieve student data from request -->
<c:set var="student" value="${requestScope.student}" />

<div class="container mt-4">
    <h2 class="text-center mb-4">Edit Student</h2>

    <!-- Form to Edit Student -->
    <div class="col-12 col-md-6 mx-auto">
        <form method="post" action="${editStudentURL}">
            <!-- Hidden input for studentId -->
            <input type="hidden" name="<portlet:namespace/>studentId" value="${student.studentId}" />

            <!-- Name Field -->
            <div class="mb-3">
                <label for="<portlet:namespace/>studentName" class="form-label">Name:</label>
                <input type="text" id="<portlet:namespace/>studentName" name="<portlet:namespace/>studentName" 
                       class="form-control" 
                       value="${student.studentName}" required />
            </div>

            <!-- Department Field -->
            <div class="mb-3">
                <label for="<portlet:namespace/>studentDepartment" class="form-label">Department:</label>
                <input type="text" id="<portlet:namespace/>studentDepartment" name="<portlet:namespace/>studentDepartment" 
                       class="form-control" 
                       value="${student.studentDepartment}" required />
            </div>

            <!-- GPA Field -->
            <div class="mb-3">
                <label for="<portlet:namespace/>studentGPA" class="form-label">GPA:</label>
                <input type="text" step="0.01" id="<portlet:namespace/>studentGPA" name="<portlet:namespace/>studentGPA" 
                       class="form-control" 
                       value="<fmt:formatNumber value='${student.studentGPA}' type='number' maxFractionDigits='2' />" required />
            </div>

            <!-- Enrollment No Field -->
            <div class="mb-3">
                <label for="<portlet:namespace/>enrollmentNo" class="form-label">Enrollment No:</label>
                <input type="text" id="<portlet:namespace/>enrollmentNo" name="<portlet:namespace/>enrollmentNo" 
                       class="form-control" 
                       value="${student.studentEnrollmentNo}" required />
            </div>

         

            <button type="submit" class="btn btn-primary btn-lg">Save Changes</button>
        </form>
    </div>
</div>
